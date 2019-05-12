package com.nullwert.annilyser.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

 abstract class Chart<T extends IChartData, S extends IChartMeta>{
    S meta;
    List<T> data;


    @JsonIgnore
    private T lastChartData;

    public Chart() {

    }

    public Chart(S meta, List<T> data) {
        this.meta = meta;
        this.data = data;
    }

    public Chart(S meta) {
        this.meta = meta;
    }

    public S getMeta() {
        return meta;
    }

    public void setMeta(S meta) {
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void addKillData(T data) {
        this.lastChartData = data;
        this.data.add(data);
    }

    public T getLastChartData() {
        return lastChartData;
    }
}
