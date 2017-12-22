package com.luan.myfin.financeiro.base.models;

import com.luan.myfin.financeiro.base.enums.EntryType;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Entry implements Serializable {

    private Long id;

    @NotNull(message = "A descrição não pode ser nula.")
    private String description;

    @NotNull(message = "A data não pode ser nula.")
    private Date date;

    @NotNull(message = "O valor não pode ser nulo.")
    @Min(value = 0, message = "Não é possível inserir um lançamento negativo.")
    @Max(value = 10000000000l, message = "Não é possível inserir um lançamento negativo.")
    private Double value;

    @NotNull(message = "O tipo não pode ser nulo.")
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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
