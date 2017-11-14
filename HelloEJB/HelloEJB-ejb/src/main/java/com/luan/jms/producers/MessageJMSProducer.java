package com.luan.jms.producers;

import com.luan.helloejb.lib.models.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Stateless
public class MessageJMSProducer {

    @Resource(lookup = "jms/connectionFactories/MessageCF")
    private ConnectionFactory connectionFactory;

    private Connection connection;

    @Resource(lookup = "jms/queues/MessageQueue")
    private Destination destination;

    @PostConstruct
    private void start() {
        try {
            connection = connectionFactory.createConnection();
        } catch (JMSException ex) {
            Logger.getLogger(MessageProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    private void end() {
        try {
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(MessageProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendToQueue(Message message) {

        try(Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE)) {

            MessageProducer producer = session.createProducer(destination);
            ObjectMessage objectMessage = session.createObjectMessage();
            
            objectMessage.setObject(message);
            
            producer.send(objectMessage);
        } catch (JMSException ex) {
            Logger.getLogger(MessageProducer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
