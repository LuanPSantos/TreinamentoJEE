package com.luan.myfin.financeiro.ejb.daos;

import com.luan.myfin.financeiro.base.models.Entry;
import com.luan.myfin.financeiro.base.models.EntryType;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EntryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Entry insertEntry(Entry entry) {

        entityManager.persist(entry);
        entityManager.flush();

        return entry;
    }

    public void deleteEntry(Long id) {
        Entry entry = mergeById(id);

        entityManager.remove(entry);
    }

    public Entry selectEntryById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    public Entry mergeById(Long id) {
        Entry entry = new Entry(id);

        return entityManager.merge(entry);
    }

    public List<Entry> selectEntries(EntryType type, Date initialPeriod, Date finalPeriod, String description) {
        StringBuilder hql = new StringBuilder("SELECT e FROM Entry e WHERE 1 = 1 ");

        if (type != null) {
            hql.append("AND e.entryType.id = :type ");
        }

        if (initialPeriod != null || finalPeriod != null) {
            if (initialPeriod != null && finalPeriod == null) {
                hql.append("AND e.entryDate >= :initialPeriod ");
            }

            if (initialPeriod == null && finalPeriod != null) {
                hql.append("AND e.entryDate <= :finalPeriod ");
            }

            if (initialPeriod != null && finalPeriod != null) {
                hql.append("AND e.entryDate BETWEEN :initialPeriod AND :finalPeriod ");
            }
        }

        if (description != null) {
            hql.append("AND e.description like :description ");
        }

        System.out.println("String SQL ==> " + hql.toString());

        Query query = entityManager.createQuery(hql.toString());

        if (type != null) {
            query.setParameter("type", type.getValue());
            System.out.println("\t type : " + type.getValue());
        }

        if (initialPeriod != null || finalPeriod != null) {
            if (initialPeriod != null && finalPeriod == null) {
                query.setParameter("initialPeriod", initialPeriod);
                System.out.println("\t initialPeriod : " + initialPeriod);
            }

            if (initialPeriod == null && finalPeriod != null) {
                query.setParameter("finalPeriod", finalPeriod);
                System.out.println("\t finalPeriod : " + finalPeriod);
            }

            if (initialPeriod != null && finalPeriod != null) {
                query.setParameter("initialPeriod", initialPeriod);
                System.out.println("\t initialPeriod : " + initialPeriod);

                query.setParameter("finalPeriod", finalPeriod);
                System.out.println("\t finalPeriod : " + finalPeriod);
            }
        }

        if (description != null) {
            query.setParameter("description", "%" + description + "%");
            System.out.println("\t description : " + description);
        }
        return query.getResultList();
    }

    public Entry updateEntry(Entry entry) {

        return entityManager.merge(entry);
    }
}
