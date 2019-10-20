package com.example.netflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.text.WordUtils;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Set;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@SelectBeforeUpdate
@Entity
@Table(name = "movies")
public class Movies {
    @JsonIgnore
    final char[] delimiters = { ' ', '_', '-' };

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

    @NotNull(message = "Please enter the run-time of the movie")
    @Column(name = "production_company")
    private String productionCompany;

    //    @GeneratedValue
    @Column()
    private String type;

    @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Categories> category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ColumnDefault(value = "0")
    private int count;

    @ColumnDefault(value = "true")
    private boolean pending;

    public void setMovieName(String movieName) {
        this.movieName = WordUtils.capitalizeFully(movieName, delimiters);
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = WordUtils.capitalizeFully(productionCompany, delimiters);
    }

    public Movies() {
    }

    public Movies(@NotNull(message = "Please enter the name of the movie") String movieName, @NotNull(message = "Please enter the release year of the movie") Year releaseYear, @NotNull(message = "Please enter the run-time of the movie") String productionCompany, Set<Categories> category, Users users, int count, boolean pending) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.productionCompany = productionCompany;
        this.category = category;
        this.users = users;
        this.count = count;
        this.pending = pending;
    }

    public char[] getDelimiters() {
        return delimiters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Categories> getSetCategories() {
        return category;
    }

    public void setSetCategories(Set<Categories> category) {
        this.category = category;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        return "Movies{" +
                ", id=" + id +
                ", movieName='" + movieName + '\'' +
                ", releaseYear=" + releaseYear +
                ", productionCompany='" + productionCompany + '\'' +
                ", type='" + type + '\'' +
                ", category=" + category +
                ", users=" + users +
                ", count=" + count +
                ", pending=" + pending +
                '}';
    }
}
