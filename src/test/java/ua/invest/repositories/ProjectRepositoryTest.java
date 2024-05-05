package ua.invest.repositories;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import ua.invest.models.entities.Project;
import ua.invest.models.enums.Category;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

    @BeforeEach
    void setUp() {
        List<Project> projects = Arrays.asList(
                new Project(
                        "V Rising",
                        """
                                Experience a Vampire Survival Action RPG adventure like no other.
                                       
                                Awaken as a weakened Vampire after centuries of slumber. Hunt for blood to regain your strength while hiding from the scorching sun to survive. Rebuild your castle and convert humans into your loyal servants in a quest to raise your Vampire empire. Make allies or enemies online or play solo locally, fend off holy soldiers, and wage war in a world of conflict. Seize your destiny! Defy Dracula! Rule the night!
                                """,
                        Category.desktop,
                        Arrays.asList(
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/1604030/ss_19d6b903fd65c410af902a8c5f62c820cfe09292.1920x1080.jpg?t=1710864243",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/1604030/ss_19d6b903fd65c410af902a8c5f62c820cfe09292.1920x1080.jpg?t=1710864243",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/1604030/ss_262496a8c3ed1335d63398fe06f8dd4d43d311cf.1920x1080.jpg?t=1710864243",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/1604030/ss_262496a8c3ed1335d63398fe06f8dd4d43d311cf.1920x1080.jpg?t=1710864243"
                        )
                ),
                new Project(
                        "Terraria",
                        """
                                Dig, Fight, Explore, Build: The very world is at your fingertips as you fight for survival, fortune, and glory. Will you delve deep into cavernous expanses in search of treasure and raw materials with which to craft ever-evolving gear, machinery, and aesthetics? Perhaps you will choose instead to seek out ever-greater foes to test your mettle in combat? Maybe you will decide to construct your own city to house the host of mysterious allies you may encounter along your travels?""",
                        Category.desktop,
                        Arrays.asList(
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_8c03886f214d2108cafca13845533eaa3d87d83f.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_ae168a00ab08104ba266dc30232654d4b3c919e5.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_9edd98caaf9357c2f40758f354475a56e356e8b0.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_75ea9a7e39eb34b40efa1e6dfd2536098dc4734b.1920x1080.jpg?t=1666290860"
                        )
                )
        );
        projectRepository.saveAll(projects);
    }

    @AfterEach
    void tearDown() {
        projectRepository.deleteAll();
    }

    @Test
    void findAll() {
        assertEquals(2, projectRepository.findAll().size());
    }

    @Test
    void findBySearch() {
        assertEquals("V Rising", projectRepository.findAllBySearch("V Rising").stream().findFirst().get().getName());
    }

    @Test
    void findBySearchAndCategories() {
        assertEquals(
                "V Rising",
                projectRepository.findAllBySearch("V Rising", Arrays.asList(Category.desktop)).stream()
                        .findFirst().get().getName()
        );
    }
}