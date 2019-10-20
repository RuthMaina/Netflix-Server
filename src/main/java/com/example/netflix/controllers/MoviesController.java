package com.example.netflix.controllers;

import com.example.netflix.models.Movies;
import com.example.netflix.services.MoviesServices;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "{category}")
    public List<Movies> findByCategoryAndType(@PathVariable(value = "category") String category, @RequestParam(value = "type") String type) {
        return moviesServices.findByCategoryAndType(category, type);
    }

//    @GetMapping(value = "{setCategories}")
//    public Movies findByCategoryType(@PathVariable(value = "setCategories") String setCategories, @RequestParam(value = "type") String type) {
//        return moviesServices.findByCategoryAndType(setCategories, type);
//    }

    @PostMapping
    public Movies create(@Valid @RequestBody Movies movies) {
        return moviesServices.create(movies);
    }
}
