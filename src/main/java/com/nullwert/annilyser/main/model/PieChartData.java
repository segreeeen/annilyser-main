package com.nullwert.annilyser.main.model;

public class PieChartData implements IChartData {

    private long red;
    private long blue;
    private long green;
    private long yellow;


    public PieChartData() {
        this.red = 0;
        this.blue = 0;
        this.green = 0;
        this.yellow = 0;
    }

    public PieChartData(long red, long blue, long green, long yellow) {
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.yellow = yellow;
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

}
