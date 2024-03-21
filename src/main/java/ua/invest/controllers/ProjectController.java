package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.invest.models.entities.Project;
import ua.invest.models.enums.Category;
import ua.invest.repositories.ProjectRepository;
import ua.invest.services.ProjectService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ModelAndView getProjects(@RequestParam(value = "q", defaultValue = "") String search,
                                    @RequestParam(value = "cat", required = false) List<Category> categories,
                                    ModelAndView modelAndView) {
        modelAndView.addObject("projects", projectService.findAllBySubSearch(search, categories));
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
