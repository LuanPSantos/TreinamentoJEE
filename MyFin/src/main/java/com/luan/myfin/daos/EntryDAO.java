package com.luan.myfin.daos;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class EntryDAO {

    @Resource(lookup = "java:jboss/datasources/MyFinDS")
    private DataSource dataSource;

    public String getConnection() {
        try {
            dataSource.getConnection();
            return "DEU BOM";
        } catch (SQLException ex) {
            return "DEU RUIM";
        }
    }
}
