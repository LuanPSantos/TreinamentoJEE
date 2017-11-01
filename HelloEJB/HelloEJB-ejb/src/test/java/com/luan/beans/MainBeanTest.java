package com.luan.beans;

import com.luan.dao.MessageDAO;
import com.luan.helloejb.lib.models.Message;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainBeanTest {

    private MessageDAO mockMensagemDAO;

    @Before
    public void inicializar() {
        mockMensagemDAO = mock(MessageDAO.class);
    }

    @Test
    public void deve_retornar_a_mensagem_de_sucesso() throws Exception {

        when(mockMensagemDAO.findMessage()).thenReturn(new Message("Standalone funcionando"));

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Message menagem = mainBean.findMessage();

        assertEquals("Standalone funcionando", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_padrao_quando_nao_ha_dados() throws Exception {

        mockMensagemDAO = mock(MessageDAO.class);
        when(mockMensagemDAO.findMessage()).thenReturn(new Message(""));

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Message menagem = mainBean.findMessage();

        assertEquals("Hello EJB!!", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_de_erro() throws Exception {

        mockMensagemDAO = mock(MessageDAO.class);
        when(mockMensagemDAO.findMessage()).thenThrow(new SQLException());

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Message menagem = mainBean.findMessage();

        assertEquals("Deu ruim", menagem.getTexto());
    }
}
