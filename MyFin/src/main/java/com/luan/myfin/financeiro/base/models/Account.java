package com.luan.myfin.financeiro.base.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

    @Id
    @Column("account_date")
    private Date date;
    
    @Transient
    private List<EntryConsolidated> entries;

    public Account() {
        entries = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<EntryConsolidated> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryConsolidated> entries) {
        this.entries = entries;
    }

    public void addEntryConsolidated(EntryConsolidated entryConsolidated) {
        entries.add(entryConsolidated);
    }

}
