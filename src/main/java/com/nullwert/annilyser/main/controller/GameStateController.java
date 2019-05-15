package com.nullwert.annilyser.main.controller;

import com.nullwert.annilyser.main.model.GameState;
import com.nullwert.annilyser.main.service.AnnilyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameStateController {

    @Autowired
    private AnnilyserService anniService;

    @CrossOrigin
    @RequestMapping("/gameState")
    public GameState gamestate() {
        return anniService.getGamestate();
    }


    @RequestMapping("/start")
    public void start() {
        anniService.startAnnilyser();
    }
}
