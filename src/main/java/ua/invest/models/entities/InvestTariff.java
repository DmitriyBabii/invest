package ua.invest.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvestTariff {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;

    @JsonIgnore
    @ManyToOne
    private Project project;

    public InvestTariff(String name, String description, Double price, Project project) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.project = project;
    }
}
