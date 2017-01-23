package com.admitone.controllers;

import com.admitone.model.Purchase;
import com.admitone.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        purchaseService.addNewPurchase(purchase);
        return "Success";
    }

    @ResponseBody
    @RequestMapping(value="eventpurchase/{showId}", method = RequestMethod.GET)
    public List<Purchase> getPurchaseByEvent(@PathVariable(value="showId") long showId)
    {
        List<Purchase> purchases = purchaseService.getPurchasesByEventId(showId);
        return purchases;

    }

    @ResponseBody
    @RequestMapping(value="searchEvents/{fromEventId}/{toEventId}", method = RequestMethod.GET)
    public List<Purchase>getPurchaseInfoByEvenRange(@PathVariable(value="fromEventId") long fromEventId,
                                      @PathVariable(value="toEventId") long toEventId)
    {
        System.out.println("search events");
        return purchaseService.getPurchasesByEventsRange(fromEventId, toEventId);
    }
}
