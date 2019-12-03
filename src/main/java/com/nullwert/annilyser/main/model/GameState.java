package com.nullwert.annilyser.main.model;

import lombok.Data;

import java.util.List;

@Data
public class GameState {
    private Meta meta;
    private List<MainStat> data;
}
