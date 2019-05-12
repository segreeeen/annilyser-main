package com.nullwert.annilyser.main.model;

import com.nullwert.annilyser.model.datastructures.Kill;

public class KillMeta {
    long min;
    long max;
    long timeMax;

    public KillMeta() {
        this.min = -1;
        this.max = -1;
        this.timeMax = -1;
    }

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
