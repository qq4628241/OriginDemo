package com.scott.origin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class M2Controller {

    @CrossOrigin
    @RequestMapping("/hello2")
    public String hello(){

        return "hello2";
    }
}
