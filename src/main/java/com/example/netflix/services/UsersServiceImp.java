package com.example.netflix.services;

import com.example.netflix.exceptions.DontMatchException;
import com.example.netflix.exceptions.NotFoundException;
import com.example.netflix.exceptions.RelationshipException;
import com.example.netflix.exceptions.UnknownException;
import com.example.netflix.models.Movies;
import com.example.netflix.models.Users;
import com.example.netflix.repositories.MoviesRepository;
import com.example.netflix.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService {
    private final UsersRepository usersRepository;
    private final MoviesRepository moviesRepository;

    public UsersServiceImp(UsersRepository usersRepository, MoviesRepository moviesRepository) {
        this.usersRepository = usersRepository;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
    }

    @Override
    public Users create(Users users) {

        if (usersRepository.findByEmail(users.getEmail()).isPresent()) {
            return usersRepository.findByEmail(users.getEmail()).get();
        }
        return usersRepository.save(users);
    }

    @Override
    public String delete(Long id, Long userId) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
        Users isAdmin = usersRepository.findById(userId).orElseThrow(() -> new NotFoundException("No user with id " + userId + " found"));
        List<Movies> movies = moviesRepository.findByUser(users);

        if (!movies.isEmpty()) {
            throw new RelationshipException("There is a movie created by the user. Please delete the movie first");
        }
        if (userId.equals(id) || isAdmin.isAdmin()) {
            try {
                usersRepository.deleteById(id);
                return id.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new DontMatchException("The IDs don't match");
        }
        throw new UnknownException("Something went wrong!");
    }
}
