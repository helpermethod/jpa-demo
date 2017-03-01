package de.predic8.jpa.rest;

import de.predic8.jpa.domain.Author;
import de.predic8.jpa.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/authors")
@RestController
public class AuthorRestController {
    private final AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/")
    public List<Author> index() {
        return authorRepository.fetchAuthorsWithPosts();
    }
}