package ua.invest.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.invest.models.entities.InvestTariff;
import ua.invest.models.entities.Project;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TariffRepositoryTest {
    @Autowired
    private TariffRepository tariffRepository;
    @Autowired
    private ProjectRepository projectRepository;
    private UUID id;

    @BeforeEach
    void setUp() {
        Project project = new Project();
        List<InvestTariff> tariffs = Arrays.asList(
                new InvestTariff(
                        "Some tariff",
                        "Description",
                        123.,
                        project
                ),
                new InvestTariff(
                        "Some tariff2",
                        "Description2",
                        234.,
                        project
                )
        );
        projectRepository.save(project);
        tariffRepository.saveAll(tariffs);

        id = project.getId();
    }

    @AfterEach
    void tearDown() {
        tariffRepository.deleteAll();
    }

    @Test
    void findAllByProjectId() {
        assertEquals(2, tariffRepository.findAllByProjectId(id).size());
    }
}