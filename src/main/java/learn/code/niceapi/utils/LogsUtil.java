package learn.code.niceapi.utils;

import java.util.logging.Logger;

public class LogsUtil {
    private static Logger logger;
    private static String prefix = "";

    /**
     * Initialize logger util
     * @param pluginLogger - logger with JavaPlugin.getLogger()
     * @param pluginName - plugin name (optional)
     */
    public static void init(Logger pluginLogger, String pluginName) {
        logger = pluginLogger;
        prefix = pluginName != null ? "[" + pluginName + "] " : "";
    }

    /**
     * Simple initialization only with logger
     */
    public static void init(Logger pluginLogger) {
        init(pluginLogger, null);
    }

    /**
     * Main function of logging
     */
    public static void log(String message) {
        if (logger != null) {
            logger.info(prefix + message);
        } else {
            // Fallback if forget initialize
            System.out.println("[NiceAPI] " + message);
            System.out.println("[NiceAPI] WARNING: LoggerUtil not initialized! Add LogsUtil.init() в onEnable()");
        }
    }

    /**
     * Additional methods (optional)
     */
    public static void warn(String message) {
        if (logger != null) logger.warning(prefix + message);
    }

    public static void error(String message) {
        if (logger != null) logger.severe(prefix + message);
    }
}