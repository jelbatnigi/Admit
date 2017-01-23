package com.admitone.dao;

import com.admitone.model.Exchange;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Repository
public class ExchangeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long exchangeTickets(Exchange exchange) throws Exception {
        long exchangeId = 0;
        try {
            entityManager.persist(exchange);
            entityManager.flush();
            exchangeId = exchange.getExchangeId();
        }catch (PersistenceException pe)
        {
            pe.printStackTrace();
            throw new Exception("Unable to exchange Ticket");
        }
        return exchangeId;
    }
}
