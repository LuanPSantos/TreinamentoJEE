package com.luan.myfin.ejb;

import com.luan.myfin.daos.EntryDAO;
import com.luan.myfin.models.Entry;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntryService.class)
public class EntryServiceBean implements EntryService {

    @Inject
    private EntryDAO dao;

    @Override
    public Entry selectEntryById(Long id) {
        return dao.selectEntryById(id);
    }

    @Override
    public Entry insertEntry(Entry entry) {
        return dao.insertEntry(entry);
    }

}
