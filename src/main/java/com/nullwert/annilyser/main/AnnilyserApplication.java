package com.nullwert.annilyser.main;

import lombok.Getter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AnnilyserApplication implements ApplicationRunner {
    private static final String LOGPATH_IN_OPTION_NAME = "logpath.in";
    private static final String LOGPATH_OUT_OPTION_NAME = "logpath.out";

    @Getter
    private static String LOG_PATH_IN;

    @Getter
    private static String LOG_PATH_OUT;

    public static void main(String[] args) {
        SpringApplication.run(AnnilyserApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> listIn = args.getOptionValues(LOGPATH_IN_OPTION_NAME);
        if (listIn == null) {
            AnnilyserApplication.LOG_PATH_IN = "./testlog_input.log";
        } else {
            AnnilyserApplication.LOG_PATH_IN = listIn.stream().findFirst().orElse("./testlog_input.log");
        }

        List<String> listOut = args.getOptionValues(LOGPATH_OUT_OPTION_NAME);
        if (listOut == null) {
            AnnilyserApplication.LOG_PATH_OUT = "./testlog_output.log";
        } else {
            AnnilyserApplication.LOG_PATH_OUT = listOut.stream().findFirst().orElse("./testlog_output.log");
        }
    }
}