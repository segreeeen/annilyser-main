package com.nullwert.annilyser.main.model;

import com.nullwert.annilyser.model.datastructures.IKillDeathStats;
import com.nullwert.annilyser.model.datastructures.IStatistic;
import com.nullwert.annilyser.model.datastructures.TeamRelation;
import com.nullwert.annilyser.model.listener.events.KillEvent;
import com.nullwert.annilyser.parser.token.Token;

import java.util.*;
import java.util.stream.Collectors;

public class CategorizedStatFactory {

    public static List<CategorizedStat> createKillsDeathListFromKillEvent(KillEvent killEvent) {
        List<CategorizedStat> stats = new LinkedList<>();
        List<CategorizedStat> teams = killEvent.getTeams().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        List<CategorizedStat> players = killEvent.getPlayers().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        List<CategorizedStat> classes = killEvent.getKlassen().stream().map(CategorizedStatFactory::createCategorizedStat).sorted(Comparator.comparing(CategorizedStat::getName)).collect(Collectors.toList());
        stats.addAll(teams);
        stats.addAll(players);
        stats.addAll(classes);
        return stats;
    }

    public static List<CategorizedStat> createTeamVsTeamFromKillEvent(KillEvent killEvent) {
        List<CategorizedStat> list = killEvent.getTeams().stream().map(CategorizedStatFactory::createCategorizedTeamRelationStat).collect(Collectors.toList());
        return list;
    }

    public static CategorizedStat createCategorizedStat(IStatistic statistic) {
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
        return new CategorizedStat<>(kind, name, group, playerCount,
                new GeneralStat<>(
                        new KillDeath(relativeKillsTotal, relativeKillsMelee, relativeKillsBow, new Nexus(new BaseStat(relativeKillsNexusAttackTotal, relativeKillsNexusAttackMelee, relativeKillsNexusAttackBow), new BaseStat(relativeKillsNexusDefendTotal, relativeKillsNexusDefendMelee, relativeKillsNexusDefendBow))),
                        new KillDeath(relativeDeathsTotal, relativeDeathsMelee, relativeDeathsBow, new Nexus(new BaseStat(relativeDeathsNexusAttackTotal, relativeDeathsNexusAttackMelee, relativeDeathsNexusAttackBow), new BaseStat(relativeDeathsNexusDefendTotal, relativeDeathsNexusDefendMelee, relativeDeathsNexusDefendBow)))),
                new GeneralStat<>(
                        new KillDeath(absoluteKillsTotal, absoluteKillsMelee, absoluteKillsBow, new Nexus(new BaseStat(absoluteKillsNexusAttackTotal, absoluteKillsNexusAttackMelee, absoluteKillsNexusAttackBow), new BaseStat(absoluteKillsNexusDefendTotal, absoluteKillsNexusDefendMelee, absoluteKillsNexusDefendBow))),
                        new KillDeath(absoluteDeathsTotal, absoluteDeathsMelee, absoluteDeathsBow, new Nexus(new BaseStat(absoluteDeathsNexusAttackTotal, absoluteDeathsNexusAttackMelee, absoluteDeathsNexusAttackBow), new BaseStat(absoluteDeathsNexusDefendTotal, absoluteDeathsNexusDefendMelee, absoluteDeathsNexusDefendBow)))));
    }

    private static CategorizedStat<GeneralStat<Map<String, KillDeath>>> createCategorizedTeamRelationStat(IStatistic statistic) {
        Map<String, KillDeath> relkills = new HashMap<>();
        Map<String, KillDeath> reldeaths = new HashMap<>();
        Map<String, KillDeath> abskills = new HashMap<>();
        Map<String, KillDeath> absdeaths = new HashMap<>();
        for (IStatistic relation: statistic.getRelations()) {
            TeamRelation teamRelation = (TeamRelation) relation;
            IKillDeathStats relativeKills = relation.getRelativeKillstats();
            IKillDeathStats relativeDeaths = relation.getRelativeDeathstats();
            relkills.put(teamRelation.getEnemy().toString().toLowerCase(), new KillDeath(relativeKills.getTotal(), relativeKills.getMelee(), relativeKills.getBow(), new Nexus(new BaseStat(relativeKills.getNexusAttack(), relativeKills.getMeleeNexusAttack(), relativeKills.getBowNexusAttack()), new BaseStat(relativeKills.getNexusDefense(), relativeKills.getMeleeNexusDefense(), relativeKills.getBowNexusDefense()))));
            reldeaths.put(teamRelation.getEnemy().toString().toLowerCase(), new KillDeath(relativeDeaths.getTotal(), relativeDeaths.getMelee(), relativeDeaths.getBow(), new Nexus(new BaseStat(relativeDeaths.getNexusAttack(), relativeDeaths.getMeleeNexusAttack(), relativeDeaths.getBowNexusAttack()), new BaseStat(relativeDeaths.getNexusDefense(), relativeDeaths.getMeleeNexusDefense(), relativeDeaths.getBowNexusDefense()))));

            IKillDeathStats absoluteKills = relation.getAbsoluteKillstats();
            IKillDeathStats absoluteDeaths = relation.getAbsoluteDeathstats();
            abskills.put(teamRelation.getEnemy().toString().toLowerCase(), new KillDeath(absoluteKills.getTotal(), absoluteKills.getMelee(), absoluteKills.getBow(), new Nexus(new BaseStat(absoluteKills.getNexusAttack(), absoluteKills.getMeleeNexusAttack(), absoluteKills.getBowNexusAttack()), new BaseStat(absoluteKills.getNexusDefense(), absoluteKills.getMeleeNexusDefense(), absoluteKills.getBowNexusDefense()))));
            absdeaths.put(teamRelation.getEnemy().toString().toLowerCase(), new KillDeath(absoluteDeaths.getTotal(), absoluteDeaths.getMelee(), absoluteDeaths.getBow(), new Nexus(new BaseStat(absoluteDeaths.getNexusAttack(), absoluteDeaths.getMeleeNexusAttack(), absoluteDeaths.getBowNexusAttack()), new BaseStat(absoluteDeaths.getNexusDefense(), absoluteDeaths.getMeleeNexusDefense(), absoluteDeaths.getBowNexusDefense()))));

        }

        GeneralStat<Map<String, KillDeath>> relativeKd = new GeneralStat<>(relkills, reldeaths);
        GeneralStat<Map<String, KillDeath>> absoluteKd = new GeneralStat<>(abskills, absdeaths);

        return new CategorizedStat<GeneralStat<Map<String, KillDeath>>>(statistic.getKind().name().toLowerCase(), statistic.getName(), statistic.getGroup(), statistic.getPlayerCount(),
                relativeKd, absoluteKd);
    }

    private static CategorizedStat<GeneralStat<Map<String, KillDeath>>> createCategorizedTeamRelationStat() {
        return null;
    }

}
