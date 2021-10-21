package edu.usfca.numberguessgame.controller;

import edu.usfca.numberguessgame.models.Session;
import edu.usfca.numberguessgame.repositories.SessionRepository;
import edu.usfca.numberguessgame.service.GameService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    SessionRepository sessionRepository;


    @GetMapping(value = { "", "/" })
    public String main(Model model) {
        model.addAttribute("sessionlist", sessionRepository.findAll());
        return "main";
    }

    @RequestMapping(value = "/setBound", method = RequestMethod.POST)
    public String setBound(@ModelAttribute Session session) {
        sessionRepository.save(session);
        return "main";
    }

    @RequestMapping(value = "/guess", method = RequestMethod.GET)
    public String guess(@RequestParam String number) {
        return gameService.handleGuess(number);
    }


}

