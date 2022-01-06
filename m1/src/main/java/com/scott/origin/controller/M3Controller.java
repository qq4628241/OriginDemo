package com.scott.origin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class M3Controller {

    @RequestMapping("/hello3")
    public String hello3(){
        return "hello3";
    }

    @RequestMapping("/hello5")
    public String hello5(){
        return "myFun('"+"hello5"+"')";
    }
}
