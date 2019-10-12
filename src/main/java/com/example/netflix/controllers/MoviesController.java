package com.example.netflix.controllers;

import com.example.netflix.models.Movies;
import com.example.netflix.services.MoviesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@CrossOrigin(origins = "http:/localhost:8088")
public class MoviesController {
    private final MoviesServices moviesServices;

    public MoviesController(MoviesServices moviesServices) {
        this.moviesServices = moviesServices;
    }

    @GetMapping
    public List<Movies> findAll() {
        return moviesServices.findAll();
    }

    @GetMapping(value = "{id}")
    public Movies findById(@PathVariable Long id) {
        return moviesServices.findById(id);
    }
}
