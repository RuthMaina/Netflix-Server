package com.example.netflix.services;

import com.example.netflix.models.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    Categories findById(Long id);

    Categories createUsers(Categories categories);

    void delete(Long id);

    Categories update(Categories categories);

    Categories update(Long id, Categories categories);
}
