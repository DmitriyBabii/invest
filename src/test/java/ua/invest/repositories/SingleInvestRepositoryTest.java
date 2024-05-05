package ua.invest.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.invest.models.entities.Project;
import ua.invest.models.entities.SingleInvest;
import ua.invest.models.entities.User;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SingleInvestRepositoryTest {
    @Autowired
    private SingleInvestRepository singleInvestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    private UUID id;

    @BeforeEach
    void setUp() {
        User user = new User();
        Project project = new Project();
        SingleInvest singleInvest = new SingleInvest(user, project, 23.);

        userRepository.save(user);
        projectRepository.save(project);
        singleInvestRepository.save(singleInvest);

        id = user.getId();
    }

    @AfterEach
    void tearDown() {
        singleInvestRepository.deleteAll();
    }

    @Test
    void findAllByUserId() {
        assertEquals(1, singleInvestRepository.findAllByUserId(id).size());
    }
}