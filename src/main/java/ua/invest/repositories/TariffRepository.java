package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.InvestTariff;

import java.util.List;
import java.util.UUID;

@Repository
public interface TariffRepository extends JpaRepository<InvestTariff, UUID> {
    @Query("SELECT t FROM InvestTariff t WHERE t.project.id=:id")
    List<InvestTariff> findAllByProjectId(@Param("id") UUID id);
}
