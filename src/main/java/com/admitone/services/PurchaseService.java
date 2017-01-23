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

import java.util.ArrayList;
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

    public void addNewPurchase(Purchase purchase) throws Exception {
        try {
            purchaseDAO.purchaseAshow(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public List<Purchase> getPurchasesByEventId(long showId) throws Exception {

        try {
            return purchaseDAO.getPurchasesByShowId(showId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Purchase getPurchaseByShowAndUser(long userId, long showId) throws Exception {
        try {
            return purchaseDAO.getPurchaseByShowIdAndUserId(userId, showId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void updatePurchase(Purchase purchase) throws Exception {
        try {
            purchaseDAO.updatePurchase(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void updatePurchaseAfterCancellation(Purchase purchase) throws Exception {

        try {
            updatePurchase(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Transactional
    public void addPurchaseAfterExchange(Exchange exchange) throws Exception {
        Purchase purchase = new Purchase();
        purchase.setUserId(exchange.getUserId());
        purchase.setShowId(exchange.getToShowId());
        purchase.setNumberOfTickets(exchange.getNumberOfTickets());
        try {
            addNewPurchase(purchase);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Transactional
    public List<Purchase> getPurchasesByEventsRange(long fromEventId, long toEventId) throws Exception {
        List<Purchase> purchases = new ArrayList<Purchase>();
        try {
            List<Long> showIds = showService.getEventsByIdRange(fromEventId, toEventId);

            purchases = purchaseDAO.getPurchasesByEventIds(showIds);
            } catch (Exception e) {
                throw new Exception(e);
            }

        return purchases;

    }

}
