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

//            String sql = "UPDATE Account_EntryType ae "
//                    + "    SET total = (SELECT SUM(entry_value) FROM Entry WHERE entry_date >= ? AND entry_date <= ? and entry_type_id = ae.type_id ) "
//                    + "    WHERE ae.account_date = ?";
    }

    public Account insertAccount(Account account) {

//            String sql = "INSERT INTO Account (account_date) values (?)";
        return null;
    }

    public Account selectAccount(Date date) {

//            StringBuilder sql = new StringBuilder();
//            sql.append("SELECT ");
//            sql.append("a.account_date as date, ");
//            sql.append("e.type_id as idType, ");
//            sql.append("ae.total as total ");
//            sql.append("FROM Account a ");
//            sql.append("INNER JOIN Account_EntryType ae ON a.account_date = ae.account_date ");
//            sql.append("INNER JOIN EntryType e on e.type_id = ae.type_id ");
//            sql.append("WHERE a.account_date = ? ");
        return null;
    }
}
