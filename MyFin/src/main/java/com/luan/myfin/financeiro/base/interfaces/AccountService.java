package com.luan.myfin.financeiro.base.interfaces;

import com.luan.myfin.financeiro.base.models.Account;


public interface AccountService {

    public Account updateCurrentAccount();
    
    public Account selectCurrentAccount();
}
