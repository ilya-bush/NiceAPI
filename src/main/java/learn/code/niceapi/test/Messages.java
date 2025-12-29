package learn.code.niceapi.test;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Messages {

    public static void sectionNotFound(Player player, ConfigurationSection section) {

        player.sendMessage("Error: Section " + section + " not found!");

    }

}
