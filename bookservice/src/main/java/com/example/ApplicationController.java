package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 03/03/2017.
 */

@RestController
public class ApplicationController {

    @RequestMapping("/")
    public String getIndex(){
        return "BOOK Service Available.";
    }
}
