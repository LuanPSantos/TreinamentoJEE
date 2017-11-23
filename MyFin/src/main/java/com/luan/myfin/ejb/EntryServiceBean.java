
package com.luan.myfin.ejb;

import com.luan.myfin.daos.EntryDAO;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntryService.class)
public class EntryServiceBean implements EntryService{
    
    @Inject
    private EntryDAO dao;

    @Override
    public String teste() {
        return dao.getConnection();
    }
    
}
