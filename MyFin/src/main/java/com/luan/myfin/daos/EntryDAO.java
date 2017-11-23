package com.luan.myfin.daos;

import com.luan.myfin.enuns.EntryType;
import com.luan.myfin.models.Entry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class EntryDAO {

    @Resource(lookup = "java:jboss/datasources/MyFinDS")
    private DataSource dataSource;

    public Entry insertEntry(Entry entry) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO Entry (entry_description, entry_date, entry_value, entry_type_id) values (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, entry.getDescription());
            statement.setDate(2, Date.valueOf(entry.getDate()));
            statement.setDouble(3, entry.getValue());
            statement.setInt(4, entry.getType().getId());

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                entry.setId(resultSet.getLong("entry_id"));
            }

            resultSet.close();
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

        return entry;
    }

    public Entry selectEntryById(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM Entry WHERE entry_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                Entry entry = new Entry();

                entry.setId(resultSet.getLong("entry_id"));
                entry.setDescription(resultSet.getString("entry_description"));
                entry.setDate(LocalDate.from(Instant.ofEpochMilli(resultSet.getDate("entry_date").getTime())));
                entry.setValue(resultSet.getDouble("entry_value"));
                entry.setType(EntryType.valueOf(resultSet.getInt("entry_type_id")));

                return entry;
            }

            resultSet.close();
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

        return null;
    }
}
