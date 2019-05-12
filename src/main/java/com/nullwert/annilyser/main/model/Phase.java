package com.nullwert.annilyser.main.model;

public class Phase {
    private long time;
    private int phase;

    public Phase() {
        this.time = -1;
        this.phase = -1;
    }

    public Phase(long time, int phase) {
        this.time = time;
        this.phase = phase;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
