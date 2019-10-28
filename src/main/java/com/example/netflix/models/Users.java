package com.example.netflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//@AllArgsConstructor()
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @NotNull(message = "Please enter a user name")
    private String name;

    @Email(message = "Please enter a valid email")
    @NotNull(message = "Please enter a valid email")
    @Column(unique = true)
    private String email;

    @Column(name = "admin")
    @ColumnDefault(value = "false")
    private boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Movies> movies;


    public Users() {
    }

    public Users(@NotNull(message = "Please enter a user name") String name, String email, boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                ", movies=" + movies +
                '}';
    }
}
