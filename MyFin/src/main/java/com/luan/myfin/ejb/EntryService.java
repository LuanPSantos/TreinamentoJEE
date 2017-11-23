package com.luan.myfin.ejb;

import com.luan.myfin.models.Entry;

public interface EntryService {

    public Entry selectEntryById(Long id);
}
