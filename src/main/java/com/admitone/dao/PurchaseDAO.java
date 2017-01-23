package com.admitone.dao;

import com.admitone.model.Purchase;
import com.admitone.model.Shows;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by j_elbatn on 1/21/17.
 */
@Repository
public class PurchaseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void purchaseAshow(Purchase purchase)
    {
        entityManager.persist(purchase);
    }

    @Transactional
    public void updatePurchase(Purchase purchase)
    {
        entityManager.merge(purchase);
    }

    @Transactional
    public List<Purchase> getPurchasesByShowId(long showId)
    {
        List<Purchase> purchases = entityManager.createQuery(
                "from Purchase where showId = :showId")
                .setParameter("showId", showId)
                .getResultList();
        return purchases;

    }

    @Transactional
    public Purchase getPurchaseByShowIdAndUserId(long userId, long showId)
    {
        Purchase purchase = (Purchase) entityManager.createQuery(
                "from Purchase where userId = :userId " +
                        "and showId = :showId")
                .setParameter("userId", userId).
                        setParameter("showId", showId).getSingleResult();
        return purchase;

    }

    @Transactional
    public List<Purchase> getPurchasesByEventIds(List<Long> eventIds)
    {
        List<Purchase> purchases = entityManager.createQuery(
                "from Purchase where showId in (:showIds)")
                .setParameter("showIds", eventIds)
                .getResultList();
        return purchases;

    }


}
