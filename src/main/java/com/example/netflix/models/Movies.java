package com.example.netflix.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor
@Entity(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter the name of the movie")
    @Column(nullable = false)
    private String movieName;

    @NotNull(message = "Please enter the release year of the movie")
    @Column(nullable = false)
    private Year releaseYear;

    @Column(name = "unique_name")
    // based off on concat of movieName and releaseYear
    private String uniqueName;

    @Column(nullable = false)
    private String type;

    @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Categories> setCategories;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

}
