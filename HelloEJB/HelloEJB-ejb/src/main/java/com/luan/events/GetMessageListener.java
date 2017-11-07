package com.luan.events;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.models.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class GetMessageListener {
    
    @EJB
    private MessageDAO dao;
    
    public void listenToMessage(@Observes Message message){
        
        try {
            dao.insertMessage(message);
        } catch (SQLException ex) {
            Logger.getLogger(GetMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Logger.getLogger(GetMessageListener.class.getName()).log(Level.INFO, "EVENTO DISPARADO: {0}", message.getTexto());
        System.out.println("EVENTO DISPARADO: " + message.getTexto());
    }
}
