package de.predic8.jpa;

import de.predic8.jpa.domain.Author;
import de.predic8.jpa.repository.AuthorRepository;
import de.predic8.jpa.rest.AuthorRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorRestController.class)
public class AuthorMockMvcIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    public void shouldAcceptGetRequests() throws Exception {
        given(authorRepository.findAll())
            .willReturn(Arrays.asList(new Author("Oliver Weiler"), new Author("Thomas Bayer")));

        mockMvc.perform(get("/authors/")).andExpect(status().isOk());
    }


}
