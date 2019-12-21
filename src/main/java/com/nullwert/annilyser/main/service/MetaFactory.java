package com.nullwert.annilyser.main.service;

import com.nullwert.annilyser.main.model.BaseMeta;
import com.nullwert.annilyser.main.model.Meta;
import com.nullwert.annilyser.model.listener.events.KillEvent;

import java.util.function.LongSupplier;

public class MetaFactory {
    public static Meta createMetaFromKillEvent(KillEvent killEvent) {
        Meta meta = new Meta();

        long killsMinClass = killEvent.getKlassen().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).min().orElse(0);
        long killsMaxClass = killEvent.getKlassen().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).max().orElse(0);
        long deathsMinClass = killEvent.getKlassen().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).min().orElse(0);
        long deathsMaxClass = killEvent.getKlassen().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).max().orElse(0);

        long killsMinTeam = killEvent.getTeams().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).min().orElse(0);
        long killsMaxTeam = killEvent.getTeams().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).max().orElse(0);
        long deathsMinTeam = killEvent.getTeams().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).min().orElse(0);
        long deathsMaxTeam = killEvent.getTeams().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).max().orElse(0);

        long killsMinPlayer = killEvent.getPlayers().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).min().orElse(0);
        long killsMaxPlayer = killEvent.getPlayers().stream().mapToLong(a -> a.getAbsoluteKillstats().getTotal()).max().orElse(0);
        long deathsMinPlayer = killEvent.getPlayers().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).min().orElse(0);
        long deathsMaxPlayer = killEvent.getPlayers().stream().mapToLong(a -> a.getAbsoluteDeathstats().getTotal()).max().orElse(0);

        BaseMeta classMeta = new BaseMeta(killsMinClass, killsMaxClass, deathsMinClass, deathsMaxClass);
        BaseMeta teamMeta = new BaseMeta(killsMinTeam, killsMaxTeam, deathsMinTeam, deathsMaxTeam);
        BaseMeta playerMeta = new BaseMeta(killsMinPlayer, killsMaxPlayer, deathsMinPlayer, deathsMaxPlayer);
        meta.setClazz(classMeta);
        meta.setTeam(teamMeta);
        meta.setPlayer(playerMeta);

        return meta;
    }
}
