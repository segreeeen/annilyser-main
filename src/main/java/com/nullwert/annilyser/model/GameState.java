package com.nullwert.annilyser.model;

import java.util.LinkedList;
import java.util.List;

public class GameState {
    private Meta meta;
    private List<Phase> phase = new LinkedList<>();
    private GameOverTeam outOfGame;
    private Kills kills;

    public GameState(Meta meta, GameOverTeam outOfGame, Kills kills) {
        this.meta = meta;
        this.outOfGame = outOfGame;
        this.kills = kills;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
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
