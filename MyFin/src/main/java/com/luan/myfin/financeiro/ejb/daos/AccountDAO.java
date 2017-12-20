package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.models.Account;
import com.luan.myfin.financeiro.base.models.Entry;
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
            String sql = "UPDATE Account SET account_value = ? WHERE account_date = ?";

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("\t1 : " + account.getValue().toString());
            statement.setDouble(1, account.getValue());

            System.out.println("\t2 : " + account.getDate().toString());
            statement.setDate(2, account.getDate());

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
            String sql = "INSERT INTO Account (account_value, account_date) values (?, ?)";

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("\t1 : " + account.getValue().toString());
            statement.setDouble(1, account.getValue());

            System.out.println("\t2 : " + account.getDate().toString());
            statement.setDate(2, account.getDate());

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
            String sql = "SELECT * FROM Account WHERE account_date = ?";

            System.out.println("String SQL ==> " + sql);
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("\t1 : " + date.toString());
            statement.setDate(1, date);

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                account = new Account();

                account.setDate(resultSet.getDate("account_date"));
                account.setValue(resultSet.getDouble("account_value"));

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
