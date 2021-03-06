package edu.usfca.numberguessgame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void instantiateGameService() {
        gameService = new GameService();
    }

    @Test
    void testValidateUserBoundInput() {
        String input = "123";
        int result = gameService.validateUserInput(input);

        assertEquals(123, result);
    }

    @Test
    void testValidateUserBoundInputEmpty() {
        String input = "";
        int result = gameService.validateUserInput(input);

        assertEquals(-1, result);
    }

    @Test
    void testValidateUserBoundInputNegative() {
        String input = "-9";
        int result = gameService.validateUserInput(input);

        assertEquals(-1,result);
    }

    @Test
    void testValidateUserBoundInputString() {
        String input = "string";
        int result = gameService.validateUserInput(input);

        assertEquals(-1, result);
    }

    @Test
    void testValidateUserBoundInputSymbol() {
        String input = "..63/*%";
        int result = gameService.validateUserInput(input);

        assertEquals(-1, result);
    }

    @Test
    void testBoundCheck() {
        int lowerBound = 1;
        int upperBound = 10;

        boolean result = gameService.boundCheck(lowerBound, upperBound);

        assertTrue(result);
    }

    @Test
    void testBoundCheckFalse() {
        int lowerBound = 20;
        int upperBound = 10;

        boolean result = gameService.boundCheck(lowerBound, upperBound);

        assertFalse(result);
    }

    @Test
    void testGenerateRandomInt() {
        int lowerBound = 1;
        int upperBound = 10;

        int result = gameService.generateRandomInt(lowerBound, upperBound);

        assertTrue(result >= lowerBound);
        assertTrue(result <= upperBound);
    }



}