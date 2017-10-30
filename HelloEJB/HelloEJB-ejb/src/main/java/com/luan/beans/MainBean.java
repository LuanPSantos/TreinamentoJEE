package com.luan.beans;

import com.luan.dao.MensagemDAO;
import com.luan.helloejb.lib.interfaces.Main;
import com.luan.helloejb.lib.models.Mensagem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Main.class)
public class MainBean implements Main {

    @EJB
    private MensagemDAO dao;

    public MainBean(MensagemDAO dao) {
        this.dao = dao;
    }

    public MainBean() {
    }

    @Override
    public Mensagem obterMensagem() {
        Mensagem mensagem = new Mensagem();
        try {
            mensagem = dao.obterMensagem();
            if (mensagem.getTexto().isEmpty()) {
                mensagem.setTexto("Hello EJB!!");
            }
        } catch (SQLException ex) {
            mensagem.setTexto("Deu ruim");
        }

        return mensagem;
    }
}
