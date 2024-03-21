package ua.invest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.invest.models.entities.Project;
import ua.invest.models.enums.Category;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    @Query("SELECT p FROM Project p WHERE p.name LIKE :q")
    List<Project> findAllBySearch(@Param("q") String search);

    @Query("SELECT p FROM Project p WHERE p.name LIKE :q AND p.category IN :cat")
    List<Project> findAllBySearch(@Param("q") String search, @Param("cat") List<Category> categories);
}
