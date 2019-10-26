package com.example.netflix.services;

import com.example.netflix.models.Movies;

import java.util.List;

public interface MoviesServices {

    List<Movies> findAll();

    Movies findById(String id);

    List<Movies> findByCategoryAndType(String id, String type);

    Movies create(Long user, Movies movies);

    String delete(Long id, Long userId);

    Movies update(Movies movies);

    Movies update(Long id, Long userId, Movies movies);
}
