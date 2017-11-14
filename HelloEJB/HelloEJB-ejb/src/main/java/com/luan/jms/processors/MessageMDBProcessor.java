package com.luan.jms.processors;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.models.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(
        name = "MessageMDBProcessor",
        activationConfig = {
            @ActivationConfigProperty(
                    propertyName = "destinationType",
                    propertyValue = "javax.jms.Queue"
            ),
            @ActivationConfigProperty(
                    propertyName = "destinationLookup",
                    propertyValue = "jms/queues/MessageQueue"
            )
        }
)
public class MessageMDBProcessor implements MessageListener{

    @EJB
    private MessageDAO dao;

    @Override
    public void onMessage(javax.jms.Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            Message myMessage = (Message) objectMessage.getObject();
            myMessage.setTexto(myMessage.getTexto() + " = veio da JMS para um fucking MDB");
            dao.insertMessage(myMessage);
        } catch (JMSException ex) {
            Logger.getLogger(MessageMDBProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MessageMDBProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
