package edu.usfca.numberguessgame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void instantiateGameService() {
        gameService = new GameService();
    }

    @Test
    void testValidateUserBoundInput() {
        String input = "123";
        boolean result = gameService.validateUserBoundInput(input);

        assertTrue(result);
    }
    @Test
    void testValidateUserBoundInputEmpty() {
        String input = "";
        boolean result = gameService.validateUserBoundInput(input);

        assertFalse(result);
    }

    @Test
    void testValidateUserBoundInputNegative(){
        String input = "-9";
        boolean result = gameService.validateUserBoundInput(input);

        assertFalse(result);
    }

    @Test
    void testValidateUserBoundInputString(){
        String input = "string";
        boolean result = gameService.validateUserBoundInput(input);

        assertFalse(result);
    }

    @Test
    void testValidateUserBoundInputSymbol(){
        String input = "..63/*%";
        boolean result = gameService.validateUserBoundInput(input);

        assertFalse(result);
    }

    @Test
    void testBoundCheck(){
        int lowerBound = 1;
        int upperBound = 10;

        boolean result = gameService.boundCheck(lowerBound, upperBound);

        assertTrue(result);
    }

    @Test
    void testBoundCheckFalse(){
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

    @Test
    void testVerifyGuess() {

        int result = gameService.verifyGuess(100, 100);

        assertEquals(0, result);
    }

    @Test
    void testVerifyGuessSmall() {

        int result = gameService.verifyGuess(100, 88);

        assertEquals(-1, result);
    }

    @Test
    void testVerifyGuessLarge() {

        int result = gameService.verifyGuess(100, 200);

        assertEquals(1, result);
    }

}