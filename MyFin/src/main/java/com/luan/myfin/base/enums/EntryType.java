package com.luan.myfin.base.enums;

public enum EntryType {

    ALIMENTACAO(1),
    MORADIA(2),
    EDUCACAO(3),
    TRANSAPORTE(4),
    SAUDE(5),
    LAZER(6),
    OUTROS(7);

    private final Integer id;

    EntryType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static EntryType valueOf(Integer id) {
        for (EntryType type : EntryType.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }

        return null;
    }
}
