package de.predic8.jpa.repository;

import de.predic8.jpa.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a from Author a left join fetch a.posts")
    List<Author> fetchAuthorsWithPosts();
}
