package com.example.netflix.repositories;

import com.example.netflix.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
//    Movies findByCategoryAndType(String setCategories, String type);
    List<Movies> findByCategoryAndType(String category, String type);
}
