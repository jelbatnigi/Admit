package com.admitone.dao;

import com.admitone.model.Cancellation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Repository
public class CancellationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long CancellTicket(Cancellation cancellation)
    {
        entityManager.persist(cancellation);
        entityManager.flush();;
        return cancellation.getCancelationId();
    }
}
