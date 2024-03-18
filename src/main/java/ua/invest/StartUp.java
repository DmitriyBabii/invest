package ua.invest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.invest.models.GPTMessage;
import ua.invest.models.GPTRequestBody;
import ua.invest.models.entities.Company;
import ua.invest.models.entities.Post;
import ua.invest.models.entities.Project;
import ua.invest.models.entities.User;
import ua.invest.repositories.CompanyRepository;
import ua.invest.repositories.PostRepository;
import ua.invest.repositories.ProjectRepository;
import ua.invest.repositories.UserRepository;
import ua.invest.services.GPTService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class StartUp implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("SomeEmail", "password", Date.valueOf(LocalDate.now()));
        Company company = new Company("Name", "About", "Picture", user);
        Project project = new Project("Name", "Description", "Logo", null, company);
        company.addProject(project);
        Post post = new Post("Name", "Description", null);
        project.addPost(post);
        userRepository.save(user);
        postRepository.save(post);
        companyRepository.save(company);
        projectRepository.save(project);
        GPTRequestBody body = new GPTRequestBody(Arrays.asList(
                new GPTMessage("system","system content"),
                new GPTMessage("user","user content")
        ));
        System.out.println(body);
    }
}
