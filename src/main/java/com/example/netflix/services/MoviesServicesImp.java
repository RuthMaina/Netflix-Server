package com.example.netflix.services;

import com.example.netflix.models.Movies;
import com.example.netflix.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<Movies> findByCategoryAndType(String category, String type) {
        return moviesRepository.findByCategoryAndType(category, type);
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
