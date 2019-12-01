package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmDAO extends CrudRepository<Film,Long> {
    Film findFilmById(long iD);
    List<Film> findAll();
}
