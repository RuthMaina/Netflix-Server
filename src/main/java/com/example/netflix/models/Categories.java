package com.example.netflix.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter a category name")
    @Column(nullable = false)
    private String category;

    @ManyToMany(mappedBy = "setCategories")
    Set<Movies> movies;
}
