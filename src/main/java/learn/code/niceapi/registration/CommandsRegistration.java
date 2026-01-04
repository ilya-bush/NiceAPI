package learn.code.niceapi.registration;

import learn.code.niceapi.test.menus.KillCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CommandsRegistration {

    public static void registerCommands(JavaPlugin plugin) {

        Objects.requireNonNull(plugin.getCommand("kill-gui")).setExecutor(new KillCommand());

    }

}
