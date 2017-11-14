package com.luan.dao;

import com.luan.helloejb.lib.models.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class MessageDAO {

    @Resource(lookup = "jdbc/MessageDS")
    private DataSource dataSource;

    private Connection connection;

    @PostConstruct
    public void start() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao obter a conexão");
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void end() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão");
            ex.printStackTrace();
        }
    }

    public Message findMessage(String text) throws SQLException {
        String message = "";
        String sql = "SELECT * FROM Message where textMessage like ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%".concat(text).concat("%"));
            statement.execute();
            try (ResultSet resultSet = statement.getResultSet()) {
                if (resultSet.next()) {
                    message = resultSet.getString("textMessage");
                }
            }
        }

        return new Message(message);
    }

    public void insertMessage(Message message) throws SQLException {
        String sql = "INSERT INTO message (textMessage) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, message.getTexto() + ", porque sim :)");
            statement.execute();
        }
    }

    public List<Message> findAllMessage() throws SQLException {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM Message";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();

            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    Message message = new Message(resultSet.getString("textMessage"));
                    messages.add(message);
                }
            }
        }

        return messages;
    }
}
