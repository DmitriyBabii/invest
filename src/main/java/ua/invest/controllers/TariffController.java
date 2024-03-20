package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.invest.models.entities.InvestTariff;
import ua.invest.models.entities.Project;
import ua.invest.repositories.ProjectRepository;
import ua.invest.repositories.TariffRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TariffController {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final TariffRepository tariffRepository;

    @GetMapping("/api/tariffs/{projectId}")
    public ResponseEntity<List<InvestTariff>> getTariffsByProjectId(@PathVariable String projectId) {
        Project project = projectRepository.findById(UUID.fromString(projectId)).get();
        return new ResponseEntity<>(project.getTariffs(), HttpStatus.OK);
    }
}
