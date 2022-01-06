package com.scott.origin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class M1Controller {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        //http协议原生跨域写法
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许跨域的ip
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1,https://127.0.0.1");
        //前端不必每次都发起option的链接访问，在100秒只需要发起一次
        //response.setHeader("Access-Control-Max-Age", "100");

        return "hello";
    }
}
