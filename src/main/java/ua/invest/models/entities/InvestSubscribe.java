package ua.invest.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvestSubscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;
    @ManyToOne
    private InvestTariff tariff;
    private Date start = Date.valueOf(LocalDate.now());
    private Date lastTransaction;
    private Date end;
}
