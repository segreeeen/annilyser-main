package com.nullwert.annilyser.main.service;


import com.nullwert.annilyser.LogAnalyser;
import com.nullwert.annilyser.model.listener.GamestateChangeListener;
import com.nullwert.annilyser.model.listener.KillListener;
import com.nullwert.annilyser.model.listener.NexusListener;
import com.nullwert.annilyser.model.listener.PhaseChangeListener;
import com.nullwert.annilyser.model.listener.events.GamestateEvent;
import com.nullwert.annilyser.model.listener.events.KillEvent;
import com.nullwert.annilyser.model.listener.events.NexusEvent;
import com.nullwert.annilyser.model.listener.events.PhaseChangeEvent;
import com.nullwert.annilyser.main.model.GameState;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class AnnilyserService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AnnilyserService.class);
    private LogAnalyser anilyser = new LogAnalyser();
    private volatile Object gameStateMetaLock;

    @Getter
    private GameState gamestate;

    @Override
    public void run(String... args) throws Exception {
        anilyser.registerGamestateChangeListener(new gamestateListener());
        anilyser.registerKillListener(new killListener());
        anilyser.registerNexusListener(new nexusListener());
        anilyser.registerPhaseChangeListener(new phaseChangeListener());
    }

    public AnnilyserService() {
        this.gamestate = GameState.createDefaultGamestate();
    }

    public void startAnnilyser() {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
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
