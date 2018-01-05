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

        //Solução para gardar a sequencia certa de indices dos parametro ? do statemet
        // int index = 0;
        // Map<String, Integer> indexStatement = new HashMap<>();
        if (type != null) {
            hql.append("AND e.entryType.id = :type ");
            //indexStatement.put("entry_type_id", ++index);
        }

        if (initialPeriod != null || finalPeriod != null) {
            if (initialPeriod != null && finalPeriod == null) {
                hql.append("AND e.entryDate >= :initialPeriod ");
                // indexStatement.put("entry_date", ++index);
            }

            if (initialPeriod == null && finalPeriod != null) {
                hql.append("AND e.entryDate <= :finalPeriod ");
                //indexStatement.put("entry_date", ++index);
            }

            if (initialPeriod != null && finalPeriod != null) {
                hql.append("AND e.entryDate BETWEEN :initialPeriod AND :finalPeriod ");
                //indexStatement.put("entry_date_left", ++index);
                //indexStatement.put("entry_date_right", ++index);
            }
        }

        if (description != null) {
            hql.append("AND e.description like :description ");
            //indexStatement.put("entry_description", ++index);
        }

        System.out.println("String SQL ==> " + hql.toString());

        Query query = entityManager.createQuery(hql.toString());

        if (type != null) {
            query.setParameter("type", type.getValue());
            //statement.setInt(indexStatement.get("entry_type_id"), type.getId());
            System.out.println("\t type : " + type.getValue());
        }

        if (initialPeriod != null || finalPeriod != null) {
            if (initialPeriod != null && finalPeriod == null) {
                query.setParameter("initialPeriod", initialPeriod);
                //statement.setDate(indexStatement.get("entry_date"), initialPeriod);
                System.out.println("\t initialPeriod : " + initialPeriod);
            }

            if (initialPeriod == null && finalPeriod != null) {
                query.setParameter("finalPeriod", finalPeriod);
                //statement.setDate(indexStatement.get("entry_date"), finalPeriod);
                System.out.println("\t finalPeriod : " + finalPeriod);
            }

            if (initialPeriod != null && finalPeriod != null) {
                query.setParameter("initialPeriod", initialPeriod);
                //statement.setDate(indexStatement.get("entry_date_left"), initialPeriod);
                System.out.println("\t initialPeriod : " + initialPeriod);

                query.setParameter("finalPeriod", finalPeriod);
                //statement.setDate(indexStatement.get("entry_date_right"), finalPeriod);
                System.out.println("\t finalPeriod : " + finalPeriod);
            }
        }

        if (description != null) {
            query.setParameter("description", "%" + description + "%");
            //statement.setString(indexStatement.get("entry_description"), "%" + description + "%");
            System.out.println("\t description : " + description);
        }
        return query.getResultList();
    }

    public Entry updateEntry(Entry entry) {

        //String sql = "UPDATE Entry SET entry_description = ?, entry_date = ?, entry_value = ?, entry_type_id = ? WHERE entry_id = ?";
        return null;
    }
}
