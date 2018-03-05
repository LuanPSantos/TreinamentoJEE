package com.luan.myfin.financeiro.base.interfaces;

import com.luan.myfin.financeiro.base.models.Entry;
import java.sql.Date;
import java.util.List;

public interface EntryService {

    public Entry insertEntry(Entry entry) throws Exception;

    public List<Entry> selectEntries(String type, Date initialPeriod, Date finalPeriod, String description) throws Exception;

    public void deleteEntry(Long id) throws Exception;

    public Entry selectEntryById(Long id) throws Exception;
    
    public Entry updateEntry(Entry entry) throws Exception;
}
