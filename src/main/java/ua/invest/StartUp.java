package ua.invest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.invest.models.entities.*;
import ua.invest.repositories.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
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
        User user = new User("SomeEmail", "password", Date.valueOf(LocalDate.now()));
        List<Project> projects = Arrays.asList(
                new Project(
                        "V Rising",
                        """
                                Experience a Vampire Survival Action RPG adventure like no other.
                                       
                                Awaken as a weakened Vampire after centuries of slumber. Hunt for blood to regain your strength while hiding from the scorching sun to survive. Rebuild your castle and convert humans into your loyal servants in a quest to raise your Vampire empire. Make allies or enemies online or play solo locally, fend off holy soldiers, and wage war in a world of conflict. Seize your destiny! Defy Dracula! Rule the night!
                                """,
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
                        Arrays.asList(
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_8c03886f214d2108cafca13845533eaa3d87d83f.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_ae168a00ab08104ba266dc30232654d4b3c919e5.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_9edd98caaf9357c2f40758f354475a56e356e8b0.1920x1080.jpg?t=1666290860",
                                "https://cdn.cloudflare.steamstatic.com/steam/apps/105600/ss_75ea9a7e39eb34b40efa1e6dfd2536098dc4734b.1920x1080.jpg?t=1666290860"
                        )
                )
        );
        List<Post> posts = Arrays.asList(
                new Post(
                        "V Rising coming May 8th!",
                        """
                                V Rising is emerging from the shadows to take its greatest form to date! Join millions of Vampires on the journey to become the supreme predator of Vardoran, carving your name into the history of a world that has forgotten your kind. Journey through the shadows of the lands of man and monster, staking your claim and raising your towering castle. Drink blood, gather knowledge, and prove that you are worthy of the claim of the greatest Vampire to ever live by overcoming one final challenge…""",
                        "https://clan.cloudflare.steamstatic.com/images//40467553/2ffda82923d6ce7df3359c4cc0de0ba07cf3679a.png"
                ),
                new Post(
                        "Dev Update 25: Spellcraft Unbound",
                        """
                                With great enthusiasm, we bring you yet another developer update from the crypts of Stunlock Studios! Today, we’ll be delving into changes with the progression. From how spells are acquired to recipes and the quality of unlife that smooths the whole experience into a delightful, intuitive process, we aim to put a new twist on how you play, delivering much-desired changes in unexpected packages.
                                Light some candles and put on some haunting tunes to set the mood. It’s time to settle in to read more about the future of our villainous aspirations.""",
                        "https://clan.cloudflare.steamstatic.com/images//40467553/b5441af39cff77a3fa5d4d1ff6bae6a70d908ed8.png"
                )
        );

        List<InvestTariff> tariffs = Arrays.asList(
                new InvestTariff(
                        "Some tariff",
                        "Description",
                        123.
                ),
                new InvestTariff(
                        "Some tariff2",
                        "Description2",
                        234.
                )
        );

        SingleInvest singleInvest = new SingleInvest(user, projects.get(0), 23.);
        posts.forEach(post -> projects.get(0).addPost(post));
        tariffs.forEach(tariff -> projects.get(0).addTariff(tariff));

        userRepository.save(user);
        tariffRepository.saveAll(tariffs);
        postRepository.saveAll(posts);
        projectRepository.saveAll(projects);

        singleInvestRepository.save(singleInvest);


        user.setSubscribes(Collections.singletonList(projects.get(0)));
        userRepository.save(user);
    }
}
