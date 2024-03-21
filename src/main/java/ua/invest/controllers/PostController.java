package ua.invest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.invest.models.entities.Post;
import ua.invest.models.entities.Project;
import ua.invest.repositories.PostRepository;
import ua.invest.repositories.ProjectRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private final PostRepository postRepository;

    @GetMapping("/{projectId}")
    public ResponseEntity<List<Post>> getPostsByProjectId(@PathVariable String projectId) throws IllegalArgumentException{
        return new ResponseEntity<>(postRepository.findAllByProjectId(UUID.fromString(projectId)), HttpStatus.OK);
    }
}
