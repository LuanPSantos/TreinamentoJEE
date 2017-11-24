package com.luan.myfin.base.interfaces;

import com.luan.myfin.base.enums.EntryType;
import com.luan.myfin.base.models.Entry;
import java.sql.Date;
import java.util.List;

public interface EntryService {

    public Entry insertEntry(Entry entry);

    public List<Entry> selectEntries(EntryType type, Date initialPeriod, Date finalPeriod, String description);
}
