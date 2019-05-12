package com.nullwert.annilyser.main.model;

import com.nullwert.annilyser.model.datastructures.Kill;

public class LineChartMeta implements IChartMeta {
    long min;
    long max;
    long timeMax;

    public LineChartMeta() {
        this.max = 0;
        this.min = 0;
        this.timeMax = 0;
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
