package com.mvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    /*
    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ower")
    public String getRequestMapping2(){
        return "ower";
    }

     */

    @GetMapping("/home")
    public String getMappingExample(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableExample(@PathVariable("name") String name){
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableExample(@PathVariable("name") String name, @PathVariable("email") String email){
        System.out.println(name);
        return "home";
    }

    @GetMapping("/home/course")
    public String requestParamExample(@RequestParam("course") String course){
        System.out.println(course);
        return "home";
    }

    @GetMapping(value = "/course")
    public String requestParamExample2(@RequestParam(value = "name", required = true, defaultValue = "Cybertek") String name){
        System.out.println(name);
        return "home";
    }

    @PostMapping
    public String postGettingExample(){
        return "ower";
    }


}
