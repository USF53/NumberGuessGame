package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.model.GuessRequest;
import edu.usfca.numberguessgame.model.Session;
import edu.usfca.numberguessgame.model.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    // Main View
    @GetMapping(value = {"", "/"})
    public String main(Model model) {
        return "main";
    }

    @PostMapping (value = "/setBound")
    public String setBound(SetBoundRequest request,Model model) {
    	String page;
    	try {
    		Session session = gameService.handleSetBound(request.getLowerBound(), request.getUpperBound(),model);
    		
    		model.addAttribute("session",  session);
    		model.addAttribute("bound", "Your Input Is Valid. Please Try To Guess It!");
    		
    		page = "guess";
    	} catch (Exception e) {
    		// log exception for visibility
    		model.addAttribute("bound", e.getMessage());
    		
    		page = "main";
    	}
    	
        return page;
    }

    @PostMapping("/guess")
    public String guess(GuessRequest request,Model model) {
    	String page;
    	try {
    		Session session = gameService.handleGuess(request,model);
    		
    		model.addAttribute("", session);
    		
    		page = "";
    	} catch (Exception e) {
    		// log
    		model.addAttribute("", "");
    		
    		page = "something";
    	}
    	return page;
    }
}

