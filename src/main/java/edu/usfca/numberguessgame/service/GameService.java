package edu.usfca.numberguessgame.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private int target;

    private int getTarget() {
        return target;
    }

    private void setTarget(int target) {
        this.target = target;
    }

    /**
     * return false if the input is not an integer or it is smaller than 0
     * return true if the input is valid
     */
    public boolean validateUserBoundInput(String input){
        return input.matches("[0-9]+") && Integer.parseInt(input) >= 0;
    }

    /**
     * return false if the lowerBound is equal to or greater than upperBound
     * return true if the lowerBound is smaller than upperBound
     */
    public boolean boundCheck(int lowerBound, int upperBound) {
        return lowerBound < upperBound;
    }

    /**
     * return a random integer which is larger than or equals to lowerBound and smaller than or equals to upperBound
     */
    public int generateRandomInt(int lowerBound, int upperBound) {
        return (int)(Math.random()*(upperBound - lowerBound + 1)) + lowerBound;

    }

    /**
     * return 0 if the guess number equals to the target;
     * return -1 if the guess number is smaller than the target;
     * return 1 if the guess number is larger than the target.
     */
    public int verifyGuess(int target, int guess) {
        if(guess == target) {
            return 0;
        }
        else if(guess < target) {
            return -1;
        }
        else {
            return 1;
        }
    }

    /**
     * message generator for Set bound
     */
    public String handleSetBound(String lowerBound, String upperBound) {
        if (validateUserBoundInput(lowerBound) && validateUserBoundInput(upperBound)) {
            int lower = Integer.parseInt(lowerBound);
            int upper = Integer.parseInt(upperBound);

            if (boundCheck(lower, upper)) {
                setTarget(generateRandomInt(lower, upper));
                return "Your Input Is Valid. Please Try To Guess It!";
            } else {
                return "Error! Make Sure Upper Bound Is Greater Than Lower Bound";
            }
        }
        return "Error! Make Sure You Entered Valid Bounds";
    }

    /**
     * message generator for Guess
     */

    public String handleGuess(String number) {
        int parsedNumber;
        int target = getTarget();
        if(number.matches("[0-9]+")){
            parsedNumber = Integer.parseInt(number);
            int compareResult = verifyGuess(target, parsedNumber);
            if (parsedNumber<0){
                return "Error! make Sure You Entered An Positive Integer";
            }
            else if(compareResult < 0) {
                return "Too Small!";
            }
            else if(compareResult > 0) {
                return "Too Large!";
            }
            else {
                return "Correct!";
            }
        }else{
            return "Error! Make Sure You Entered An Integer";
        }
    }
}