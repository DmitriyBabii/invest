package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.invest.models.entities.Project;
import ua.invest.repositories.PostRepository;
import ua.invest.repositories.ProjectRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ModelAndView getProjects(ModelAndView modelAndView) {
        modelAndView.addObject("projects", projectRepository.findAll());
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/projects/{id}")
    public ModelAndView getProject(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject("project", projectRepository.findById(UUID.fromString(id)).get());
        modelAndView.setViewName("pdp.html");
        return modelAndView;
    }
}
