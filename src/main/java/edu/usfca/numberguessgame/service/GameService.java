package edu.usfca.numberguessgame.service;

import edu.usfca.numberguessgame.model.GuessRequest;
import edu.usfca.numberguessgame.model.Session;
import edu.usfca.numberguessgame.repository.SessionRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class GameService {

	// change to SessionRepository
    @Autowired
    private SessionRepository sessionRepository;

    /**
     * return -1 if the input is not an integer it is smaller than 0
     * return number if the input is valid
     */
    public int validateUserInput(String input) {
        if (input.matches("[0-9]+") && Integer.parseInt(input) >= 0){
            return Integer.parseInt(input);
        }else{
            return -1;
        }
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
    public Session handleSetBound(String lowerBound, String upperBound, Model model) {

        int lower = validateUserInput(lowerBound);
        int upper = validateUserInput(upperBound);
        if(lower==-1 || upper==-1){
        	// invalid bounds exception
        	throw new RuntimeException("Error! Make Sure You Entered Valid Bounds");
        }

        if (!boundCheck(lower, upper)) {
        	// out of bounds exception
        	throw new RuntimeException("Error! Make Sure Upper Bound Is Greater Than Lower Bound");
        }

        int target = generateRandomInt(lower, upper);

        Session session = new Session(target, lower, upper);

        Session currId =  sessionRepository.save(session);
        if (currId == null) {
        	throw new RuntimeException("Error saving new session data");
        }

        model.addAttribute("currId",currId.getId());

//        boundResponse= "Your Input Is Valid. Please Try To Guess It!";

        return currId;
    }

    /**
     * message generator for Guess
     */

    public Session handleGuess(GuessRequest guessRequest, Model model) {
        int target;
        int parsedNumber;
        int compareResult;

        String guessResponse;
        model.addAttribute("currId",guessRequest.getCurrId());

        String currId = guessRequest.getCurrId();

        Optional<Session> session = sessionRepository.findById(currId);

        if(session.isEmpty()) {
//            return "Error! The userId is not found";
        	// throw exception
        }
        target = session.get().getTarget();

        parsedNumber = validateUserInput(guessRequest.getNumber());
        compareResult = verifyGuess(target, parsedNumber);

        if (parsedNumber<0){
            guessResponse=  "Error! Make Sure You Entered An Positive Integer";
            // throw new Exception
        }
        else if(compareResult < 0) {
            guessResponse= "Too Small!";
            // throw new Exception
        }
        else if(compareResult > 0) {
            guessResponse= "Too Large!";
            // throw new Exception
        }
//        else {
//            guessResponse= "Correct!";
//            return Session
//        }

//        if(guessResponse.equals("Correct!")) {
//            return "congrats";
//        }else {
//            model.addAttribute("guess",guessResponse);
//            return "guess";
//        }
        return session;
    }
}