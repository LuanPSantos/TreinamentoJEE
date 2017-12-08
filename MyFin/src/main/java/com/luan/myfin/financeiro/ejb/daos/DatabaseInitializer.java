package com.luan.myfin.financeiro.ejb.daos;

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
                    + "    ('Teste 1',PARSEDATETIME('2017-11-01','yyyy-MM-dd'), 120.0, 1),"
                    + "    ('Teste 2',PARSEDATETIME('2017-11-02','yyyy-MM-dd'), 140.0, 2),"
                    + "    ('Teste 3',PARSEDATETIME('2017-11-03','yyyy-MM-dd'), 5.41, 1),"
                    + "    ('Teste 4',PARSEDATETIME('2017-11-04','yyyy-MM-dd'), 200.0, 2),"
                    + "    ('Teste 5',PARSEDATETIME('2017-11-05','yyyy-MM-dd'), 200.0, 1),"
                    + "    ('Teste 6',PARSEDATETIME('2017-11-06','yyyy-MM-dd'), 300.0, 3),"
                    + "    ('Teste 7',PARSEDATETIME('2017-11-07','yyyy-MM-dd'), 300.0, 3),"
                    + "    ('Teste 8',PARSEDATETIME('2017-11-08','yyyy-MM-dd'), 400.0, 1),"
                    + "    ('Teste 9',PARSEDATETIME('2017-11-09','yyyy-MM-dd'), 400.0, 6),"
                    + "    ('Teste 10',PARSEDATETIME('2017-11-10','yyyy-MM-dd'), 500.0, 6),"
                    + "    ('Teste 11',PARSEDATETIME('2017-11-11','yyyy-MM-dd'), 500.0, 5),"
                    + "    ('Teste 12',PARSEDATETIME('2017-11-12','yyyy-MM-dd'), 500.0, 2),"
                    + "    ('Teste 13',PARSEDATETIME('2017-11-13','yyyy-MM-dd'), 130.0, 3),"
                    + "    ('Teste 14',PARSEDATETIME('2017-11-14','yyyy-MM-dd'), 140.0, 4),"
                    + "    ('Teste 15',PARSEDATETIME('2017-11-15','yyyy-MM-dd'), 160.0, 1),"
                    + "    ('Teste 16',PARSEDATETIME('2017-11-15','yyyy-MM-dd'), 103.0, 5),"
                    + "    ('Teste 17',PARSEDATETIME('2017-11-15','yyyy-MM-dd'), 102.0, 1),"
                    + "    ('Teste 18',PARSEDATETIME('2017-11-15','yyyy-MM-dd'), 101.0, 5),"
                    + "    ('Teste 19',PARSEDATETIME('2017-11-15','yyyy-MM-dd'), 101.0, 4),"
                    + "    ('Teste 20',PARSEDATETIME('2017-11-16','yyyy-MM-dd'), 102.0, 1),"
                    + "    ('Teste 21',PARSEDATETIME('2017-11-17','yyyy-MM-dd'), 104.0, 3),"
                    + "    ('Teste 22',PARSEDATETIME('2017-11-17','yyyy-MM-dd'), 107.0, 3),"
                    + "    ('Teste 23',PARSEDATETIME('2017-11-18','yyyy-MM-dd'), 108.0, 6),"
                    + "    ('Teste 24',PARSEDATETIME('2017-11-19','yyyy-MM-dd'), 112.0, 6),"
                    + "    ('Teste 25',PARSEDATETIME('2017-11-20','yyyy-MM-dd'), 123.0, 4),"
                    + "    ('Teste 26',PARSEDATETIME('2017-11-21','yyyy-MM-dd'), 156.0, 2),"
                    + "    ('Teste 27',PARSEDATETIME('2017-11-21','yyyy-MM-dd'), 168.0, 1),"
                    + "    ('Teste 28',PARSEDATETIME('2017-11-21','yyyy-MM-dd'), 145.0, 2),"
                    + "    ('Teste 29',PARSEDATETIME('2017-11-21','yyyy-MM-dd'), 134.0, 4),"
                    + "    ('Teste 30',PARSEDATETIME('2017-11-21','yyyy-MM-dd'), 123.0, 4);";

            String createTableAccount = "create table Account("
                    + "    account_date date not null,"
                    + "    account_value double not null default 0,"
                    + "    primary key(account_date)\n"
                    + ");";
            
            String insertIntoAccount = "insert into Account (account_date, account_value) values"
                    + "    (PARSEDATETIME('2017-11-01','yyyy-MM-dd'), 0),"
                    + "    (PARSEDATETIME('2017-10-01','yyyy-MM-dd'), 0);";

            PreparedStatement statement = connection.prepareStatement(createTableEntryType);
            statement.execute();
            System.out.println("Criando EntryType");

            statement = connection.prepareStatement(createTableEntry);
            statement.execute();
            System.out.println("Criando Entry");
            
            statement = connection.prepareStatement(createTableAccount);
            statement.execute();
            System.out.println("Criando Account");

            statement = connection.prepareStatement(insertIntoEntryType);
            statement.execute();
            System.out.println("Populando EntryType");

            statement = connection.prepareStatement(insertIntoEntry);
            statement.execute();
            System.out.println("Populando Entry");

            statement = connection.prepareStatement(insertIntoAccount);
            statement.execute();
            System.out.println("Populando Account");
            
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
