package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.Tariff;

import java.util.UUID;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, UUID> {

}
