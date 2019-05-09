package com.nullwert.annilyser.service;

import com.nullwert.annilyser.LogAnalyser;
import com.nullwert.annilyser.model.*;
import com.nullwert.annilyser.model.listener.GamestateChangeListener;
import com.nullwert.annilyser.model.listener.KillListener;
import com.nullwert.annilyser.model.listener.events.GamestateEvent;
import com.nullwert.annilyser.model.listener.events.KillEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnnilyserService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnilyserService.class);
    private LogAnalyser anilyser = new LogAnalyser();

    public GameState getGamestate() {
        Meta meta = new Meta(0,"coastal",1000,4,-1,"green",UUID.randomUUID());

        Phase phase = new Phase(1000, 1);

        GameOverTeam got = new GameOverTeam();
        got.setGreen(1004);
        got.setYellow(2056);

        KillMeta kMeta = new KillMeta(0, 19, 4567);

        Kills kills = new Kills(kMeta);
        KillData kd1 = new KillData(566,5,6,0,4,8);
        KillData kd2 = new KillData(1567,6, 8, 5, 4,10.004);
        KillData kd3 = new KillData(2667,8,10,7,6, 10.024);
        KillData kd4 = new KillData(4567,10,15,10,19,10.034);

        kills.addKillData(kd1);
        kills.addKillData(kd2);
        kills.addKillData(kd3);
        kills.addKillData(kd4);

        GameState gs = new GameState(meta,got,kills);
        gs.addPhase(phase);
        return gs;

    }

    @Override
    public void run(String... args) throws Exception {
        anilyser.registerGamestateChangeListener(new gamestateListener());
        anilyser.registerKillListener(new killListener());
        anilyser.startParser("C:\\Users\\Torin\\Documents\\git\\annilyser\\Annilyser\\src\\main\\java\\com\\nullwert\\annilyser\\logsim\\testlog.txt", false);
    }

    class gamestateListener implements GamestateChangeListener {
        @Override
        public void fireChangeEvent(GamestateEvent gamestateEvent) {
            logger.info(gamestateEvent.getValue().name());
        }
    }

    class killListener implements KillListener {
        @Override
        public void fireChangeEvent(KillEvent killEvent) {
            logger.info(killEvent.getValue().getKiller().getName() + " killed " + killEvent.getValue().getVictim().getName());
        }
    }
}
