package edu.usfca.numberguessgame.service;

import edu.usfca.numberguessgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class GameService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * return false if the input is not an integer or it is smaller than 0
     * return true if the input is valid
     */
    public boolean validateUserBoundInput(String input) {
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
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;

    }

    /**
     * return 0 if the guess number equals to the target;
     * return -1 if the guess number is smaller than the target;
     * return 1 if the guess number is larger than the target.
     */
    public int verifyGuess(int target, int guess) {
        if (guess == target) {
            return 0;
        } else if (guess < target) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * message generator for Set bound
     */
    public String handleSetBound(String lowerBound, String upperBound, HttpSession session) {

        if (validateUserBoundInput(lowerBound) && validateUserBoundInput(upperBound)) {
            int lower = Integer.parseInt(lowerBound);
            int upper = Integer.parseInt(upperBound);

            if (boundCheck(lower, upper)) {

                int target = generateRandomInt(lower, upper);

                User user = new User(target, lower, upper);

                User currUser = mongoTemplate.save(user);

                session.setAttribute("currId", currUser.get_id());


                return "Your Input Is Valid. Please Try To Guess It!";
            } else {
                System.out.println("Error! Make Sure Upper Bound Is Greater Than Lower Bound");
                return "Error! Make Sure Upper Bound Is Greater Than Lower Bound";
            }
        }
        return "Error! Make Sure You Entered Valid Bounds";
    }

    /**
     * message generator for Guess
     */
    public String handleGuess(String number, HttpSession session) {
        int parsedNumber;

        String currId = (String) session.getAttribute("currId");

        User user = mongoTemplate.findById(currId, User.class);

        if (user == null) {
            return "Error! The userId is not found";
        }

        int target = user.getTarget();

        try {
            parsedNumber = Integer.parseInt(number);
        } catch (Exception e) {
            return "Error! Make Sure You Entered An Integer";
        }

        int compareResult = verifyGuess(target, parsedNumber);
        if (parsedNumber < 0) {
            return "Error! make Sure You Entered An Positive Integer";
        } else if (compareResult < 0) {
            return "Too Small!";
        } else if (compareResult > 0) {
            return "Too Large!";
        } else {
            return "Correct!";
        }
    }
}