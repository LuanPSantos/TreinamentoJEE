package com.luan.myfin.financeiro.ejb.caches;

import com.luan.myfin.financeiro.base.models.Account;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class CacheService {

    private List<Account> logs = new ArrayList<>();

    public List<Account> getLogs() {
        return logs;
    }

    public void setLogs(List<Account> logs) {
        this.logs = logs;
    }

    public void log(Account account) {
        System.out.println("Salvando cache:\n\t" + account);
        logs.add(account);
    }
}
