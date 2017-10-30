package com.luan.dao;

import com.luan.helloejb.lib.models.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class MensagemDAO {

    @Resource(lookup = "jdbc/MensagemDS")
    private DataSource dataSource;

    private Connection connection;

    @PostConstruct
    public void MensagemDAO() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao obter a conexão");
            ex.printStackTrace();
        }
    }

    public Mensagem obterMensagem() throws SQLException {
        String mensagem = "";
        String sql = "SELECT * FROM Mensagem";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.execute();

        ResultSet resultSet = statement.getResultSet();
        if (resultSet.next()) {
            mensagem = resultSet.getString("texto");
        }

        return new Mensagem(mensagem);
    }
}
