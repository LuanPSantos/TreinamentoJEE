package com.luan.myfin.ejb.services;

import com.luan.myfin.base.interfaces.EntryService;
import com.luan.myfin.ejb.daos.EntryDAO;
import com.luan.myfin.base.enums.EntryType;
import com.luan.myfin.base.models.Entry;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntryService.class)
public class EntryServiceBean implements EntryService {

    @Inject
    private EntryDAO dao;

    public EntryServiceBean(EntryDAO dao) {
        this.dao = dao;
    }

    public EntryServiceBean() {
    }

    @Override
    public Entry insertEntry(Entry entry) {
        return dao.insertEntry(entry);
    }

    @Override
    public List<Entry> selectEntries(EntryType type, Date initialPeriod, Date finalPeriod, String description) {
        return dao.selectEntries(type, initialPeriod, finalPeriod, description);
    }

}
