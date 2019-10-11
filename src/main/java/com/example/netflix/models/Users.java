package com.example.netflix.models;

import lombok.*;
import org.apache.commons.text.WordUtils;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter a user name")
    private String name;

    @Column(name = "is_admin")
    @ColumnDefault(value = "false")
    private boolean isAdmin = false;

    @OneToMany(mappedBy = "users")
    private Set<Movies> movies;
}
