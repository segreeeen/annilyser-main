package com.nullwert.annilyser.main.model;

import java.util.UUID;

public class GameStateMeta {

    private long startTime;
    private String mapName;
    private int totalKills;
    private long killsPerSecond;
    private int gameState;
    private String winner;
    private UUID datasetUID;

    public GameStateMeta() {
        this.startTime = -1;
        this.mapName = null;
        this.totalKills = -1;
        this.killsPerSecond = -1;
        this.gameState = -1;
        this.winner = null;
        this.datasetUID = UUID.randomUUID();
    }

    public GameStateMeta(long startTime, String mapName, int totalKills, int killsPerSecond, int gameState, String winner, UUID datasetUID) {
        this.startTime = startTime;
        this.mapName = mapName;
        this.totalKills = totalKills;
        this.killsPerSecond = killsPerSecond;
        this.gameState = gameState;
        this.winner = winner;
        this.datasetUID = datasetUID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public long getKillsPerSecond() {
        return killsPerSecond;
    }

    public void setKillsPerSecond(long killsPerSecond) {
        this.killsPerSecond = killsPerSecond;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public UUID getDatasetUID() {
        return datasetUID;
    }

    public void setDatasetUID(UUID datasetUID) {
        this.datasetUID = datasetUID;
    }
}
