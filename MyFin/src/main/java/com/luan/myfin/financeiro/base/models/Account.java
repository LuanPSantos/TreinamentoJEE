package com.luan.myfin.financeiro.base.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

    @Id
    private Date accountDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<EntryConsolidated> entries;

    public Account() {
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public List<EntryConsolidated> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryConsolidated> entries) {
        this.entries = entries;
    }

    public void addEntryConsolidated(EntryConsolidated entryConsolidated) {
        createIfNotExists();
        entries.add(entryConsolidated);
    }
    
    private void createIfNotExists(){
        if(entries == null){
            entries = new ArrayList<>();
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.accountDate, other.accountDate);
    }

    @Override
    public String toString() {
        return "Account{" + "accountDate=" + accountDate + ", entries=" + entries + '}';
    }

}
