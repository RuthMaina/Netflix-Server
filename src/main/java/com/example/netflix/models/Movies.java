package com.example.netflix.models;

import lombok.*;
import org.apache.commons.text.WordUtils;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@SelectBeforeUpdate
@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter the name of the movie")
    @Column(name = "movie_name")
    private String movieName;

    @NotNull(message = "Please enter the release year of the movie")
    @Column(name = "release_year")
    private Year releaseYear;

    //    @NotNull
    @Column(name = "movie_id", unique = true)
    private String movieId;

    @Column()
    private String type;

    //    @ManyToMany(cascade = {CascadeType.MERGE})
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Categories> category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public void setMovieName(String movieName) {
        this.movieName = WordUtils.capitalizeFully(movieName, ' ', '_', '-');
    }
}
