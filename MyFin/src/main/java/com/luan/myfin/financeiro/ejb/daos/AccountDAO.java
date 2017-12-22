package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.models.EntryConsolidated;
import com.luan.myfin.financeiro.base.util.DateUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class AccountDAO {

    @Resource(lookup = "java:jboss/datasources/MyFinDS")
    private DataSource dataSource;

    public void updateAccount(Account account) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "UPDATE Account_EntryType ae "
                    + "    SET total = (SELECT SUM(entry_value) FROM Entry WHERE entry_date >= ? AND entry_date <= ? and entry_type_id = ae.type_id ) "
                    + "    WHERE ae.account_date = ?";

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql);

            //Já é o primeiro dia do mes
            System.out.println("\t1 : " + account.getDate().toString());
            statement.setDate(1, account.getDate());

            System.out.println("\t2 : " + DateUtils.lastDayOfMonth(account.getDate()).toString());
            statement.setDate(2, DateUtils.lastDayOfMonth(account.getDate()));

            System.out.println("\t3 : " + account.getDate().toString());
            statement.setDate(3, account.getDate());
            statement.execute();

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro com banco de dados");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }
    }

    public Account insertAccount(Account account) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO Account (account_date) values (?)";

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("\t1 : " + account.getDate().toString());
            statement.setDate(1, account.getDate());
            statement.execute();

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro com banco de dados");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }

        return account;
    }

    public Account selectAccount(Date date) {
        Account account = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("a.account_date as date, ");
            sql.append("e.type_id as idType, ");
            sql.append("ae.total as total ");
            sql.append("FROM Account a ");
            sql.append("INNER JOIN Account_EntryType ae ON a.account_date = ae.account_date ");
            sql.append("INNER JOIN EntryType e on e.type_id = ae.type_id ");
            sql.append("WHERE a.account_date = ? ");

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql.toString());

            System.out.println("\t1 : " + date.toString());
            statement.setDate(1, date);

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                if (account == null) {
                    account = new Account();
                    account.setDate(resultSet.getDate("date"));
                }

                EntryConsolidated entryConsolidated = new EntryConsolidated();
                entryConsolidated.setType(EntryType.valueOf(resultSet.getInt("idType")));
                entryConsolidated.setTotal(resultSet.getDouble("total"));

                account.addEntryConsolidated(entryConsolidated);
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro com banco de dados");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }

        return account;
    }
}
