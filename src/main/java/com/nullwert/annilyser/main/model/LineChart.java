package com.nullwert.annilyser.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LineChart extends Chart<LineChartData, LineChartMeta>{

    public LineChart() {
        super.meta = new LineChartMeta();
        super.data = new CopyOnWriteArrayList<>();
    }
}
