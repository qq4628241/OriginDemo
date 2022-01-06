package com.scott.origin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ProxyController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/api/**")
    public String proxy(HttpServletRequest request){
        String requestURI = request.getRequestURI();

        String pattern = "^(/api)(.*)$";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(requestURI);
        if(matcher.find()){//必须执行find，否则无法获取group信息
            return restTemplate.getForObject("http://localhost:8081"+matcher.group(2), String.class);
        }

        return "not found";
    }

    @RequestMapping("/hello4")
    public String world1() {
        return "hello4";
    }

    public static void main(String[] args) {
        String s = "/api/hello/world";
        String pattern = "^(/api)(.*)$";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(s);
        boolean b = matcher.find();

        String group = matcher.group();
        System.out.println(matcher.groupCount());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));

    }
}
