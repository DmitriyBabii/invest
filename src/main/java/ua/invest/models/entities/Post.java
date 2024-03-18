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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ElementCollection
    private List<String> pictures;
    private Date created = Date.valueOf(LocalDate.now());

    public Post(String title, String content, List<String> pictures) {
        this.title = title;
        this.content = content;
        this.pictures = pictures;
    }
}
