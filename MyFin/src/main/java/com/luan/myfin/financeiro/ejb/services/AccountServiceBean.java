package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.ejb.daos.AccountDAO;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
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

        List<Entry> entries = entryDAO.selectEntries(null, fistDayOfCurrentMonth(), lastDayOfCurrentMonth(), null);

        Double total = entries.stream().mapToDouble(Entry::getValue).sum();

        Account account = accountDAO.selectAccount(fistDayOfCurrentMonth());

        //Caso não exista: cria; senão atualiza
        if (account == null) {
            account = new Account();
            account.setValue(total);
            account.setDate(fistDayOfCurrentMonth());
            return accountDAO.insertAccount(account);
        } else {
            account.setValue(total);
            accountDAO.updateAccount(account);
        }
        
        return null;
    }

    @Override
    public Account selectCurrentAccount() {
        Account account = accountDAO.selectAccount(fistDayOfCurrentMonth());

        if (account == null) {
            account = new Account();
            account.setDate(fistDayOfCurrentMonth());
            account.setValue(0d);
            return accountDAO.insertAccount(account);
        } else {
            return account;
        }
    }

    private Date fistDayOfCurrentMonth() {
        LocalDate fistDayOfMonth = today().withDayOfMonth(1);

        return Date.valueOf(fistDayOfMonth);
    }

    private Date lastDayOfCurrentMonth() {
        LocalDate lastDayOfMonth = today().withDayOfMonth(today().lengthOfMonth());

        return Date.valueOf(lastDayOfMonth);
    }

    private LocalDate today() {
        Date date = new Date(System.currentTimeMillis());
        return date.toLocalDate();
    }

}
