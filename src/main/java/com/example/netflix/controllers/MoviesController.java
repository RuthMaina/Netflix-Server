package com.example.netflix.controllers;

import com.example.netflix.models.Movies;
import com.example.netflix.services.MoviesServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "findById/{id}")
    public Movies findById(@PathVariable Long id) {
        return moviesServices.findById(id);
    }

    @GetMapping(value = "{categoryId}")
    public List<Movies> findByCategoryAndType(@PathVariable String categoryId, @RequestParam(value = "type") String type) {
        return moviesServices.findByCategoryAndType(categoryId, type);
    }

    @PostMapping(value = "{user}")
    public Movies create(@PathVariable Long user, @Valid @RequestBody Movies movies) {
        return moviesServices.create(user, movies);
    }

    @DeleteMapping(value = "delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id, @RequestParam Long userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("Record deleted ", moviesServices.delete(id, userId));
        return response;
    }

    @PutMapping(value = "update/{id}")
    public Movies update(@PathVariable Long id, @RequestParam Long userId, @Valid @RequestBody Movies movies) {
        return moviesServices.update(id, userId, movies);
    }
}
