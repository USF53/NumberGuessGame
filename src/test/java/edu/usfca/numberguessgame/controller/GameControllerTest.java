package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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

    // Should return the "guess" view
    @RequestMapping(value = "/setBound", method = RequestMethod.POST)
    public String setBound(@RequestParam String lowerBound, @RequestParam String upperBound) {
    	
        return gameService.handleSetBound(lowerBound, upperBound);
    }

    // If the answer is correct then return "congrats" view otherwise return "guess" view again
    @ResponseBody
    @RequestMapping(value = "/guess", method = RequestMethod.POST)
    public String guess(Model model, @RequestBody String number) {
        return gameService.handleGuess(number);
    }
}
