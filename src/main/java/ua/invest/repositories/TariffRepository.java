package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.InvestTariff;

import java.util.UUID;

@Repository
public interface TariffRepository extends JpaRepository<InvestTariff, UUID> {
}
