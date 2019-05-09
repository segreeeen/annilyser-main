package com.nullwert.annilyser.model;

public class KillMeta {
    long min;
    long max;
    long timeMax;

    public KillMeta(long min, long max, long timeMax) {
        this.min = min;
        this.max = max;
        this.timeMax = timeMax;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getTimeMax() {
        return timeMax;
    }

    public void setTimeMax(long timeMax) {
        this.timeMax = timeMax;
    }
}
