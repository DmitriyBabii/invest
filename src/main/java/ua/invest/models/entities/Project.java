package ua.invest.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.invest.models.enums.Category;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String picture;
    @Enumerated
    private Category category;
    private Double currentInvest = .0;
    private Double goalInvest;
    private Date created = Date.valueOf(LocalDate.now());

    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "project")
    private List<Tariff> tariffs = new ArrayList<>();
    @ManyToMany
    private List<User> followers = new ArrayList<>();
    @OneToMany(mappedBy = "project")
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "project")
    private List<Donat> donates;

    public Project(User owner, String name, String description, String picture, Category category, Double goalInvest) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.category = category;
        this.goalInvest = goalInvest;
    }
}
