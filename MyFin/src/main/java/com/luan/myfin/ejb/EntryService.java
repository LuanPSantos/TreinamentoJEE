package com.luan.myfin.ejb;

import com.luan.myfin.enums.EntryType;
import com.luan.myfin.models.Entry;
import java.sql.Date;
import java.util.List;

public interface EntryService {

    public Entry insertEntry(Entry entry);

    public List<Entry> selectEntries(EntryType type, Date initialPeriod, Date finalPeriod, String description);
}
