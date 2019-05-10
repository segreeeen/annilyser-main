package com.nullwert.annilyser;

import com.nullwert.annilyser.app.AnnilyserApplication;
import com.nullwert.annilyser.gui.AnnilyserPreloader;
import com.sun.javafx.application.LauncherImpl;

public class Main {
    public static void main(String[] args) {
        LauncherImpl.launchApplication(AnnilyserApplication.class, AnnilyserPreloader.class, args);
    }
}
