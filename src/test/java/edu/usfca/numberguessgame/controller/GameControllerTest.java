package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.request.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameController.class)
@ContextConfiguration(classes = {GameController.class, GameService.class})
public class GameControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    GameController gameController;

    @Test
    public void testSetBoundValid() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/setBound")
                        .param("lowerBound", "1")
                        .param("upperBound", "10")
                        .param("userId", "abc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = "Your Input Is Valid. Please Try To Guess It!";

        assertEquals(expected, response);
    }

    @Test
    public void testSetBoundReverse() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/setBound")
                        .param("lowerBound", "100")
                        .param("upperBound", "10")
                        .param("userId", "abc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String expected = "Error! Make Sure Upper Bound Is Greater Than Lower Bound";

        assertEquals(expected, response);
    }


    @Test
    public void testGuess() throws Exception {
        gameController.setBound(new SetBoundRequest("1","10", "abc"));

        MvcResult mvcResult = mvc.perform(get("/guess")
                        .param("number","6")
                        .param("userId", "abc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        String [] message = {"Too Small!", "Too Large!","Correct!","Error! make Sure You Entered An Positive Integer"};

        assertTrue(Arrays.asList(message).contains(response));
    }
}
