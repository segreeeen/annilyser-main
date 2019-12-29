package com.nullwert.annilyser.main.service;


import com.nullwert.annilyser.LogAnalyser;
import com.nullwert.annilyser.main.AnnilyserApplication;
import com.nullwert.annilyser.main.model.*;
import com.nullwert.annilyser.model.datastructures.Kill;
import com.nullwert.annilyser.model.listener.GamestateChangeListener;
import com.nullwert.annilyser.model.listener.KillListener;
import com.nullwert.annilyser.model.listener.NexusListener;
import com.nullwert.annilyser.model.listener.PhaseChangeListener;
import com.nullwert.annilyser.model.listener.events.GamestateEvent;
import com.nullwert.annilyser.model.listener.events.KillEvent;
import com.nullwert.annilyser.model.listener.events.NexusEvent;
import com.nullwert.annilyser.model.listener.events.PhaseChangeEvent;
import com.nullwert.annilyser.parser.token.Token;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class AnnilyserService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnilyserService.class);
    private LogAnalyser anilyser;
    private volatile Object gameStateMetaLock;

    @Getter
    private GameState gamestate;

    @Getter
    private boolean started;
    private String pathIn = null;
    private String pathOut = null;
    private boolean realtime = true;

    @Override
    public void run(String... args) throws Exception {
        this.anilyser = new LogAnalyser(AnnilyserApplication.getLOG_PATH_IN(), AnnilyserApplication.getLOG_PATH_OUT());
        this.pathIn = AnnilyserApplication.getLOG_PATH_IN();
        this.pathOut = AnnilyserApplication.getLOG_PATH_OUT();
        this.gamestate = GameState.getDefaultGameState();
    }

    public AnnilyserService() {

    }

    public void startAnnilyser() {
        if (!started) {
            if (this.pathIn != null) {
                this.anilyser.setFileIn(pathIn);
            }
            if (this.pathOut != null) {
                this.anilyser.setFileOut(pathOut);
            }
            anilyser.registerGamestateChangeListener(new gamestateListener());
            anilyser.registerKillListener(new killListener());
            anilyser.registerNexusListener(new nexusListener());
            anilyser.registerPhaseChangeListener(new phaseChangeListener());
            try {
                anilyser.startParser(realtime);
                this.started = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isPathDetected() {
        return LogAnalyser.isPathDetected();
    }

    public String getPath() {
        return LogAnalyser.getPath();
    }

    public void setPathIn(String pathIn) {
        this.pathIn = pathIn;
    }

    public void setPathOut(String pathOut) {
        this.pathOut = pathOut;
    }

    public void setRealtime(boolean realtime) {
        this.realtime = realtime;
    }

    public String getPathIn() {
        return this.pathIn;
    }

    public String getPathOut() {
        return this.pathOut;
    }


    private void updateNexusRadar(KillEvent killEvent) {
        Kill k = killEvent.getValue();
        if (k.getAttackmode() == Token.Attackmode.ATTACK) {
            gamestate.getGameState().addNexusRadarValue(k.getTimestampSeconds(), k.getVictim().getTeam().name().toLowerCase(), k.getVictim().getTeam().name().toLowerCase());
        } else if (k.getAttackmode() == Token.Attackmode.DEFENSE) {
            gamestate.getGameState().addNexusRadarValue(k.getTimestampSeconds(), k.getKiller().getTeam().name().toLowerCase(), k.getVictim().getTeam().name().toLowerCase());
        }
    }

    class gamestateListener implements GamestateChangeListener {
        @Override
        public void fireChangeEvent(GamestateEvent gamestateEvent) {
        }
    }

    class killListener implements KillListener {
        @Override
        public void fireChangeEvent(KillEvent killEvent) {
            List<CategorizedStat> killsDeath = CategorizedStatFactory.createStatListFromKillEvent(killEvent);
            Meta meta = MetaFactory.createMetaFromKillEvent(killEvent);
            KillsDeath kd = new KillsDeath(meta, killsDeath);
            gamestate.getGameState().setKillsDeath(kd);
            updateNexusRadar(killEvent);
        }
    }

    class phaseChangeListener implements PhaseChangeListener {
        @Override
        public void fireChangeEvent(PhaseChangeEvent phaseChangeEvent) {
        }
    }

    class nexusListener implements NexusListener {
        @Override
        public void fireChangeEvent(NexusEvent nexusEvent) {
        }
    }
}
