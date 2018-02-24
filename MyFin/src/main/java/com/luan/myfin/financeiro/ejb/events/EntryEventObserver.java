package com.luan.myfin.financeiro.ejb.events;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class EntryEventObserver {

    @EJB
    private AccountService accountService;

    public void listenToEntry(@Observes EntryEvent entryEvent) {
        accountService.updateCurrentAccount();
    }
}
