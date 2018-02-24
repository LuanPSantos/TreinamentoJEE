package com.luan.myfin.financeiro.base.interfaces;

import com.luan.myfin.financeiro.base.models.Account;

public interface AccountService {

    public void updateCurrentAccount();

    public Account selectCurrentAccount();
}
