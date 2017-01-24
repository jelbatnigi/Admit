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
    public void exchageTicket(Exchange exchange) throws Exception {
        long userId = exchange.getUserId();
        long showId = exchange.getfromShowId();
        Purchase purchase = null;
        try {
            purchase = purchaseService.getPurchaseByShowAndUser(userId, showId);
            if (purchase.getNumberOfTickets() < exchange.getNumberOfTickets()) {
                throw new Exception("You Don't Have Enough Tickets to Exchange!");
            }

            long exchangeId = exchangeDAO.exchangeTickets(exchange);
            exchange.setExchangeId(exchangeId);

            cancellationService.updateCancellationAfterExchange(exchange);

            purchaseService.addPurchaseAfterExchange(exchange);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }

    }
}
