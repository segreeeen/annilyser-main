package com.nullwert.annilyser.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
public class GameState {
    Map<String, IStatisticComponent> gameState;
    Map<Long, Map<String, Map<String, Long>>> nexusradar;

    public GameState(IStatisticComponent killsDeath) {
        this.gameState = new HashMap<>();
        this.nexusradar = new HashMap<>();
        gameState.put("killsDeath", killsDeath);
    }

    public void setKillsDeath(IStatisticComponent killsDeath) {
        gameState.put("killsDeath", killsDeath);
    }

    public static GameState getDefaultGameState() {
        return new GameState(KillsDeath.createDefaultKillsDeath());
    }

    public void addNexusRadarValue(Long second, String nexusteam, String victimteam) {
        Map<String, Map<String, Long>> nexusteamMap = nexusradar.computeIfAbsent(second, k -> new HashMap<>());
        Map<String, Long> victimteamMap = nexusteamMap.computeIfAbsent(nexusteam, k -> new HashMap<>());
        if (victimteamMap.get(victimteam) != null) {
            victimteamMap.put(victimteam, victimteamMap.get(victimteam) + 1);
        } else {
            victimteamMap.put(victimteam, 1L);
        }
    }

    @JsonIgnore
    public Long getLatestNexusRadarEntry() {
        Optional<Long> o = nexusradar.keySet().stream().max(Long::compare);
        return o.orElse(0L);

    }
}
