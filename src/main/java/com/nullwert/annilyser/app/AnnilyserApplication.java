package com.nullwert.annilyser.app;

import com.nullwert.annilyser.gui.WebViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AnnilyserApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent root;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(AnnilyserApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Platform.exit();
                System.exit(0);
            }
        });
       new WebViewController(primaryStage).show();
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }
}
