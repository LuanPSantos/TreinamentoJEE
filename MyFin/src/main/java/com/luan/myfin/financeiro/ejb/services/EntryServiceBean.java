package com.luan.myfin.financeiro.ejb.services;

import com.luan.myfin.financeiro.base.interfaces.EntryService;
import com.luan.myfin.financeiro.ejb.daos.EntryDAO;
import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryType;
import com.luan.myfin.financeiro.ejb.daos.EntryTypeDAO;
import com.luan.myfin.financeiro.ejb.events.EntryEvent;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.event.Event;

@Stateless
@Local(EntryService.class)
public class EntryServiceBean implements EntryService {

    @Inject
    private EntryDAO entryDao;

    @Inject
    private EntryTypeDAO entryTypeDAO;

    @Inject
    private Event<EntryEvent> entryEvent;

    public EntryServiceBean(EntryDAO dao) {
        this.entryDao = dao;
    }

    public EntryServiceBean() {
    }

    @Override
    public Entry insertEntry(Entry entry) throws Exception{
        Entry insertedEntry = entryDao.insertEntry(entry);

        fireEvent();

        return insertedEntry;
    }

    @Override
    public List<Entry> selectEntries(String type, Date initialPeriod, Date finalPeriod, String description) throws Exception{
        EntryType entryType = null;
        if (type != null) {
            entryType = entryTypeDAO.selectType(type);
            System.out.println("\n\n" + entryType.getValue() + "\n\n\n");
        }
        return entryDao.selectEntries(entryType, initialPeriod, finalPeriod, description);
    }

    @Override
    public void deleteEntry(Long id) throws Exception{
        entryDao.deleteEntry(id);
        fireEvent();
    }

    @Override
    public Entry selectEntryById(Long id) throws Exception{
        return entryDao.selectEntryById(id);
    }

    @Override
    public Entry updateEntry(Entry entry) throws Exception{

        Entry attached = entryDao.selectEntryById(entry.getId());
        attached.setDescription(entry.getDescription());
        attached.setEntryDate(entry.getEntryDate());
        attached.setEntryType(entry.getEntryType());
        attached.setEntryValue(entry.getEntryValue());
        Entry updatedEntry = entryDao.updateEntry(attached);
        fireEvent();
        return updatedEntry;
    }

    private void fireEvent() {
        entryEvent.fire(new EntryEvent());
    }

}
