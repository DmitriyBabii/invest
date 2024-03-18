package ua.invest.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String about;
    private String picture;

    @ManyToOne
    @JsonIgnore
    private User owner;
    @ManyToMany
    @JsonIgnore
    private List<User> members;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Project> projects = new ArrayList<>();

    public Company(String name, String about, String picture, User owner) {
        this.name = name;
        this.about = about;
        this.picture = picture;
        this.owner = owner;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
