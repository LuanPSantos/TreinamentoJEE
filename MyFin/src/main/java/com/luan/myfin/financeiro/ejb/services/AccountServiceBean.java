package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryConsolidated;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.base.util.DateUtils;
import com.luan.myfin.financeiro.ejb.daos.AccountDAO;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(AccountService.class)
public class AccountServiceBean implements AccountService {

    @Inject
    private AccountDAO accountDAO;

    @Inject
    private EntryDAO entryDAO;

    @Override
    public Account updateCurrentAccount() {

        Account account = accountDAO.selectAccount(DateUtils.fistDayOfCurrentMonth());

        List<Entry> entries = entryDAO.selectEntries(null, DateUtils.fistDayOfCurrentMonth(), DateUtils.lastDayOfCurrentMonth(), null);
        Map<EntryType, List<Entry>> grouped = entries.stream().collect(Collectors.groupingBy(Entry::getEntryType));

        final Account temp = new Account();
        grouped.keySet().forEach(key -> {
            EntryConsolidated consolidated = new EntryConsolidated();
            consolidated.setTotal(grouped.get(key).stream().mapToDouble(Entry::getEntryValue).sum());
            consolidated.setType(key.getValue());
            temp.addEntryConsolidated(consolidated);
        });

        if (account == null) {
            account = insertAccount(account, temp.getEntries());
        } else {
            account.setEntries(temp.getEntries());
            accountDAO.updateAccount(account);
        }

        return account;
    }

    @Override
    public Account selectCurrentAccount() {
        Account account = accountDAO.selectAccount(DateUtils.fistDayOfCurrentMonth());

        if (account == null) {
            return insertAccount(account, null);
        }
        return account;
    }

    private Account insertAccount(Account account, List<EntryConsolidated> entries) {
        account = new Account();
        account.setAccountDate(DateUtils.fistDayOfCurrentMonth());
        account.setEntries(entries);
        accountDAO.insertAccount(account);
        return accountDAO.selectAccount(DateUtils.fistDayOfCurrentMonth());
    }
}
