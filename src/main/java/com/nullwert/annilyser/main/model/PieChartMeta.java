package com.nullwert.annilyser.main.model;

public class PieChartMeta implements IChartMeta{
    private long min;
    private long max;
    private long total;
    private long timeMax;
    private long secPerKill;


    public PieChartMeta() {
        this.max = 0;
        this.min = 0;
        this.timeMax = 0;
    }

    public PieChartMeta(long min, long max, long total, long timemax, long secPerKill) {
        this.max = max;
        this.min = min;
        this.timeMax = timemax;
        this.total = total;
        this.secPerKill = secPerKill;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSecPerKill() {
        return secPerKill;
    }

    public void setSecPerKill(long secPerKill) {
        this.secPerKill = secPerKill;
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
