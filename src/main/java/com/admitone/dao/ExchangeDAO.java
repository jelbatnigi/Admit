package com.admitone.dao;

import com.admitone.model.Exchange;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Repository
public class ExchangeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long exchangeTickets(Exchange exchange)
    {
        entityManager.persist(exchange);
        entityManager.flush();;
        return exchange.getExchangeId();
    }
}
