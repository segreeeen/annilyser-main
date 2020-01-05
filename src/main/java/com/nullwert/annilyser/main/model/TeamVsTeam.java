package com.nullwert.annilyser.main.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TeamVsTeam implements IStatisticComponent {
    private Meta meta;
    //          team    kills/death                     otherteam
    private Map<String, CategorizedStat<GeneralStat<Map<String, KillDeath>>>> data = new HashMap<>();
}
