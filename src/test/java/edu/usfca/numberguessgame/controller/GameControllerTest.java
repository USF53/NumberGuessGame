package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.model.Session;
import edu.usfca.numberguessgame.repository.SessionRepository;
import edu.usfca.numberguessgame.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameController.class)
@Import(GameService.class)
public class GameControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SessionRepository sessionRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenSetBoundURI_whenMockMVC_thenVerifyResponse() throws Exception {
        when(sessionRepository.save(any())).thenReturn(new Session(5, 1, 10));

        this.mockMvc.perform(post("/setBound")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"lowerBound\": 1, \"upperBound\": 10}"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenGuessURI_whenMockMVC_thenVerifyResponse() throws Exception {
        when(sessionRepository.findById(any())).thenReturn(Optional.of(new Session(5, 1, 10)));

        this.mockMvc.perform(post("/guess")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"currId\": 123, \"number\": 5}"))
                .andExpect(status().isOk());
    }
}
