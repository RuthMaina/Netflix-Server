package com.example.netflix.services;

import com.example.netflix.models.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    Categories findById(String id);

    Categories create(Categories categories);

    String delete(String id, Long userId);

//    Categories update(Categories categories);

//    Categories update(Long id, Categories categories);
}
