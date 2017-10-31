package com.luan.beans;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.interfaces.Main;
import com.luan.helloejb.lib.models.Message;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Main.class)
public class MainBean implements Main {

    @EJB
    private MessageDAO dao;

    public MainBean(MessageDAO dao) {
        this.dao = dao;
    }

    public MainBean() {
    }

    @Override
    public Message findMessage() {
        Message mensagem = new Message();
        try {
            mensagem = dao.findMessage();
            if (mensagem.getTexto().isEmpty()) {
                mensagem.setTexto("Hello EJB!!");
            }
        } catch (SQLException ex) {
            mensagem.setTexto("Deu ruim");
        }

        return mensagem;
    }
}
