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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ElementCollection
    private List<String> pictures;
    private Date created = Date.valueOf(LocalDate.now());
    @OneToMany
    private List<InvestTariff> tariffs = new ArrayList<>();

    @ManyToMany
    private List<User> subscribers;
    @OneToMany
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "project")
    private List<SingleInvest> singleInvests;
    @OneToMany(mappedBy = "project")
    private List<InvestSubscribe> investSubscribes;

    public Project(String name, String description, List<String> pictures) {
        this.name = name;
        this.description = description;
        this.pictures = pictures;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addTariff(InvestTariff tariff){
        this.tariffs.add(tariff);
    }
}
