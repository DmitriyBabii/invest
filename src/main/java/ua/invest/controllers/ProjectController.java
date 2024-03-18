package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.invest.models.entities.Project;
import ua.invest.repositories.PostRepository;
import ua.invest.repositories.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final PostRepository postRepository;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
    }
}
