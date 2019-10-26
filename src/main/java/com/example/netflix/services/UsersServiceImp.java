package com.example.netflix.services;

import com.example.netflix.exceptions.DontMatchException;
import com.example.netflix.exceptions.NotFoundException;
import com.example.netflix.exceptions.UnknownException;
import com.example.netflix.models.Users;
import com.example.netflix.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
        return usersRepository.save(users);
    }

    @Override
    public String delete(Long id, Long userId) {
        usersRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with id " + id + " found"));
        if (userId.equals(id)) {
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
