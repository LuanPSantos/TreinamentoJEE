package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.models.EntryType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EntryTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntryType selectType(String type) {
        return entityManager.find(EntryType.class, type);
    }
    
    public List<EntryType> selectTypes(){
        String hql = "SELECT type FROM EntryType type";
        
        Query query = entityManager.createQuery(hql);
        
        return query.getResultList();
    }
}
