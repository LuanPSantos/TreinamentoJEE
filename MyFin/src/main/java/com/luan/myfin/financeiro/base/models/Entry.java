package com.luan.myfin.financeiro.base.models;

import com.luan.myfin.financeiro.base.enums.EntryType;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Entry implements Serializable {

    private Long id;
    private String description;
    private Date date;
    private Double value;
    private EntryType type;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date.toLocalDate();
    }

    public void setDate(LocalDate date) {
        this.date = Date.valueOf(date);
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Entry other = (Entry) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Entry{" + "id=" + id + ", description=" + description + ", date=" + date + ", value=" + value + '}';
    }
}
