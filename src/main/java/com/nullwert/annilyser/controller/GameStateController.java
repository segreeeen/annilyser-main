package com.nullwert.annilyser.controller;

import com.nullwert.annilyser.model.GameState;
import com.nullwert.annilyser.service.AnnilyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameStateController {

    @Autowired
    private AnnilyserService anniService;

    @RequestMapping("/greeting")
    public GameState greeting() {
        return anniService.getGamestate();
    }
}
