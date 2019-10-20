package com.example.netflix.services;

import com.example.netflix.models.Movies;

import java.util.List;

public interface MoviesServices {

    List<Movies> findAll();

    List<Movies> findByCategoryAndType(String category, String type);

//    Movies findByCategoryAndType(String setCategories, String type);

    Movies create(Movies movies);

    Long delete(Long id);

    Movies update(Movies movies);

    Movies update(Long id, Movies movies);
}
