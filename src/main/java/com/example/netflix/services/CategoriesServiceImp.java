package com.example.netflix.services;

import com.example.netflix.exceptions.AdminPrivilegeException;
import com.example.netflix.exceptions.NotFoundException;
import com.example.netflix.exceptions.UnknownException;
import com.example.netflix.models.Categories;
import com.example.netflix.models.Users;
import com.example.netflix.repositories.CategoriesRepository;
import com.example.netflix.repositories.UsersRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesRepository categoriesRepository;
    private final UsersRepository usersRepository;

    public CategoriesServiceImp(CategoriesRepository categoriesRepository, UsersRepository usersRepository) {
        this.categoriesRepository = categoriesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(String id) {
        return (Categories) categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
    }

    @Override
    public Categories create(Categories categories) {
        categories.setId(categories.getCategory().toLowerCase());
        categories.setCategory(WordUtils.capitalizeFully(categories.getCategory(), ' ', '_', '-'));
        return categoriesRepository.save(categories);
    }

    @Override
    @Transactional
    public String delete(String id, Long userId) {
        categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));

        Users users = usersRepository.findById(userId).orElseThrow(() -> new NotFoundException("No user with id " + id + " found"));

        if (users.isAdmin()) {
            try {
                categoriesRepository.deleteById(id);
                return id;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new AdminPrivilegeException("Only and administrator can perform this operation");
        }
        throw new UnknownException("Something went wrong!");
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
