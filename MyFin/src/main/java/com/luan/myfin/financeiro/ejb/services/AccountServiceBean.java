package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.AccountService;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.util.DateUtils;
import com.luan.myfin.financeiro.ejb.daos.AccountDAO;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
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

        if (account == null) {
            return insertAccount(account);
        } else {
            accountDAO.updateAccount(account);
        }
        return null;
    }

    @Override
    public Account selectCurrentAccount() {
        Account account = accountDAO.selectAccount(DateUtils.fistDayOfCurrentMonth());

        if (account == null) {
            return insertAccount(account);
        }
        return account;
    }

    private Account insertAccount(Account account) {
        account = new Account();
        account.setAccountDate(DateUtils.fistDayOfCurrentMonth());
        return accountDAO.insertAccount(account);
    }
}
