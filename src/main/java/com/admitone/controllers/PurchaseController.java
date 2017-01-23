package com.admitone.controllers;

import com.admitone.model.Purchase;
import com.admitone.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_elbatn on 1/21/17.
 */
@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String purchase(@RequestBody Purchase purchase)
    {
        try {
            purchaseService.addNewPurchase(purchase);
        } catch (Exception e) {
            return "FAILED - " + e.getMessage();
        }
        return "Success - A new purchase have been enetered";
    }

    @ResponseBody
    @RequestMapping(value="eventpurchase/{showId}", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> getPurchaseByEvent(@PathVariable(value="showId") long showId)
    {
        List<Purchase> purchases = new ArrayList<Purchase>();

        try {
            purchases = purchaseService.getPurchasesByEventId(showId);
        } catch (Exception e) {
            return new ResponseEntity(purchases, HttpStatus.BAD_REQUEST);
        }
        if(purchases.isEmpty())
        {
            return new ResponseEntity(purchases, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(purchases, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(value="searchEvents/{fromEventId}/{toEventId}", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> getPurchaseInfoByEvenRange(@PathVariable(value="fromEventId") long fromEventId,
                                      @PathVariable(value="toEventId") long toEventId)
    {
        List<Purchase> purchases = new ArrayList<Purchase>();
        try {
            purchases =  purchaseService.getPurchasesByEventsRange(fromEventId, toEventId);
        } catch (Exception e) {
            return new ResponseEntity(purchases, HttpStatus.BAD_REQUEST);
        }
        if(purchases.isEmpty())
        {
            return new ResponseEntity(purchases, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(purchases, HttpStatus.OK);
    }
}
