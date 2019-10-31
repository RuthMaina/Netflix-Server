package com.example.netflix.services;

import com.example.netflix.configs.GenerateId;
import com.example.netflix.exceptions.DontMatchException;
import com.example.netflix.exceptions.NotFoundException;
import com.example.netflix.exceptions.UnknownException;
import com.example.netflix.models.Categories;
import com.example.netflix.models.Movies;
import com.example.netflix.models.Users;
import com.example.netflix.repositories.MoviesRepository;
import com.example.netflix.repositories.UsersRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServicesImp implements MoviesServices {
    private final MoviesRepository moviesRepository;
    private final UsersRepository usersRepository;

    public MoviesServicesImp(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        this.moviesRepository = moviesRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies findById(Long id) {
        return moviesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
    }

    @Override
    public List<Movies> findByCategoryAndType(String categoryId, String type) {
        if (moviesRepository.findByCategoryAndType(new Categories(categoryId.toLowerCase()), WordUtils.capitalizeFully(type)).isEmpty()) {
            throw new NotFoundException("There is no movie of the specified category and type");
        } else {
            return moviesRepository.findByCategoryAndType(new Categories(categoryId.toLowerCase()), WordUtils.capitalizeFully(type));
        }
    }

    @Override
    public Movies create(Long user, Movies movies) {
//         Check if movie exists
        String movieId = GenerateId.generateMovieId(movies.getMovieName(), movies.getReleaseYear());
        if (moviesRepository.findByMovieId(movieId).isPresent()) {
            return moviesRepository.findByMovieId(movieId).get();
        }

        // Check if user exists
        Users users = usersRepository.findById(user).orElseThrow(() -> new NotFoundException("No user of id " + user + " exists"));

        movies.setMovieId(movieId);
        if (users.isAdmin()) {
            movies.setType("Original");
        } else if (!users.isAdmin()) {
            movies.setType("Suggested");
        }
        movies.setUser(users);
        return moviesRepository.save(movies);
    }

    @Override
    public String delete(Long id, Long userId) {
        Movies movies = moviesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));

        Users users = usersRepository.findById(userId).orElseThrow(() -> new NotFoundException("No user with id " + userId + " found"));

        if (movies.getUser().getId().equals(users.getId()) || users.isAdmin()) {
            try {
                moviesRepository.delete(movies);
                return id.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new DontMatchException("The movie can only be deleted by the user who created it or an administrator");
        }
        throw new UnknownException("Something went wrong!");
    }

    @Override
    public Movies update(Movies movies) {
        return null;
    }

    @Override
    public Movies update(Long id, Long userId, Movies movies) {
        // Check if movie exists
        Movies foundMovie = moviesRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));

        // Check if user exists
        Users users = usersRepository.findById(userId).orElseThrow(() -> new NotFoundException("No user with id " + userId + " found"));

        // Validate who updates the movie
        if (foundMovie.getUser().getId().equals(userId) || users.isAdmin()) {
            foundMovie.setMovieName(movies.getMovieName());
            foundMovie.setReleaseYear(movies.getReleaseYear());
            foundMovie.setMovieId(GenerateId.generateMovieId(movies.getMovieName(), movies.getReleaseYear()));
            foundMovie.setType(foundMovie.getType());
            foundMovie.setCategory(movies.getCategory());
            foundMovie.setUser(users);
            return moviesRepository.save(foundMovie);
        } else {
            throw new DontMatchException("The movie can only be updated by the user who created it or an administrator");
        }
    }
}
