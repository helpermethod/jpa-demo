package de.predic8.jpa;

import de.predic8.jpa.domain.Author;
import de.predic8.jpa.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorIT {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturnAllAuthors() {
		List<Author> authors = testRestTemplate.exchange("/authors/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Author>>() {
		}).getBody();

		assertThat(authors).isNotEmpty();
	}

	@Test
    public void shouldReturnAllAuthorsAlt() {
        Author[] authors = testRestTemplate.getForObject("/authors/", Author[].class);

        assertThat(authors).isNotEmpty();
    }
}