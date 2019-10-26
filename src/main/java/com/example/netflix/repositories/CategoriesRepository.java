package com.example.netflix.repositories;

import com.example.netflix.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Object> findById(String id);

    void deleteById(String id);
}
