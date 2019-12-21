package com.nullwert.annilyser.main.model;

import com.nullwert.annilyser.model.datastructures.IStatistic;
import com.nullwert.annilyser.model.listener.events.KillEvent;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorizedStatFactory {

    public static List<CategorizedStat> createStatListFromKillEvent(KillEvent killEvent) {
        List<CategorizedStat> stats = new LinkedList<>();
        List<CategorizedStat> teams = killEvent.getTeams().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        List<CategorizedStat> players = killEvent.getPlayers().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        List<CategorizedStat> classes = killEvent.getKlassen().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        stats.addAll(teams);
        stats.addAll(players);
        stats.addAll(classes);
        return stats;
    }

    private static CategorizedStat createCategorizedStat(IStatistic statistic) {
        return createCategorizedStat(statistic.getKind().toString(),statistic.getName(), statistic.getGroup(),
                statistic.getPlayerCount(),
                statistic.getRelativeKillstats().getTotal(),
                statistic.getRelativeKillstats().getMelee(),
                statistic.getRelativeKillstats().getBow(),
                statistic.getRelativeKillstats().getNexusAttack(),
                statistic.getRelativeKillstats().getMeleeNexusAttack(),
                statistic.getRelativeKillstats().getBowNexusAttack(),
                statistic.getRelativeKillstats().getNexusDefense(),
                statistic.getRelativeKillstats().getMeleeNexusDefense(),
                statistic.getRelativeKillstats().getBowNexusDefense(),
                statistic.getRelativeDeathstats().getTotal(),
                statistic.getRelativeDeathstats().getMelee(),
                statistic.getRelativeDeathstats().getBow(),
                statistic.getRelativeDeathstats().getNexusAttack(),
                statistic.getRelativeDeathstats().getMeleeNexusAttack(),
                statistic.getRelativeDeathstats().getBowNexusAttack(),
                statistic.getRelativeDeathstats().getNexusDefense(),
                statistic.getRelativeDeathstats().getMeleeNexusDefense(),
                statistic.getRelativeDeathstats().getBowNexusDefense(),
                statistic.getAbsoluteKillstats().getTotal(),
                statistic.getAbsoluteKillstats().getMelee(),
                statistic.getAbsoluteKillstats().getBow(),
                statistic.getAbsoluteKillstats().getNexusAttack(),
                statistic.getAbsoluteKillstats().getMeleeNexusAttack(),
                statistic.getAbsoluteKillstats().getBowNexusAttack(),
                statistic.getAbsoluteKillstats().getNexusDefense(),
                statistic.getAbsoluteKillstats().getMeleeNexusDefense(),
                statistic.getAbsoluteKillstats().getBowNexusDefense(),
                statistic.getAbsoluteDeathstats().getTotal(),
                statistic.getAbsoluteDeathstats().getMelee(),
                statistic.getAbsoluteDeathstats().getBow(),
                statistic.getAbsoluteDeathstats().getNexusAttack(),
                statistic.getAbsoluteDeathstats().getMeleeNexusAttack(),
                statistic.getAbsoluteDeathstats().getBowNexusAttack(),
                statistic.getAbsoluteDeathstats().getNexusDefense(),
                statistic.getAbsoluteDeathstats().getMeleeNexusDefense(),
                statistic.getAbsoluteDeathstats().getBowNexusDefense());
    }

    private static CategorizedStat createCategorizedStat(String kind,
                                                         String name,
                                                         String group,
                                                         int playerCount,
                                                         long relativeKillsTotal,
                                                         long relativeKillsMelee,
                                                         long relativeKillsBow,
                                                         long relativeKillsNexusAttackTotal,
                                                         long relativeKillsNexusAttackMelee,
                                                         long relativeKillsNexusAttackBow,
                                                         long relativeKillsNexusDefendTotal,
                                                         long relativeKillsNexusDefendMelee,
                                                         long relativeKillsNexusDefendBow,
                                                         long relativeDeathsTotal,
                                                         long relativeDeathsMelee,
                                                         long relativeDeathsBow,
                                                         long relativeDeathsNexusAttackTotal,
                                                         long relativeDeathsNexusAttackMelee,
                                                         long relativeDeathsNexusAttackBow,
                                                         long relativeDeathsNexusDefendTotal,
                                                         long relativeDeathsNexusDefendMelee,
                                                         long relativeDeathsNexusDefendBow,
                                                         long absoluteKillsTotal,
                                                         long absoluteKillsMelee,
                                                         long absoluteKillsBow,
                                                         long absoluteKillsNexusAttackTotal,
                                                         long absoluteKillsNexusAttackMelee,
                                                         long absoluteKillsNexusAttackBow,
                                                         long absoluteKillsNexusDefendTotal,
                                                         long absoluteKillsNexusDefendMelee,
                                                         long absoluteKillsNexusDefendBow,
                                                         long absoluteDeathsTotal,
                                                         long absoluteDeathsMelee,
                                                         long absoluteDeathsBow,
                                                         long absoluteDeathsNexusAttackTotal,
                                                         long absoluteDeathsNexusAttackMelee,
                                                         long absoluteDeathsNexusAttackBow,
                                                         long absoluteDeathsNexusDefendTotal,
                                                         long absoluteDeathsNexusDefendMelee,
                                                         long absoluteDeathsNexusDefendBow) {
        return new CategorizedStat(kind, name, group, playerCount,
                new GeneralStat(
                        new KillDeath(relativeKillsTotal, relativeKillsMelee, relativeKillsBow, new Nexus(new BaseStat(relativeKillsNexusAttackTotal, relativeKillsNexusAttackMelee, relativeKillsNexusAttackBow), new BaseStat(relativeKillsNexusDefendTotal, relativeKillsNexusDefendMelee, relativeKillsNexusDefendBow))),
                        new KillDeath(relativeDeathsTotal, relativeDeathsMelee, relativeDeathsBow, new Nexus(new BaseStat(relativeDeathsNexusAttackTotal, relativeDeathsNexusAttackMelee, relativeDeathsNexusAttackBow), new BaseStat(relativeDeathsNexusDefendTotal, relativeDeathsNexusDefendMelee, relativeDeathsNexusDefendBow)))),
                new GeneralStat(
                        new KillDeath(absoluteKillsTotal, absoluteKillsMelee, absoluteKillsBow, new Nexus(new BaseStat(absoluteKillsNexusAttackTotal, absoluteKillsNexusAttackMelee, absoluteKillsNexusAttackBow), new BaseStat(absoluteKillsNexusDefendTotal, absoluteKillsNexusDefendMelee, absoluteKillsNexusDefendBow))),
                        new KillDeath(absoluteDeathsTotal, absoluteDeathsMelee, absoluteDeathsBow, new Nexus(new BaseStat(absoluteDeathsNexusAttackTotal, absoluteDeathsNexusAttackMelee, absoluteDeathsNexusAttackBow), new BaseStat(absoluteDeathsNexusDefendTotal, absoluteDeathsNexusDefendMelee, absoluteDeathsNexusDefendBow)))));
    }

}
