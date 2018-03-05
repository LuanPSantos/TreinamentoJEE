package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryConsolidated;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.base.util.DateUtils;
import com.luan.myfin.financeiro.ejb.caches.CacheService;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(AccountService.class)
public class AccountServiceBean implements AccountService {

    @Inject
    private EntryDAO entryDAO;

    @EJB
    private CacheService cacheService;

    @Override
    public void updateCurrentAccount() throws Exception{

        List<EntryConsolidated> consolidateds = getEntriesConsolidated();
        Account account = createAccount(consolidateds);
        cacheService.log(account);
    }

    @Override
    public Account selectCurrentAccount() throws Exception{
        List<EntryConsolidated> consolidateds = getEntriesConsolidated();

        Account account = new Account();
        account.setAccountDate(Date.valueOf(LocalDate.now()));
        account.setEntries(consolidateds);

        return account;
    }

    private Account createAccount(List<EntryConsolidated> consolidateds) {
        Account account = new Account();
        account.setAccountDate(Date.valueOf(LocalDate.now()));
        account.setEntries(consolidateds);

        return account;
    }

    private List<EntryConsolidated> getEntriesConsolidated() {
        List<Entry> entries = entryDAO.selectEntries(null, DateUtils.fistDayOfCurrentMonth(), DateUtils.lastDayOfCurrentMonth(), null);
        Map<EntryType, List<Entry>> grouped = entries.stream().collect(Collectors.groupingBy(Entry::getEntryType));

        List<EntryConsolidated> consolidateds = new ArrayList<>();
        grouped.keySet().forEach(key -> {
            EntryConsolidated consolidated = new EntryConsolidated();
            consolidated.setTotal(grouped.get(key).stream().mapToDouble(Entry::getEntryValue).sum());
            consolidated.setType(key.getValue());
            consolidateds.add(consolidated);
        });

        return consolidateds;
    }
}
