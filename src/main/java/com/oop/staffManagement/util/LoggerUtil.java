package com.oop.staffManagement.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    public static Logger getLogger(String className) {
        Logger logger = Logger.getLogger(className);
        try {
            if (logger.getHandlers().length == 0) {
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler.setLevel(Level.ALL);
                logger.addHandler(consoleHandler);

                FileHandler fileHandler = new FileHandler("app.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                fileHandler.setLevel(Level.ALL);
                logger.addHandler(fileHandler);

                logger.setLevel(Level.ALL);
                logger.setUseParentHandlers(false);
            }
        } catch (Exception e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
        return logger;
    }
}
