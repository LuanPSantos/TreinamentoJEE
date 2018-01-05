package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.models.EntryType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntryTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntryType selectType(String type) {
        return entityManager.find(EntryType.class, type);
    }
}
