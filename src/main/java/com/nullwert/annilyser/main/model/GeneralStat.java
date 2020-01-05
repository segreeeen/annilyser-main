package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralStat<T> {
    private T kills;
    private T deaths;
}
