package com.nullwert.annilyser.model;

public class GameOverTeam {
    private long red;
    private long blue;
    private long green;
    private long yellow;

    public GameOverTeam() {
        red = -1;
        blue = -1;
        green = -1;
        yellow = -1;
    }

    public long getRed() {
        return red;
    }

    public void setRed(long red) {
        this.red = red;
    }

    public long getBlue() {
        return blue;
    }

    public void setBlue(long blue) {
        this.blue = blue;
    }

    public long getGreen() {
        return green;
    }

    public void setGreen(long green) {
        this.green = green;
    }

    public long getYellow() {
        return yellow;
    }

    public void setYellow(long yellow) {
        this.yellow = yellow;
    }

}
