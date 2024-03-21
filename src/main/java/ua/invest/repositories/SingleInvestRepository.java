package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.SingleInvest;

import java.util.List;
import java.util.UUID;

@Repository
public interface SingleInvestRepository extends JpaRepository<SingleInvest, UUID> {
    @Query("SELECT si FROM SingleInvest si WHERE si.user.id=:id")
    List<SingleInvest> findAllByUserId(@Param("id") UUID id);
}
