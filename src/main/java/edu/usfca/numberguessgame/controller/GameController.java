package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @RequestMapping(value = "/setBound", method = RequestMethod.GET)
    public String setBound(@RequestParam String lowerBound, @RequestParam String upperBound) {
        return gameService.handleSetBound(lowerBound, upperBound);
    }

    @RequestMapping(value = "/guess", method = RequestMethod.GET)
    public String guess(@RequestParam String number) {
        return gameService.handleGuess(number);
    }
}

