package com.luan.myfin.ejb;

import com.luan.myfin.daos.EntryDAO;
import com.luan.myfin.enums.EntryType;
import com.luan.myfin.models.Entry;
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
