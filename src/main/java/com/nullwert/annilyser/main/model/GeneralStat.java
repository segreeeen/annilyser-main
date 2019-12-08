package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralStat {
    private KillDeath kills;
    private KillDeath deaths;
}
