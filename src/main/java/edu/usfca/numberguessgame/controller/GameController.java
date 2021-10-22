package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.request.GuessRequest;
import edu.usfca.numberguessgame.request.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/setBound")
    public String setBound(@RequestBody SetBoundRequest request) {
        return gameService.handleSetBound(request.getLowerBound(), request.getUpperBound(), request.getUserId());
    }

    @PostMapping("/guess")
    public String guess(@RequestBody GuessRequest request) {
        return gameService.handleGuess(request.getNumber(), request.getUserId());
    }
}

