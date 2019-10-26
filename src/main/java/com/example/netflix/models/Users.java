package com.example.netflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
@AllArgsConstructor()
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
    private String email;

    @Column(name = "admin")
    @ColumnDefault(value = "false")
    private boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Movies> movies;


    public Users(@NotNull(message = "Please enter a user name") String name, String email, boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin;
    }
}
