package com.nullwert.annilyser.main.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class PieChart extends Chart<PieChartData, PieChartMeta> {

    public PieChart() {
        super.meta = new PieChartMeta();
        super.data = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addKillData(PieChartData data) {
        super.data = new CopyOnWriteArrayList<>();
        super.data.add(data);
    }
}
