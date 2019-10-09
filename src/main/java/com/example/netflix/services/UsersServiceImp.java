package com.example.netflix.services;

import com.example.netflix.NotFoundException;
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
    public Long delete(Long id) {
        try {
            usersRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
