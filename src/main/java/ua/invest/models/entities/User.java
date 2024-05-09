package ua.invest.models.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date registered = Date.valueOf(LocalDate.now());

    @OneToMany(mappedBy = "owner")
    private List<Project> projects;
    @ManyToMany(mappedBy = "followers")
    private List<Project> follows = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Donat> donates = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Subscribe> subscribes = new ArrayList<>();

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
