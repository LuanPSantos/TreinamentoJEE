package com.luan.myfin.financeiro.base.interfaces;

import com.luan.myfin.financeiro.base.models.Entry;
import java.sql.Date;
import java.util.List;

public interface EntryService {

    public Entry insertEntry(Entry entry);

    public List<Entry> selectEntries(String type, Date initialPeriod, Date finalPeriod, String description);

    public void deleteEntry(Long id);

    public Entry selectEntryById(Long id);
    
    public Entry updateEntry(Entry entry);
}
