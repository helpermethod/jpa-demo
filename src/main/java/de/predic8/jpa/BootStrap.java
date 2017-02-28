package de.predic8.jpa;

import de.predic8.jpa.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private final PostRepository postRepository;

    // constructor-injection
    public BootStrap(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(postRepository.findAll());
    }
}
