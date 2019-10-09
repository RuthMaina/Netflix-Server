package com.example.netflix.controllers;

import com.example.netflix.models.Users;
import com.example.netflix.services.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "users")
@CrossOrigin(origins = "http:/localhost:8088")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "{id}")
    public Users findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PostMapping
    public Users create(@Valid @RequestBody Users users) {
    return usersService.create(users);
    }

    @DeleteMapping(value = "{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("Record deleted", usersService.delete(id));
        return response;
    }
}
