package com.example.netflix.models;

import lombok.*;
import org.apache.commons.text.WordUtils;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SelectBeforeUpdate
@Entity(name = "movies")
public class Movies {

    final char[] delimiters = { ' ', '_', '-' };

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter the name of the movie")
    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @NotNull(message = "Please enter the release year of the movie")
    @Column(name = "release_year", nullable = false)
    private Year releaseYear;

    @NotNull(message = "Please enter the run-time of the movie")
    @Column(name = "production_company", nullable = false)
    private String productionCompany;

    @GeneratedValue
    @Column(name = "unique_name", unique = true)
    // based off on concat of movieName and releaseYear
    private String uniqueName;

    @GeneratedValue
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

    public void setMovieName(String movieName) {
        this.movieName = WordUtils.capitalizeFully(movieName, delimiters);
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = WordUtils.capitalizeFully(productionCompany, delimiters);
    }
}
