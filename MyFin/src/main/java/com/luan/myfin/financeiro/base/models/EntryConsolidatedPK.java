package com.luan.myfin.financeiro.base.models;

import java.io.Serializable;
import java.util.Objects;

public class EntryConsolidatedPK implements Serializable {

    private String type;
    private Double total;

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
        final EntryConsolidatedPK other = (EntryConsolidatedPK) obj;
        if (this.type == null ? other.type != null : !this.type.equals(other.type)) {
            return false;
        }
        return Objects.equals(this.total, other.total);
    }

}
