package com.example.netflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Category;
import lombok.*;
import org.apache.commons.text.WordUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull(message = "Please enter a category name")
    @Column()
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "category")
    Set<Movies> movies;

    public void setCategory(String category) {
        this.category = WordUtils.capitalizeFully(category, ' ', '_', '-');
    }

    public Categories(@NotNull(message = "Please enter a category name") String category) {
        this.category = category;
    }

    public Categories(Long aLong) {
        this.id = aLong;
    }

    public static List<Categories> longCategories(List<Long> aLong){
        return aLong.stream().map(Categories::new).collect(Collectors.toList());
    }
}
