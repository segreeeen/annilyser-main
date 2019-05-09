package com.nullwert.annilyser.model;

public class Phase {
    private long time;
    private int phase;

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
