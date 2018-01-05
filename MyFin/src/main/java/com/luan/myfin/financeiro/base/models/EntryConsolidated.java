package com.luan.myfin.financeiro.base.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@IdClass(EntryConsolidatedPK.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryConsolidated implements Serializable {

    @Id
    private String type;
    @Id
    private Double total;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
