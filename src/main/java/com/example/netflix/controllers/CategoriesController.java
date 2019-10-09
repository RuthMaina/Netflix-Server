package com.example.netflix.controllers;

import com.example.netflix.models.Categories;
import com.example.netflix.services.CategoriesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "categories")
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

    @GetMapping(value = "{id}")
    public Categories findById(@PathVariable Long id) {
        return categoriesService.findById(id);
    }

    @PostMapping
    public Categories create(@Valid @RequestBody Categories users) {
        return categoriesService.create(users);
    }

    @DeleteMapping(value = "{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("Record deleted", categoriesService.delete(id));
        return response;
    }
}
