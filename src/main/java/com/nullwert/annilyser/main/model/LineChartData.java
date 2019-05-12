package com.nullwert.annilyser.main.model;

public class LineChartData implements IChartData{
    private long time;
    private long red;
    private long blue;
    private long green;
    private long yellow;
    private double average;

    public LineChartData() {
        this.time = 0;
        this.red = 0;
        this.blue = 0;
        this.green = 0;
        this.yellow = 0;
        this.average = 0;
    }

    public LineChartData(long time, long red, long blue, long green, long yellow, double average) {
        this.time = time;
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.yellow = yellow;
        this.average = average;
    }

    public LineChartData duplicateUpdatedTime(long newTime) {
        return new LineChartData(newTime, red, blue, green, yellow, average);
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
