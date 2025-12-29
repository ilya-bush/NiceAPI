package learn.code.niceapi;

import learn.code.niceapi.utils.Logs;
import static learn.code.niceapi.utils.Logs.log;

import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NiceAPI extends JavaPlugin {

    private static final Logger log = LoggerFactory.getLogger(NiceAPI.class);

    public NiceAPI() {}

    @Override
    public void onEnable() {

        // Logs util initialization
        Logs.init(getComponentLogger(), getName());

        log("<green>NiceAPI Enabled!");
        log("<green>[NiceAPI] Version: " + getDescription().getVersion());

    }

    @Override
    public void onDisable() {

        log("NiceAPI Disabled!");

    }
}