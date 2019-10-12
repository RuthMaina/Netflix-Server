package com.example.netflix.services;

import com.example.netflix.NotFoundException;
import com.example.netflix.models.Movies;
import com.example.netflix.repositories.MoviesRepository;

import java.util.List;

public class MoviesServicesImp implements MoviesServices {
    private final MoviesRepository moviesRepository;

    public MoviesServicesImp(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }


    @Override
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies findById(Long id) {
        return moviesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
    }

    @Override
    public Movies create(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public Movies update(Movies movies) {
        return null;
    }

    @Override
    public Movies update(Long id, Movies movies) {
        return null;
    }
}
