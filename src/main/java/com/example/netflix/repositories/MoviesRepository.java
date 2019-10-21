package com.example.netflix.repositories;

import com.example.netflix.models.Categories;
import com.example.netflix.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByCategoryAndType(Categories categoryId, String type);
}
