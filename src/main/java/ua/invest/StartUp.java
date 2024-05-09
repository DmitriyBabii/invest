package ua.invest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.invest.models.entities.*;
import ua.invest.models.enums.Category;
import ua.invest.repositories.*;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final TariffRepository tariffRepository;
    @Autowired
    private final SingleInvestRepository singleInvestRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Dima", "Babii", "email", "password");

        Project project = new Project(
                user, "V Rising",
                """
                        Awaken as a Vampire. Hunt for blood in nearby settlements to regain your strength and evade the scorching sun to survive. Raise your castle and thrive in an ever-changing, open world full of mystery. Gain allies online and conquer the land of the living.
                        """,
                "https://cdn.akamai.steamstatic.com/steam/apps/1604030/header.jpg?t=1715248207",
                Category.DESKTOP,
                4000d
        );

        Post post = new Post(
                1,
                "V RISING 1.0 OUT NOW",
                """
                        The journey to full release was rife with dangers and challenges, but your feedback and raw excitement helped us navigate the winding roads to a victorious 1.0 launch! We’re very excited to take this last step with you because we can truly spread our wings beyond this last footfall and take to the skies!
                                        
                                        
                        “After 5 years of dedication and relentless effort, we've realized the vision we set out for V Rising many years ago. I couldn't be prouder of our team for crafting a game that exemplifies what we're renowned for: unique genre hybrids focusing on gameplay first. With V Rising, we've elevated our craft to new heights. I extend my heartfelt gratitude to every player who supported us during Early Access, empowering us to shape the game into what it is today. And to our new players, welcome to the finest iteration of V Rising Vampires!”
                                        
                        - Rickard Frisegård, CEO at Stunlock Studios
                        """,
                project
        );

        userRepository.save(user);
        projectRepository.save(project);
        postRepository.save(post);
    }
}
