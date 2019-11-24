package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films")
public class FilmController {
    @RequestMapping("/all")
    public String showAllFilms(){
        return "FilmService/AllFilms";
    }
    @RequestMapping("/add")
    public String showAddFilms(){
        return "FilmService/AddFilm";
    }
    @RequestMapping("/edit")
    public String showEditFilms(){
        return "FilmService/EditFilm";
    }
}
