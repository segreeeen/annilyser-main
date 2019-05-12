package com.nullwert.annilyser.main.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameState {
    private GameStateMeta gameStateMeta;
    private List<Phase> phase;
    private GameOverTeam outOfGame;
    private LineChart kills;

    public LineChart getKillsdeathscore() {
        return killsdeathscore;
    }

    public void setKillsdeathscore(LineChart killsdeathscore) {
        this.killsdeathscore = killsdeathscore;
    }

    public LineChart getKillspersec() {
        return killspersec;
    }

    public void setKillspersec(LineChart killspersec) {
        this.killspersec = killspersec;
    }

    public PieChart getBowkills() {
        return bowkills;
    }

    public void setBowkills(PieChart bowkills) {
        this.bowkills = bowkills;
    }

    public PieChart getNonbowkills() {
        return nonbowkills;
    }

    public void setNonbowkills(PieChart nonbowkills) {
        this.nonbowkills = nonbowkills;
    }

    public PieChart getOtherpie() {
        return otherpie;
    }

    public void setOtherpie(PieChart otherpie) {
        this.otherpie = otherpie;
    }

    private LineChart killsdeathscore;
    private LineChart killspersec;
    private PieChart bowkills;
    private PieChart nonbowkills;
    private PieChart otherpie;

    public GameState() {
        this.gameStateMeta = new GameStateMeta();
        this.outOfGame = new GameOverTeam();
        this.kills = new LineChart();
        this.killsdeathscore = new LineChart();
        this.killspersec = new LineChart();
        this.phase = new CopyOnWriteArrayList<>();
        this.bowkills = new PieChart();
        this.nonbowkills = new PieChart();
        this.otherpie = new PieChart();
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

    public LineChart getKills() {
        return kills;
    }

    public void setKills(LineChart kills) {
        this.kills = kills;
    }

    public void addPhase(Phase phase) {
        this.phase.add(phase);
    }
}
