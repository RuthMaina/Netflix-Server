package com.example.netflix.services;

import com.example.netflix.models.Users;

import java.util.List;

public interface UsersService {
    List<Users>findAll();

    Users findById(Long id);

    Users create(Users users);

    Long delete(Long id);
}
