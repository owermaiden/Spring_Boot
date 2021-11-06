package com.mvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ower")
    public String getRequestMapping2(){
        return "ower";
    }

    @GetMapping
    public String getMappingExample(){
        return "home";
    }

    @PostMapping
    public String postGettingExample(){
        return "ower";
    }
}
