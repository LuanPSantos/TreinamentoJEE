package com.luan.beans;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.interfaces.Main;
import com.luan.helloejb.lib.models.Message;
import com.luan.jms.producers.MessageJMSProducer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
@Local(Main.class)
public class MainBean implements Main {

    @EJB
    private MessageDAO dao;
    
    @Inject
    private MessageJMSProducer producer;
    
    @Inject
    private Event<Message> messageEvent;

    public MainBean(MessageDAO dao, Event<Message> messageEvent) {
        this.dao = dao;
        this.messageEvent = messageEvent;
    }

    public MainBean() {
    }

    @Override
    public Message findMessage(String text) {
        Message mensagem = new Message();
        try {
            mensagem = dao.findMessage(text);
            if (mensagem.getTexto().isEmpty()) {
                mensagem.setTexto("Hello EJB!!");
            }
        } catch (SQLException ex) {
            mensagem.setTexto("Deu ruim");
        }

        messageEvent.fire(mensagem);
        return mensagem;
    }

    @Override
    public List<Message> findAllMessage() {
        List<Message> messages = new ArrayList<>();
        try{
            messages = dao.findAllMessage();
        }catch(Exception e){
            messages.add(new Message("Deu ruim"));
        }
        
        producer.sendToQueue(messages.get(0));
        
        return messages;
    }
}
