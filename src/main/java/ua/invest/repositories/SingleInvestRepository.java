package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.SingleInvest;

import java.util.UUID;

@Repository
public interface SingleInvestRepository extends JpaRepository<SingleInvest, UUID> {
}
