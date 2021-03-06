package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.enums.EntryType;
import com.luan.myfin.financeiro.base.models.Entry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            System.out.println("String SQL ==> " + sql);

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.println("\t1 : " + entry.getDescription());
            statement.setString(1, entry.getDescription());
            System.out.println("\t2 : " + entry.getDate());
            statement.setDate(2, entry.getDate());
            System.out.println("\t3 : " + entry.getValue());
            statement.setDouble(3, entry.getValue());
            System.out.println("\t4 : " + entry.getType());
            statement.setInt(4, entry.getType().getId());

            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                entry.setId(resultSet.getLong(1));
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

    public void deleteEntry(Long id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "DELETE FROM Entry WHERE entry_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

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

    public Entry selectEntryById(Long id) {
        Entry entry = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM Entry WHERE entry_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                entry = new Entry();

                entry.setId(resultSet.getLong("entry_id"));
                entry.setDescription(resultSet.getString("entry_description"));
                entry.setDate(resultSet.getDate("entry_date"));
                entry.setValue(resultSet.getDouble("entry_value"));
                entry.setType(EntryType.valueOf(resultSet.getInt("entry_type_id")));

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

        return entry;
    }

    public List<Entry> selectEntries(EntryType type, Date initialPeriod, Date finalPeriod, String description) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM Entry WHERE 1 = 1 ");

            //Solução para gardar a sequencia certa de indices dos parametro ? do statemet
            int index = 0;
            Map<String, Integer> indexStatement = new HashMap<>();
            if (type != null) {
                sql.append("AND entry_type_id = ? ");
                indexStatement.put("entry_type_id", ++index);
            }

            if (initialPeriod != null || finalPeriod != null) {
                if (initialPeriod != null && finalPeriod == null) {
                    sql.append("AND entry_date >= ? ");
                    indexStatement.put("entry_date", ++index);
                }

                if (initialPeriod == null && finalPeriod != null) {
                    sql.append("AND entry_date <= ? ");
                    indexStatement.put("entry_date", ++index);
                }

                if (initialPeriod != null && finalPeriod != null) {
                    sql.append("AND entry_date BETWEEN ? AND ? ");
                    indexStatement.put("entry_date_left", ++index);
                    indexStatement.put("entry_date_right", ++index);
                }
            }

            if (description != null) {
                sql.append("AND entry_description like ? ");
                indexStatement.put("entry_description", ++index);
            }

            System.out.println("String SQL ==> " + sql.toString());

            PreparedStatement statement = connection.prepareStatement(sql.toString());

            if (type != null) {
                statement.setInt(indexStatement.get("entry_type_id"), type.getId());
                System.out.println("\t" + indexStatement.get("entry_type_id") + " : " + type.getId());
            }

            if (initialPeriod != null || finalPeriod != null) {
                if (initialPeriod != null && finalPeriod == null) {
                    statement.setDate(indexStatement.get("entry_date"), initialPeriod);
                    System.out.println("\t" + indexStatement.get("entry_date") + " : " + initialPeriod);
                }

                if (initialPeriod == null && finalPeriod != null) {
                    statement.setDate(indexStatement.get("entry_date"), finalPeriod);
                    System.out.println("\t" + indexStatement.get("entry_date") + " : " + finalPeriod);
                }

                if (initialPeriod != null && finalPeriod != null) {
                    statement.setDate(indexStatement.get("entry_date_left"), initialPeriod);
                    System.out.println("\t" + indexStatement.get("entry_date_left") + " : " + initialPeriod);

                    statement.setDate(indexStatement.get("entry_date_right"), finalPeriod);
                    System.out.println("\t" + indexStatement.get("entry_date_right") + " : " + finalPeriod);
                }
            }

            if (description != null) {
                statement.setString(indexStatement.get("entry_description"), "%" + description + "%");
                System.out.println("\t" + indexStatement.get("entry_description") + " : " + description);
            }

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            List<Entry> entries = new ArrayList<>();
            while (resultSet.next()) {
                Entry entry = new Entry();

                entry.setId(resultSet.getLong("entry_id"));
                entry.setDescription(resultSet.getString("entry_description"));
                entry.setDate(resultSet.getDate("entry_date"));
                entry.setValue(resultSet.getDouble("entry_value"));
                entry.setType(EntryType.valueOf(resultSet.getInt("entry_type_id")));

                entries.add(entry);
            }

            resultSet.close();
            statement.close();

            return entries;
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

    public Entry updateEntry(Entry entry) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "UPDATE Entry SET entry_description = ?, entry_date = ?, entry_value = ?, entry_type_id = ? WHERE entry_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, entry.getDescription());
            statement.setDate(2, entry.getDate());
            statement.setDouble(3, entry.getValue());
            statement.setInt(4, entry.getType().getId());
            statement.setLong(5, entry.getId());

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

        return entry;
    }
}
