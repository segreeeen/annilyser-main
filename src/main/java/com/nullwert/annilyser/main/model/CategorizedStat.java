package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorizedStat {
    private String kind;
    private String name;
    private String group;
    private int playercount;
    private GeneralStat relative;
    private GeneralStat absolut;
}
