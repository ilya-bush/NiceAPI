package learn.code.niceapi;

import learn.code.niceapi.registration.CommandsRegistration;
import learn.code.niceapi.utils.LogsUtils;
import static learn.code.niceapi.utils.LogsUtils.log;

import org.bukkit.plugin.java.JavaPlugin;

public final class NiceAPI extends JavaPlugin {

    private final String pluginVersion = getDescription().getVersion();

    @Override
    public void onEnable() {

        // Commands registration
        CommandsRegistration.registerCommands(this);

        // Logs util initialization
        LogsUtils.init(getComponentLogger(), getName());

        log("<green>NiceAPI Enabled!");
        log("<green>[NiceAPI] Version: " + pluginVersion);

    }

    @Override
    public void onDisable() {

        log("NiceAPI Disabled!");

    }

}