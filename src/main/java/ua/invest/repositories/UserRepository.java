package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
