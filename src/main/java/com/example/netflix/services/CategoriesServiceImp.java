package com.example.netflix.services;

import com.example.netflix.models.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Override
    public List<Categories> findAll() {
        return null;
    }

    @Override
    public Categories findById(Long id) {
        return null;
    }

    @Override
    public Categories createUsers(Categories categories) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Categories update(Categories categories) {
        return null;
    }

    @Override
    public Categories update(Long id, Categories categories) {
        return null;
    }
}
