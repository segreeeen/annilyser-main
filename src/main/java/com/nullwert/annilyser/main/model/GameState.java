package com.nullwert.annilyser.main.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GameState {
    Map<String, IStatisticComponent> gameState;

    public GameState(IStatisticComponent killsDeath) {
        this.gameState = new HashMap<>();
        gameState.put("killsDeath", killsDeath);
    }

    public void setKillsDeath(IStatisticComponent killsDeath) {
        gameState.put("killsDeath", killsDeath);
    }

    public static GameState getDefaultGameState() {
        return new GameState(KillsDeath.createDefaultKillsDeath());
    }
}
