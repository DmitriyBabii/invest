package ua.invest.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(name = "_order")
    private Integer order;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Date created = Date.valueOf(LocalDate.now());

    @JsonIgnore
    @ManyToOne
    private Project project;

    public Post(Integer order, String title, String content, Project project) {
        this.order = order;
        this.title = title;
        this.content = content;
        this.project = project;
    }
}
