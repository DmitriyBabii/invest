package ua.invest.models.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
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
    private String email;
    private String password;
    private Date birth;             // TODO must be 18 years old
    private Date registered = Date.valueOf(LocalDate.now());

    @OneToMany(mappedBy = "owner")
    private List<Company> companies;
    @ManyToMany(mappedBy = "members")
    private List<Company> memberships;

    @ManyToMany(mappedBy = "subscribers")
    private List<Project> subscribes;

    @OneToMany(mappedBy = "user")
    private List<SingleInvest> singleInvests;
    @OneToMany(mappedBy = "user")
    private List<InvestSubscribe> investSubscribes;

    public User(String email, String password, Date birth) {
        this.email = email;
        this.password = password;
        this.birth = birth;
    }
}
