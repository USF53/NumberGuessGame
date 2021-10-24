package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.model.GuessRequest;
import edu.usfca.numberguessgame.model.SetBoundRequest;
import edu.usfca.numberguessgame.service.GameService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class GameController {

    @Autowired
    GameService gameService;

    // Main View
    @GetMapping(value = { "", "/" })
    public String main(Model model) {


        return "main";
    }

    @RequestMapping (value = "/setBound")
    public String setBound(SetBoundRequest request,HttpSession session,Model model) {

        String boundOutput = gameService.handleSetBound(request.getLowerBound(), request.getUpperBound(), session);



        if(boundOutput.equals("Your Input Is Valid. Please Try To Guess It!")) {
            model.addAttribute("bound","");
            return "guess";
        }else {

            model.addAttribute("bound",boundOutput);
            return "main";
        }


    }

    @PostMapping("/guess")
    public String guess(GuessRequest request,HttpSession session,Model model) {

        String guessOutput = gameService.handleGuess(request.getNumber(),session);

        if(guessOutput.equals("Correct!")) {
            model.addAttribute("guess","");
            return "congrats";
        }else {
            model.addAttribute("guess",guessOutput);
            return "guess";
        }

    }
}

