package com.luan.myfin.financeiro.base.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A descrição não pode ser nula.")
    private String description;

    @NotNull(message = "A data não pode ser nula.")
    private Date entryDate;

    @NotNull(message = "O valor não pode ser nulo.")
    @Min(value = 0, message = "Não é possível inserir um lançamento negativo.")
    @Max(value = 100000000, message = "Não é possível inserir um lançamento com valor maior do que 100000000.")
    private Double entryValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "O tipo não pode ser nulo.")
    private EntryType entryType;

    public Entry(Long id) {
        this.id = id;
    }

    public Entry() {
    }

    public Double getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(Double EntryValue) {
        this.entryValue = EntryValue;
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

    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
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
        return "Entry{" + "id=" + id + ", description=" + description + ", date=" + entryDate + ", value=" + entryValue + '}';
    }
}
