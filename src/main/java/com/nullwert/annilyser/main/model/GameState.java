package com.nullwert.annilyser.main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameState {
    private GameStateMeta gameStateMeta;
    private List<Phase> phase;
    private GameOverTeam outOfGame;
    private Kills kills;

    public GameState(GameStateMeta gameStateMeta, GameOverTeam outOfGame, Kills kills) {
        this.gameStateMeta = gameStateMeta;
        this.outOfGame = outOfGame;
        this.kills = kills;
        this.phase = new CopyOnWriteArrayList<>();
    }

    public GameStateMeta getGameStateMeta() {
        return gameStateMeta;
    }

    public void setGameStateMeta(GameStateMeta gameStateMeta) {
        this.gameStateMeta = gameStateMeta;
    }

    public List<Phase> getPhase() {
        return phase;
    }

    public void setPhase(List<Phase> phase) {
        this.phase = phase;
    }

    public GameOverTeam getOutOfGame() {
        return outOfGame;
    }

    public void setOutOfGame(GameOverTeam outOfGame) {
        this.outOfGame = outOfGame;
    }

    public Kills getKills() {
        return kills;
    }

    public void setKills(Kills kills) {
        this.kills = kills;
    }

    public void addPhase(Phase phase) {
        this.phase.add(phase);
    }
}
