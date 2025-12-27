package learn.code.niceapi.utils;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Logs {

    private static ComponentLogger logger;
    private static String prefix = "";

    public static void init(@NotNull ComponentLogger pluginLogger, @Nullable String pluginName) {

        logger = pluginLogger;
        prefix = (pluginName != null) ? "[" + pluginName + "] " : "";

    }

    public static void init(@NotNull ComponentLogger pluginLogger) {

        init(pluginLogger, null);

    }

    /**
     * Main method of logging (support <green>, <red> etc.)
     */
    public static void log(String message) {

        if (logger != null) {

            logger.info(Color.parse(prefix + message));

        } else {

            System.out.println("[NiceAPI-Fallback] " + message);

        }

    }

    /**
     * Warn method of loggings
     * By default sending message to console with <yellow> color
     */
    public static void warnLog(String message) {

        if (logger != null) {

            logger.warn(Color.parse("<yellow>" + prefix + message));

        }

    }

    /**
     * Error method of logging
     * By default sending message to console with <red> color
     */
    public static void errorLog(String message) {

        if (logger != null) {

            logger.error(Color.parse("<red>" + prefix + message));

        }

    }
}