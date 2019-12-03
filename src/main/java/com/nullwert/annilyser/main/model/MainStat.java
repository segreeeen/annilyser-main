package com.nullwert.annilyser.main.model;

import lombok.Data;

@Data
public class MainStat {
    private String kind;
    private String name;
    private String group;
    private int playercount;
    MainStat relative;
    MainStat absolut;
}
