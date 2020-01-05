package com.nullwert.annilyser.main.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class KillsDeath implements IStatisticComponent {
    private Meta meta;
    private List<CategorizedStat> data;

    public KillsDeath(Meta meta, List<CategorizedStat> data) {
        this.meta = meta;
        this.data = data;
    }

    private KillsDeath() {
        this.data = new LinkedList<>();
    }

    public static KillsDeath createDefaultKillsDeath() {
        KillsDeath state = new KillsDeath();
        Meta meta = new Meta();
        meta.setClazz(new BaseMeta(0, 10, 0, 10));
        meta.setTeam(new BaseMeta(0, 10, 0, 10));
        meta.setPlayer(new BaseMeta(0, 10, 0, 10));
        state.setMeta(meta);

        state.getData().add(new CategorizedStat<>("TEAM", "YELLOW", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("TEAM", "RED", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("TEAM", "GREEN", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("TEAM", "BLUE", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("PLAYER", "Horst_Frank", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("PLAYER", "SeGreeeen", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("CLASS", "Scout", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        state.getData().add(new CategorizedStat<>("CLASS", "Scorpio", "", 0,
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0)))),
                new GeneralStat<>(
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))),
                        new KillDeath(0, 0, 0, new Nexus(new BaseStat(0, 0, 0), new BaseStat(0, 0, 0))))));

        return state;
    }
}
