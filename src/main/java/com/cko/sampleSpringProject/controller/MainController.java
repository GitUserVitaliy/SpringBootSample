package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "loginPage";
    }
    @GetMapping("/")
    public String showMainPage(){
        return "mainPage";
    }
    @GetMapping("/gamePage")
    public String showGamePage(){
        return "gamePage";
    }


}
