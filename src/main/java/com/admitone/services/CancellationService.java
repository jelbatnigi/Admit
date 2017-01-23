package com.admitone.services;

import com.admitone.dao.CancellationDAO;
import com.admitone.dao.PurchaseDAO;
import com.admitone.model.Cancellation;
import com.admitone.model.Exchange;
import com.admitone.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Service
public class CancellationService {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    CancellationDAO cancellationDAO;

    public void CancellTickets(Cancellation cancellation) throws Exception {
        long userId = cancellation.getUserId();
        long showId = cancellation.getShowId();
        Purchase purchase = getPurchaseInformationBeforeCancellation(cancellation);
        if (purchase.getNumberOfTickets() < cancellation.getNumberOfTickets())
        {
            throw new Exception("Tickets held are less that number of tickets");
        }
        try {
            long cancellationId = cancellationDAO.CancellTicket(cancellation);
            cancellation.setCancelationId(cancellationId);
            purchase.setCancellationId(cancellationId);
            purchase.setNumberOfTickets(cancellation.getNumberOfTickets());

            purchaseService.updatePurchaseAfterCancellation(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Transactional
    public long updateCancellationAfterExchange(Exchange exchange) throws Exception {
        Cancellation cancellation = new Cancellation();
        cancellation.setUserId(exchange.getUserId());
        cancellation.setShowId(exchange.getfromShowId());
        cancellation.setNumberOfTickets(exchange.getNumberOfTickets());
        cancellation.setExchangeId(exchange.getExchangeId());
        long cancellationId = 0;
        try {
            cancellationId = cancellationDAO.CancellTicket(cancellation);

            Purchase purchase = getPurchaseInformationBeforeCancellation(cancellation);
            purchase.setCancellationId(cancellationId);
            purchase.setNumberOfTickets(cancellation.getNumberOfTickets());


            purchaseService.updatePurchaseAfterCancellation(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }

        return cancellationId;
    }

    public Purchase getPurchaseInformationBeforeCancellation(Cancellation cancellation) throws Exception {
        Purchase purchase = null;
        try {
            purchase = purchaseService.getPurchaseByShowAndUser(cancellation.getUserId(),cancellation.getShowId());
        } catch (Exception e) {
            throw new Exception(e);
        }
        return purchase;
    }
}
