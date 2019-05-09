package com.nullwert.annilyser.model;

import java.util.LinkedList;
import java.util.List;

public class Kills {
    private KillMeta meta;
    private List<KillData> data = new LinkedList<>();

    public Kills(KillMeta meta) {
        this.meta = meta;
    }

    public KillMeta getMeta() {
        return meta;
    }

    public void setMeta(KillMeta meta) {
        this.meta = meta;
    }

    public List<KillData> getData() {
        return data;
    }

    public void setData(List<KillData> data) {
        this.data = data;
    }

    public void addKillData(KillData data) {
        this.data.add(data);
    }
}
