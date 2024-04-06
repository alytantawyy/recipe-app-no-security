package com.zosh.recipesharingyoutube.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HomeController {

    @GetMapping
    public String homeController(){
        return "welcome back to code with zosh";
    }
    
}