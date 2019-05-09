package com.nullwert.annilyser.model;

import java.util.UUID;

public class Meta {

    private long startTime;
    private String mapName;
    private int totalKills;
    private int killsPerSecond;
    private int gameState;
    private String winner;
    private UUID datasetUID;

    public Meta(long startTime, String mapName, int totalKills, int killsPerSecond, int gameState, String winner, UUID datasetUID) {
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

    public int getKillsPerSecond() {
        return killsPerSecond;
    }

    public void setKillsPerSecond(int killsPerSecond) {
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
