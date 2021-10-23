package edu.usfca.numberguessgame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GameController {
    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @RequestMapping(value = { "" })
    public String main(Model model) {
        log.debug("main running");
        //model.addAttribute("msg","hello world");
        return "main";
    }
}

