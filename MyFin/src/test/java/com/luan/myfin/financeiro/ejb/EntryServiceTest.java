package com.luan.myfin.financeiro.ejb;

import com.luan.myfin.daos.EntryDAO;
import org.junit.Before;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class EntryServiceTest {
    
    private EntryDAO entryDao;
    
    @Before
    public void before(){
        entryDao = mock(EntryDAO.class);
    }
    
    @Test
    public void test_that_the_test_works(){
        assertTrue(true);
    }
}
