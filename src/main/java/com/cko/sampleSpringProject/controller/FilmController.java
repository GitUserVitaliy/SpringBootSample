package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmDAO filmDAO;
    @GetMapping("/all")
    public ModelAndView showAllFilms(){
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("FilmService/AllFilms");
        List<Film> listFilms = filmDAO.findAll();
        modelAndView.addObject("films", listFilms);
       return modelAndView;
    }
    @RequestMapping("/add")
    public String showAddFilms(){
        return "FilmService/AddFilm";
    }
    @PostMapping("/edit")
    public RedirectView showEditFilms(Film film){
        filmDAO.save(film);
        return new RedirectView("/FilmService/AllFilms");
    }
    @GetMapping("/test")
    public ModelAndView showTestPage(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(1);
        modelAndView.addObject("firstFilm",film);
        modelAndView.setViewName("test");
        return modelAndView;
    }



}
