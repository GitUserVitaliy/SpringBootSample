package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/testPage")
    public String showTestPage(@RequestParam String argument){
        System.out.println(argument);
        return "testPage";
    }
    @GetMapping("/startPageFilms")
    public String showStartPageFilms(){
        return "startPageFilms";
    }

}
