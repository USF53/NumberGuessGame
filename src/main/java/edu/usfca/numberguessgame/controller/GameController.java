package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.request.GuessRequest;
import edu.usfca.numberguessgame.request.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController
@Controller
public class GameController {

    @Autowired
    GameService gameService;

    // Main View
    @GetMapping(value = { "", "/" })
    public String main(Model model) {
        return "main";
    }

    @RequestMapping (value = "/setBound", method = RequestMethod.POST)
    public String setBound(@RequestBody SetBoundRequest request) {
        gameService.handleSetBound(request.getLowerBound(), request.getUpperBound(), request.getUserId());
        return "guess";
    }

    @PostMapping("/guess")
    public String guess(@RequestBody GuessRequest request) {
        return gameService.handleGuess(request.getNumber(), request.getUserId());
    }
}

