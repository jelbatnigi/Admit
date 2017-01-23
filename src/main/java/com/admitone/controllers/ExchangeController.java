package com.admitone.controllers;

import com.admitone.model.Cancellation;
import com.admitone.model.Exchange;
import com.admitone.services.CancellationService;
import com.admitone.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by j_elbatn on 1/22/17.
 */
@Controller
@RequestMapping("/rest")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @ResponseBody
    @RequestMapping(value = "/exchangeTickets", method = RequestMethod.POST)
    public String exchange(@RequestBody Exchange exchange)
    {
        exchangeService.exchageTicket(exchange);

        return "Exchange is Successful";
    }
}
