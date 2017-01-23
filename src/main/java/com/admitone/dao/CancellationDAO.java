package com.admitone.dao;

import com.admitone.model.Cancellation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Repository
public class CancellationDAO {
    final static Logger logger = Logger.getLogger(CancellationDAO.class);


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long CancellTicket(Cancellation cancellation) throws Exception {
        long cancellationId = 0;
        try {
            entityManager.persist(cancellation);
            entityManager.flush();
            cancellationId = cancellation.getCancelationId();
        }catch (PersistenceException pe)
        {
            pe.printStackTrace();
            throw new Exception("Unable to Cancel ticket");
        }
        return cancellationId;
    }
}
