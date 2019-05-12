package com.nullwert.annilyser.main.service;


import com.nullwert.annilyser.LogAnalyser;
import com.nullwert.annilyser.main.model.*;
import com.nullwert.annilyser.model.listener.GamestateChangeListener;
import com.nullwert.annilyser.model.listener.KillListener;
import com.nullwert.annilyser.model.listener.NexusListener;
import com.nullwert.annilyser.model.listener.PhaseChangeListener;
import com.nullwert.annilyser.model.listener.events.GamestateEvent;
import com.nullwert.annilyser.model.listener.events.KillEvent;
import com.nullwert.annilyser.model.listener.events.NexusEvent;
import com.nullwert.annilyser.model.listener.events.PhaseChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class AnnilyserService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnilyserService.class);
    private LogAnalyser anilyser = new LogAnalyser();
    private GameState gameState;

    @Override
    public void run(String... args) throws Exception {
        this.gameState = new GameState(new GameStateMeta(), new GameOverTeam(), new Kills());
        anilyser.registerGamestateChangeListener(new gamestateListener());
        anilyser.registerKillListener(new killListener());
        anilyser.registerNexusListener(new nexusListener());
        anilyser.registerPhaseChangeListener(new phaseChangeListener());
    }

    public  AnnilyserService() {

    }

    public GameState getGamestate() {
        return this.gameState;
    }

    public void startAnnilyser() {
        anilyser.startParser(false);
    }

    public void stopAnnilyser() {
        anilyser.stopParser();
    }

    private KillData mapKillData(KillEvent killEvent) {
        KillData kd = new KillData(killEvent.getValue().getTimestampSeconds(),
                killEvent.getRedKills(),
                killEvent.getBlueKills(),
                killEvent.getGreenKills(),
                killEvent.getYellowKills(),
                killEvent.getKillAverage());
        return kd;
    }

    private KillMeta mapKillMeta(KillEvent killEvent) {
        KillMeta km = new KillMeta();
        km.setMax(killEvent.getMaxKills());
        km.setMin(killEvent.getMinKills());
        km.setTimeMax(killEvent.getValue().getTimestampSeconds());
        return km;
    }

    private GameOverTeam mapGameOverTeam(NexusEvent nexusEvent) {
        GameOverTeam got = this.gameState.getOutOfGame();
        long timestamp = nexusEvent.getValue().getTimestampSeconds();
        switch (nexusEvent.getValue().getTeam()) {
            case RED:
                got.setRed(timestamp);
                break;
            case BLUE:
                got.setBlue(timestamp);
                break;
            case GREEN:
                got.setGreen(timestamp);
                break;
            case YELLOW:
                got.setYellow(timestamp);
                break;
            default:
                return gameState.getOutOfGame();
        }
        return got;
    }

    private GameStateMeta mapGameStateMeta(KillEvent killEvent, PhaseChangeEvent pce, GamestateEvent ge) {
        GameStateMeta gsm = this.gameState.getGameStateMeta();

        if (killEvent != null) {
            gsm.setKillsPerSecond(killEvent.getKillsPerSecond());
            gsm.setTotalKills(killEvent.getKillsTotal());
        }

        if (pce != null) {
            switch (pce.getValue()) {
                case ONE:
                    this.gameState.getGameStateMeta().setGameState(1);
                    break;
                case TWO:
                    this.gameState.getGameStateMeta().setGameState(2);
                    break;
                case THREE:
                    this.gameState.getGameStateMeta().setGameState(3);
                    break;
                case FOUR:
                    this.gameState.getGameStateMeta().setGameState(4);
                    break;
                case FIVE:
                    this.gameState.getGameStateMeta().setGameState(5);
                    break;
                default: break;
            }
        }

        if (ge != null) {
            switch (ge.getValue()) {
                case IDLE:
                    this.gameState.getGameStateMeta().setGameState(-1);
                    break;
                case STARTED:
                    this.gameState.getGameStateMeta().setGameState(0);
                    this.gameState.getGameStateMeta().setStartTime(ge.getTimestampSeconds());
                    break;
                case DONE:
                    this.gameState.getGameStateMeta().setGameState(6);
                    break;
                default:
                    break;
            }
        }

        return gsm;
    }

    private void updateGameStateMeta(GameStateMeta gsm) {
        this.gameState.setGameStateMeta(gsm);
    }

    private void updateKills(KillMeta km, KillData kd) {
        if (gameState.getKills().getLastKillData() != null) {
            KillData duplicateUpdatedTime = gameState.getKills().getLastKillData().duplicateUpdatedTime(kd.getTime());
            gameState.getKills().addKillData(duplicateUpdatedTime);
        }

        this.gameState.getKills().addKillData(kd);
        this.gameState.getKills().setMeta(km);
    }

    private void updateGameOverTeam(GameOverTeam got) {
        this.gameState.setOutOfGame(got);
    }

    private void updatePhase(PhaseChangeEvent pce) {
        switch (pce.getValue()) {
            case ONE:
                this.gameState.addPhase(new Phase(pce.getTimestampSeconds(),1));
                break;
            case TWO:
                this.gameState.addPhase(new Phase(pce.getTimestampSeconds(),2));
                break;
            case THREE:
                this.gameState.addPhase(new Phase(pce.getTimestampSeconds(),3));
                break;
            case FOUR:
                this.gameState.addPhase(new Phase(pce.getTimestampSeconds(),4));
                break;
            case FIVE:
                this.gameState.addPhase(new Phase(pce.getTimestampSeconds(),5));
                break;
            default: break;
        }

    }

    public String getLogPath() {
        return anilyser.getLogPath();
    }

    public boolean setLogPath(String path) {
        if (Files.exists(Paths.get(path))) {
            anilyser.setLogPath(path);
            return true;
        }
        return false;
    }




    class gamestateListener implements GamestateChangeListener {
        @Override
        public void fireChangeEvent(GamestateEvent gamestateEvent) {
            updateGameStateMeta(mapGameStateMeta(null, null, gamestateEvent));
        }
    }

    class killListener implements KillListener {
        @Override
        public void fireChangeEvent(KillEvent killEvent) {
            updateKills(mapKillMeta(killEvent), mapKillData(killEvent));
            updateGameStateMeta(mapGameStateMeta(killEvent, null, null));
        }
    }

    class phaseChangeListener implements PhaseChangeListener {
        @Override
        public void fireChangeEvent(PhaseChangeEvent phaseChangeEvent) {
            updatePhase(phaseChangeEvent);
            updateGameStateMeta(mapGameStateMeta(null, phaseChangeEvent, null));
        }
    }

    class nexusListener implements NexusListener {
        @Override
        public void fireChangeEvent(NexusEvent nexusEvent) {
            updateGameOverTeam(mapGameOverTeam(nexusEvent));
        }
    }
}
