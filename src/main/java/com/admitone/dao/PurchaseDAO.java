package com.admitone.dao;

import com.admitone.model.Purchase;
import com.admitone.model.Shows;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_elbatn on 1/21/17.
 */
@Repository
public class PurchaseDAO {

    final static Logger logger = Logger.getLogger(PurchaseDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void purchaseAshow(Purchase purchase) throws Exception {
        try {
            entityManager.persist(purchase);
        }
        catch(PersistenceException pe)
        {
            logger.error("Error persisting a Purchase");
            pe.printStackTrace();
            throw new Exception("Error Creating a Purchase Order");
        }
    }

    @Transactional
    public void updatePurchase(Purchase purchase) throws Exception {
        try {
            entityManager.merge(purchase);
        }
        catch(PersistenceException pe)
        {
            logger.error("Error updating a Purchase");
            pe.printStackTrace();
            throw new Exception("Error Updating a Purchase Order");
        }
    }

    @Transactional
    public List<Purchase> getPurchasesByShowId(long showId) throws Exception {
        List<Purchase> purchases = new ArrayList<Purchase>();
        try {
            purchases = entityManager.createQuery(
                    "from Purchase where showId = :showId")
                    .setParameter("showId", showId)
                    .getResultList();
        }catch(Exception e)
        {
            logger.error("Error Getting Purchase Information");
            e.printStackTrace();
            throw new Exception("Error getting Purchase information by id");
        }
        return purchases;

    }

    @Transactional
    public Purchase getPurchaseByShowIdAndUserId(long userId, long showId) throws Exception {
        Purchase purchase = new Purchase();
        try{
            purchase = (Purchase) entityManager.createQuery(
                "from Purchase where userId = :userId " +
                        "and showId = :showId")
                .setParameter("userId", userId).
                            setParameter("showId", showId).getSingleResult();
        }catch(Exception e)
        {
            logger.error("Error Getting Purchase Information");
            e.printStackTrace();
            throw new Exception("Error getting Purchase information by id and user");
        }
        return purchase;

    }

    @Transactional
    public List<Purchase> getPurchasesByEventIds(List<Long> eventIds) throws Exception {
        List<Purchase> purchases = new ArrayList<Purchase>();
        try {
        purchases = entityManager.createQuery(
                "from Purchase where showId in (:showIds)")
                .setParameter("showIds", eventIds)
                .getResultList();
        }catch(Exception e)
        {
            logger.error("Error Getting Purchase Information");
            e.printStackTrace();
            throw new Exception("Error getting Purchase information by event id");
        }
        return purchases;

    }


}
