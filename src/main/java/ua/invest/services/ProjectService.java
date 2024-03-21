package ua.invest.services;

import org.springframework.stereotype.Service;
import ua.invest.models.entities.Project;
import ua.invest.models.enums.Category;
import ua.invest.repositories.ProjectRepository;

import java.util.Arrays;
import java.util.List;

@Service
public interface ProjectService extends ProjectRepository {

    default List<Project> findAllBySubSearch(String search, List<Category> categories) {
        String like = String.format("%%%s%%", search);
        return categories != null ?
                findAllBySearch(like, categories) :
                findAllBySearch(like);
    }
}
