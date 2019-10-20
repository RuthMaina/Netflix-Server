package com.example.netflix.models;

import com.example.netflix.configs.NamingConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.text.WordUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "categories")
public class Categories {
    @JsonIgnore
    final char[] delimiters = { ' ', '_', '-' };

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter a category name")
    @Column()
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "category")
    Set<Movies> movies;

    public Categories() {
    }

    public Categories(@NotNull(message = "Please enter a category name") String category, Set<Movies> movies) {
        this.category = category;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = WordUtils.capitalizeFully(category, delimiters);
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", movies=" + movies +
                '}';
    }
}
