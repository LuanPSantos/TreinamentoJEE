package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.EntryService;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.ejb.daos.EntryTypeDAO;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntryService.class)
public class EntryServiceBean implements EntryService {

    @Inject
    private EntryDAO entryDao;

    @Inject
    private EntryTypeDAO entryTypeDAO;

    public EntryServiceBean(EntryDAO dao) {
        this.entryDao = dao;
    }

    public EntryServiceBean() {
    }

    @Override
    public Entry insertEntry(Entry entry) {
        return entryDao.insertEntry(entry);
    }

    @Override
    public List<Entry> selectEntries(String type, Date initialPeriod, Date finalPeriod, String description) {
        EntryType entryType = entryTypeDAO.selectType(type);
        System.out.println("\n\n" + entryType.getValue() + "\n\n\n" );
        return entryDao.selectEntries(entryType, initialPeriod, finalPeriod, description);
    }

    @Override
    public void deleteEntry(Long id) {
        entryDao.deleteEntry(id);
    }

    @Override
    public Entry selectEntryById(Long id) {
        return entryDao.selectEntryById(id);
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return entryDao.updateEntry(entry);
    }

}
