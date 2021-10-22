package edu.usfca.numberguessgame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void testHandleSetBoundValid(){

        String exceptedOutput = "Your Input Is Valid. Please Try To Guess It!";
        String result = gameService.handleSetBound("1","10", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleSetBoundStr(){

        String exceptedOutput = "Error! Make Sure You Entered Valid Bounds";
        String result = gameService.handleSetBound("str","alr", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleSetBoundEmpty(){

        String exceptedOutput = "Error! Make Sure You Entered Valid Bounds";
        String result = gameService.handleSetBound("","", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleSetBoundNegative(){

        String exceptedOutput = "Error! Make Sure You Entered Valid Bounds";
        String result = gameService.handleSetBound("-8","10", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleSetBoundSymbol(){

        String exceptedOutput = "Error! Make Sure You Entered Valid Bounds";
        String result = gameService.handleSetBound("!@#!@$#$%","&^*(", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleSetBoundReverse(){

        String exceptedOutput = "Error! Make Sure Upper Bound Is Greater Than Lower Bound";
        String result = gameService.handleSetBound("100","1", "abc");

        assertEquals(exceptedOutput,result);
    }

    @Test
    void testHandleGuessString(){

        String exceptedOutput = "Error! Make Sure You Entered An Integer";
        String result = gameService.handleGuess("str", "abc");

        assertEquals(exceptedOutput, result);
    }

    @Test
    void testHandleGuessSymbol(){

        String exceptedOutput = "Error! Make Sure You Entered An Integer";
        String result = gameService.handleGuess("%%%%%%", "abc");

        assertEquals(exceptedOutput, result);
    }

}