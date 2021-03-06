package de.predic8.jpa;

import de.predic8.jpa.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    // constructor-injection
    public BootStrap(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(authorRepository.fetchAuthorsWithPosts());
    }
}