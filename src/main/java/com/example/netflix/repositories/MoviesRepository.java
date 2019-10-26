package com.example.netflix.repositories;

import com.example.netflix.models.Categories;
import com.example.netflix.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByCategoryAndType(Categories categoryId, String type);

    Optional<Movies> findByMovieId(String movieId);

    Optional<Object> findById(String id);
}
