package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/auth")
    public String showLoginPage(){
        return "LoginPage";
    }
    @GetMapping("/")
    public String showMainPage(){
        return "MainPage";
    }
    @GetMapping("/game")
    public String showGamePage(){
        return "GamePage";
    }
    @GetMapping("/films")
    public String showStartPageForFilms(){
        return "StartPageForFilms";
    }
    @GetMapping("/map")
    public String showDefaultMap(){
        return "MapPage";
    }
    @GetMapping("/test")
    public String showTestPage(){
        return "TestPages/TestPage";
    }
}
