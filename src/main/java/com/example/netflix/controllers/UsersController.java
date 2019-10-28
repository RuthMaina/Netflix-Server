package com.example.netflix.controllers;

import com.example.netflix.models.Users;
import com.example.netflix.services.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http:/localhost:8088")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping(value = "{id}")
    public Users findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PostMapping
    public Users create(@Valid @RequestBody Users users) {
    return usersService.create(users);
    }

    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam Long userId) {
        return "Record " + usersService.delete(id, userId) + " deleted successfully";
    }
}
