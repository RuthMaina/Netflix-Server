package com.example.netflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.commons.text.WordUtils;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@SelectBeforeUpdate
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

    //    @GeneratedValue
    @Column()
    private String type;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Categories> category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    public void setMovieName(String movieName) {
        this.movieName = WordUtils.capitalizeFully(movieName, ' ', '_', '-');
    }
}
