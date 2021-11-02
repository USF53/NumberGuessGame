package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.model.GuessRequest;
import edu.usfca.numberguessgame.model.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    // Main View
    @GetMapping(value = {"", "/"})
    public String main(Model model) {
        return "main";
    }

    @PostMapping (value = "/setBound")
    public String setBound(SetBoundRequest request,Model model) {
        // remove model from service call
        // service should return session on success or throw an error
        // surround with a try catch, then determine page based on error or success
        // can get error message with exception that was caught
        return gameService.handleSetBound(request.getLowerBound(), request.getUpperBound(),model);
    }

    @PostMapping("/guess")
    public String guess(GuessRequest request,Model model) {
        // remove model from service call
        // pass session id and guess to function not the request
        // or make a helper function that takes out the data from the guessrequest object
        // service should return session on success or throw an error
        // surround with a try catch, then determine page based on error or success
        // can get error message with exception that was caught
        return gameService.handleGuess(request,model);
    }
}

