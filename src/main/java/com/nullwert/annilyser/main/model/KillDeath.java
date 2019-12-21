package com.nullwert.annilyser.main.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class KillDeath  extends BaseStat{
    public KillDeath(long total, long melee, long bow, Nexus nexus) {
        super(total, melee, bow);
        this.nexus = nexus;
    }

    private Nexus nexus;
}
