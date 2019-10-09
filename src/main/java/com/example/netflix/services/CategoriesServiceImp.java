package com.example.netflix.services;

import com.example.netflix.models.Categories;
import com.example.netflix.repositories.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImp(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Categories> findAll() {
        return null;
    }

    @Override
    public Categories findById(Long id) {
        return null;
    }

    @Override
    public Categories create(Categories categories) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        try {
            categoriesRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

//    @Override
//    public Categories update(Categories categories) {
//        Categories foundCounties = findById(categories.getId());
//        foundCounties.setCategory(categories.getCategory());
//        //do fo all fields
//        return categoriesRepository.save(foundCounties);
//    }

//    @Override
//    public Categories update(Long id, Categories categories) {
//        Categories foundCategories = findById(id);
//        foundCategories.setCategory(categories.getCategory());
//        return categoriesRepository.save(foundCategories);
//    }
}
