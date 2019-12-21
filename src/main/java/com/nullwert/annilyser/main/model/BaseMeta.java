package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseMeta {
    private long killsmin;
    private long killsmax;
    private long deathmin;
    private long deathmax;
}
