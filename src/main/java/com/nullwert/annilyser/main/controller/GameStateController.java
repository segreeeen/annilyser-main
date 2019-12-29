package com.nullwert.annilyser.main.controller;

import com.nullwert.annilyser.main.model.GameState;
import com.nullwert.annilyser.main.service.AnnilyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/path/in/set")
    @ResponseBody
    public void setPathIn(@RequestParam String p) {
        anniService.setPathIn(p);
    }

    @GetMapping("/path/out/set")
    @ResponseBody
    public void setPathOut(@RequestParam String p) {
        anniService.setPathOut(p);
    }

    @GetMapping("/path/in/get")
    @ResponseBody
    public String getPathIn() {
        return anniService.getPathIn();
    }

    @GetMapping("/path/out/get")
    @ResponseBody
    public String getPathOut() {
        return anniService.getPathOut();
    }

    @GetMapping("/realtime")
    @ResponseBody
    public void setPathOut(@RequestParam Boolean realtime) {
        anniService.setRealtime(realtime);
    }

    @GetMapping("/path/detected")
    @ResponseBody
    public boolean isPathDetected() {
        return anniService.isPathDetected();
    }

    @GetMapping("/path/detect")
    @ResponseBody
    public String getPath() {
        return anniService.getDetectedPath();
    }


}
