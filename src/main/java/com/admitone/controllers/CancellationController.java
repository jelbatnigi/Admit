package com.admitone.controllers;

import com.admitone.model.Cancellation;
import com.admitone.model.Purchase;
import com.admitone.services.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Controller
@RequestMapping("/rest")
public class CancellationController {

    @Autowired
    CancellationService cancellationService;

    @ResponseBody
    @RequestMapping(value = "/cancelTickets", method = RequestMethod.POST)
    public String cancel(@RequestBody Cancellation cancellation)
    {
         cancellationService.CancellTickets(cancellation);

        return "Cancellation is Successful";
    }


}
