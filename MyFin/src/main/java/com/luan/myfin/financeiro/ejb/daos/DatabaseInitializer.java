package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.models.EntryType;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class DatabaseInitializer {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void start() {
        EntryType type1 = new EntryType("ALIMENTACAO");
        EntryType type2 = new EntryType("MORADIA");
        EntryType type3 = new EntryType("EDUCACAO");
        EntryType type4 = new EntryType("TRANSPORTE");
        EntryType type5 = new EntryType("SAUDE");
        EntryType type6 = new EntryType("LAZER");
        EntryType type7 = new EntryType("OUTROS");
        
        entityManager.persist(type1);
        entityManager.persist(type2);
        entityManager.persist(type3);
        entityManager.persist(type4);
        entityManager.persist(type5);
        entityManager.persist(type6);
        entityManager.persist(type7);
    }
}
