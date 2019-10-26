package com.example.netflix.repositories;

import com.example.netflix.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findById(Long userId);
}
