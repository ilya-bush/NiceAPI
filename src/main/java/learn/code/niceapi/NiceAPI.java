package learn.code.niceapi;

import org.bukkit.plugin.java.JavaPlugin;
import static learn.code.niceapi.utils.LogsUtil.log;

public final class NiceAPI extends JavaPlugin {
    @Override
    public void onEnable() {
        learn.code.niceapi.utils.LogsUtil.init(this.getLogger(), this.getName());

        log("Enabled!");
        log("Version: " + this.getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        log("Disabled!");
    }
}