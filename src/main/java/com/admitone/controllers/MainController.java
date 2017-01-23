package com.admitone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String startApp()
    {
        return "login";
    }
}
