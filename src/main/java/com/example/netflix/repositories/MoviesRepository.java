package com.example.netflix.repositories;

import com.example.netflix.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

}
