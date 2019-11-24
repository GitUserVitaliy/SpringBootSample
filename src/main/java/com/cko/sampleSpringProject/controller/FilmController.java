package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/startPageFilms")
public class FilmController {
    @RequestMapping("/allFilms")
    public String showAllFilms(){
        return "filmService/allFilms";
    }
    @RequestMapping("/addFilms")
    public String showAddFilms(){
        return "filmService/addFilms";
    }
    @RequestMapping("/editFilms")
    public String showEditFilms(){
        return "filmService/editFilms";
    }
}
