package com.admitone.services;

import com.admitone.dao.CancellationDAO;
import com.admitone.dao.ExchangeDAO;
import com.admitone.model.Cancellation;
import com.admitone.model.Exchange;
import com.admitone.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by j_elbatn on 1/22/17.
 */

@Service
public class ExchangeService {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    CancellationService cancellationService;

    @Autowired
    ExchangeDAO exchangeDAO;

    @Transactional
    public boolean exchageTicket(Exchange exchange)
    {
        long userId = exchange.getUserId();
        long showId = exchange.getfromShowId();
        Purchase purchase = purchaseService.getPurchaseByShowAndUser(userId,showId);
        if (purchase.getNumberOfTickets() < exchange.getNumberOfTickets())
        {
            System.out.println("you don't have enough ticket to exchange");
            return false;
        }

        long exchangeId = exchangeDAO.exchangeTickets(exchange);
        exchange.setExchangeId(exchangeId);

        cancellationService.updateCancellationAfterExchange(exchange);

        purchaseService.addPurchaseAfterExchange(exchange);

        return true;

    }
}
