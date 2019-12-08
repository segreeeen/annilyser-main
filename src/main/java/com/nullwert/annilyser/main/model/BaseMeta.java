package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseMeta {
    private int killsmin;
    private int killsmax;
    private int deathmin;
    private int deathmax;
}
