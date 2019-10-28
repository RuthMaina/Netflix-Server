package com.example.netflix.controllers;

import com.example.netflix.models.Categories;
import com.example.netflix.services.CategoriesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("categories")
@CrossOrigin(origins = "http:/localhost:8088")
public class CategoriesController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public List<Categories> findAll() {
        return categoriesService.findAll();
    }

    @GetMapping(value = "{id:[a-zA-Z &+-]*}")
    public Categories findById(@PathVariable String id) {
        return categoriesService.findById(id);
    }

    @PostMapping
    public Categories create(@Valid @RequestBody Categories categories) {
        return categoriesService.create(categories);
    }

    @DeleteMapping(value = "delete/{id:[a-zA-Z &+-]*}")
    public String delete(@PathVariable String id, @RequestParam Long userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("Record deleted ", categoriesService.delete(id, userId));
        return "Record " + categoriesService.delete(id, userId) + " deleted successfully";
    }
}
