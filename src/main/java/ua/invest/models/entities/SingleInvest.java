package ua.invest.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SingleInvest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;
    private Double donat;           // TODO must be more then 0

    public SingleInvest(User user, Project project, Double donat) {
        this.user = user;
        this.project = project;
        this.donat = donat;
    }
}
