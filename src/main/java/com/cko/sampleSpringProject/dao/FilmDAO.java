package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmDAO extends CrudRepository<Film,Long> {

}
