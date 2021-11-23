package edu.usfca.numberguessgame.service;

import edu.usfca.numberguessgame.model.Session;
import edu.usfca.numberguessgame.repository.SessionRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private SessionRepository sessionRepository;

    /**
     * return -1 if the input is not an integer it is smaller than 0
     * return number if the input is valid
     */
    public int validateUserInput(String input) {
        int parseInt;
        try{
            parseInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (input.matches("[0-9]+") && parseInt >= 0){
            return parseInt;
        } else {
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
     * message generator for Set bound
     */
    public Session handleSetBound(String lowerBound, String upperBound) {

        int lower = validateUserInput(lowerBound);
        int upper = validateUserInput(upperBound);

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

        return currId;
    }

    /**
     * message generator for Guess
     */
    public Session handleGuess(String currId, String number) {
        int target;
        int parsedNumber;
        int compareResult;

        Optional<Session> session = sessionRepository.findById(currId);

        if(session.isEmpty()) {
            throw new RuntimeException("Error! The userId is not found");
        }
        target = session.get().getTarget();

        parsedNumber = validateUserInput(number);

        if (parsedNumber < target) {
            throw new RuntimeException("Too Small!");
        } else if (parsedNumber > target) {
            throw new RuntimeException("Too Large!");
        }

        return session.get();
    }
}