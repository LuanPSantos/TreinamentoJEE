package com.luan.beans;

import com.luan.dao.MensagemDAO;
import com.luan.helloejb.lib.models.Mensagem;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainBeanTest {

    private MensagemDAO mockMensagemDAO;

    @Before
    public void inicializar() {
        mockMensagemDAO = mock(MensagemDAO.class);
    }

    @Test
    public void deve_retornar_a_mensagem_de_sucesso() throws Exception {

        when(mockMensagemDAO.obterMensagem()).thenReturn(new Mensagem("Standalone funcionando"));

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Mensagem menagem = mainBean.obterMensagem();

        assertEquals("Standalone funcionando", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_padrao_quando_nao_ha_dados() throws Exception {

        mockMensagemDAO = mock(MensagemDAO.class);
        when(mockMensagemDAO.obterMensagem()).thenReturn(new Mensagem(""));

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Mensagem menagem = mainBean.obterMensagem();

        assertEquals("Hello EJB!!", menagem.getTexto());
    }

    @Test
    public void deve_retornar_a_mensagem_de_erro() throws Exception {

        mockMensagemDAO = mock(MensagemDAO.class);
        when(mockMensagemDAO.obterMensagem()).thenThrow(new SQLException());

        MainBean mainBean = new MainBean(mockMensagemDAO);

        Mensagem menagem = mainBean.obterMensagem();

        assertEquals("Deu ruim", menagem.getTexto());
    }
}
