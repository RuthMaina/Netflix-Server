package com.example.netflix.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter a user name")
    private String name;

    @NotNull(message = "Please enter an id number")
    @Size(min = 3, message = "The id number should not be less than 3 characters long")
    @Column(name = "id_number", nullable = false, unique = true)
    private String idNumber;

    @Column(name = "user_type", nullable = false, columnDefinition = "varchar(255) default 'user'")
    private String userType;

    @OneToMany(mappedBy = "users")
    private Set<Movies> movies;
}
