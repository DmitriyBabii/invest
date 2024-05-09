package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.invest.repositories.ProjectRepository;

import java.util.UUID;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    private final ProjectRepository projectRepository;

    @GetMapping
    public ModelAndView getCatalogPage(ModelAndView modelAndView) {
        modelAndView.addObject("projects", projectRepository.findAll());
        modelAndView.setViewName("catalog.html");
        return modelAndView;
    }

    @GetMapping("/{projectId}")
    public ModelAndView getProjectPage(@PathVariable UUID projectId, ModelAndView modelAndView) {
        modelAndView.addObject("project", projectRepository.findById(projectId).orElseThrow());
        modelAndView.setViewName("project.html");
        return modelAndView;
    }
}
