package com.example.webfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 30/05/2017.
 */

@RestController
public class WebfeignController {

    @Autowired
    Bookservice bookservice;

    @RequestMapping("/")
    public String index(){
        String message = bookservice.index();
        return "Feign+" + message;
    }
}
