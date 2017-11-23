package com.luan.myfin.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

@Singleton
@Startup
public class DatabaseInitializer {

    @Resource(lookup = "java:jboss/datasources/MyFinDS")
    private DataSource dataSource;

    @PostConstruct
    public void start() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String createTableEntryType = "create table EntryType("
                    + "    type_id int auto_increment,"
                    + "    type_value varchar (100) not null,"
                    + "    primary key (type_id)"
                    + ")";

            String createTableEntry = "create table Entry("
                    + "    entry_id bigint auto_increment,"
                    + "    entry_description varchar(255) not null,"
                    + "    entry_date date not null,"
                    + "    entry_value double not null,"
                    + "    entry_type_id int not null,"
                    + "    primary key(entry_id),"
                    + "    constraint entry_type_id_entry foreign key (entry_type_id) references EntryType (type_id)"
                    + ")";

            String insertIntoEntryType = "insert into EntryType(type_value) values "
                    + "    ('ALIMENTACAO'),"
                    + "    ('MORADIA'),"
                    + "    ('EDUCACAO'),"
                    + "    ('TRANSAPORTE'),"
                    + "    ('SAUDE'),"
                    + "    ('LAZER'),"
                    + "    ('OUTROS');";

            String insertIntoEntry = "insert into Entry(entry_description, entry_date, entry_value, entry_type_id) values"
                    + "    ('Teste',PARSEDATETIME('2017-11-23','yyyy-MM-dd'), 100.0, 1);";

            PreparedStatement statement = connection.prepareStatement(createTableEntryType);
            statement.execute();
            System.out.println("Criando EntryType");

            statement = connection.prepareStatement(createTableEntry);
            statement.execute();
            System.out.println("Criando Entry");

            statement = connection.prepareStatement(insertIntoEntryType);
            statement.execute();
            System.out.println("Populando EntryType");

            statement = connection.prepareStatement(insertIntoEntry);
            statement.execute();
            System.out.println("Populando Entry");

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
}
