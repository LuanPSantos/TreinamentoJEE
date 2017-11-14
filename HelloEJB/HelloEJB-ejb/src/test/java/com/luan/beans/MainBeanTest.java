package com.luan.beans;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.models.Message;
import java.sql.SQLException;
import javax.enterprise.event.Event;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainBeanTest {

    private MessageDAO mockMensagemDAO;
    private Event<Message> messageEvent;

    @Before
    public void inicializar() {
        mockMensagemDAO = mock(MessageDAO.class);
        messageEvent = mock(Event.class);
        
        doNothing().when(messageEvent).fire(any(Message.class));
    }

    @Test
    public void deve_retornar_a_mensagem_de_sucesso() throws Exception {

        when(mockMensagemDAO.findMessage(any(String.class))).thenReturn(new Message("Standalone funcionando"));

        MainBean mainBean = new MainBean(mockMensagemDAO, messageEvent);

        Message menagem = mainBean.findMessage(any(String.class));

        assertEquals("Standalone funcionando", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_padrao_quando_nao_ha_dados() throws Exception {

        mockMensagemDAO = mock(MessageDAO.class);
        when(mockMensagemDAO.findMessage(any(String.class))).thenReturn(new Message(""));

        MainBean mainBean = new MainBean(mockMensagemDAO, messageEvent);

        Message menagem = mainBean.findMessage(any(String.class));

        assertEquals("Hello EJB!!", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_de_erro() throws Exception {

        mockMensagemDAO = mock(MessageDAO.class);
        when(mockMensagemDAO.findMessage(any(String.class))).thenThrow(new SQLException());

        MainBean mainBean = new MainBean(mockMensagemDAO, messageEvent);

        Message menagem = mainBean.findMessage(any(String.class));

        assertEquals("Deu ruim", menagem.getTexto());
    }
}
