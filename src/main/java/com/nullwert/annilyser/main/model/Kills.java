package com.nullwert.annilyser.main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Kills {
    private KillMeta meta;
    private List<KillData> data;
    private KillData lastKillData;

    public Kills() {
        this.meta = new KillMeta();
        this.data = new CopyOnWriteArrayList<>();
    }

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
        this.lastKillData = data;
        this.data.add(data);
    }

    public KillData getLastKillData() {
        return lastKillData;
    }
}
