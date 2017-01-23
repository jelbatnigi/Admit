package com.admitone.services;

import com.admitone.dao.PurchaseDAO;
import com.admitone.model.Cancellation;
import com.admitone.model.Exchange;
import com.admitone.model.Purchase;
import com.admitone.model.Shows;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Service
public class PurchaseService {

    @Autowired
    PurchaseDAO purchaseDAO;

    @Autowired
    ShowService showService;

    public void addNewPurchase(Purchase purchase)
    {
        purchaseDAO.purchaseAshow(purchase);

    }

    public List<Purchase> getPurchasesByEventId(long showId)
    {
        return purchaseDAO.getPurchasesByShowId(showId);
    }

    public Purchase getPurchaseByShowAndUser(long userId, long showId)
    {
        return purchaseDAO.getPurchaseByShowIdAndUserId(userId, showId);
    }

    public void updatePurchase(Purchase purchase)
    {
        purchaseDAO.updatePurchase(purchase);
    }

    public void updatePurchaseAfterCancellation(Purchase purchase)
    {

        updatePurchase(purchase);

    }

    @Transactional
    public void addPurchaseAfterExchange(Exchange exchange)
    {
        Purchase purchase = new Purchase();
        purchase.setUserId(exchange.getUserId());
        purchase.setShowId(exchange.getToShowId());
        purchase.setNumberOfTickets(exchange.getNumberOfTickets());
        addNewPurchase(purchase);

    }

    @Transactional
    public List<Purchase> getPurchasesByEventsRange(long fromEventId, long toEventId)
    {
        List<Long> showIds = showService.getEventsByIdRange(fromEventId, toEventId);

        return purchaseDAO.getPurchasesByEventIds(showIds);

    }

}
