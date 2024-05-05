package ua.invest.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.invest.models.entities.Post;
import ua.invest.models.entities.Project;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProjectRepository projectRepository;
    private UUID id;

    @BeforeEach
    void setUp() {
        Project project = new Project();
        List<Post> posts = Arrays.asList(
                new Post(
                        "V Rising coming May 8th!",
                        """
                                V Rising is emerging from the shadows to take its greatest form to date! Join millions of Vampires on the journey to become the supreme predator of Vardoran, carving your name into the history of a world that has forgotten your kind. Journey through the shadows of the lands of man and monster, staking your claim and raising your towering castle. Drink blood, gather knowledge, and prove that you are worthy of the claim of the greatest Vampire to ever live by overcoming one final challenge…""",
                        "https://clan.cloudflare.steamstatic.com/images//40467553/2ffda82923d6ce7df3359c4cc0de0ba07cf3679a.png",
                        project
                ),
                new Post(
                        "Dev Update 25: Spellcraft Unbound",
                        """
                                With great enthusiasm, we bring you yet another developer update from the crypts of Stunlock Studios! Today, we’ll be delving into changes with the progression. From how spells are acquired to recipes and the quality of unlife that smooths the whole experience into a delightful, intuitive process, we aim to put a new twist on how you play, delivering much-desired changes in unexpected packages.
                                Light some candles and put on some haunting tunes to set the mood. It’s time to settle in to read more about the future of our villainous aspirations.""",
                        "https://clan.cloudflare.steamstatic.com/images//40467553/b5441af39cff77a3fa5d4d1ff6bae6a70d908ed8.png",
                        project
                )
        );
        projectRepository.save(project);
        postRepository.saveAll(posts);

        id = project.getId();
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    void findAllByProjectIdCount() {
        assertEquals(2,postRepository.findAllByProjectId(id).size());
    }
}