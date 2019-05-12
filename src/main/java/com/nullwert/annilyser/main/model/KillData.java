package com.nullwert.annilyser.main.model;

public class KillData {
    private long time;
    private long red;
    private long blue;
    private long green;
    private long yellow;
    private double average;

    public KillData() {
        this.time = -1;
        this.red = -1;
        this.blue = -1;
        this.green = -1;
        this.yellow = -1;
        this.average = -1;
    }

    public KillData(long time, long red, long blue, long green, long yellow, double average) {
        this.time = time;
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.yellow = yellow;
        this.average = average;
    }

    public KillData duplicateUpdatedTime(long newTime) {
        return new KillData(newTime, red, blue, yellow, green, average);
    }

    public long getTime() {
        return time;
    }

    public long getRed() {
        return red;
    }

    public long getBlue() {
        return blue;
    }

    public long getGreen() {
        return green;
    }

    public long getYellow() {
        return yellow;
    }

    public double getAverage() {
        return average;
    }

}
