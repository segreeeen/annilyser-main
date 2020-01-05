package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorizedStat<T> {
    private String kind;
    private String name;
    private String group;
    private int playercount;
    private T relative;
    private T absolut;
}
