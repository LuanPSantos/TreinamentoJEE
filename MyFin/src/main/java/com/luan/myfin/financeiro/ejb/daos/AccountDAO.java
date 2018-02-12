package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.models.Account;
import java.sql.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    public void insertAccount(Account account) {
        entityManager.persist(account);
    }

    public Account selectAccount(Date date) {
        return entityManager.find(Account.class, date);
    }
}
