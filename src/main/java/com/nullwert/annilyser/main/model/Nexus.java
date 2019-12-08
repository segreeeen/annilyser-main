package com.nullwert.annilyser.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Nexus {
    private BaseStat defend;
    private BaseStat attack;
}
