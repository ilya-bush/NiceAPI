package learn.code.niceapi.test;

import learn.code.niceapi.NiceAPI;
import learn.code.niceapi.builder.InventoryBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenSecondMenu {

    public static Inventory openSecondMenu(NiceAPI plugin, Player player) {

        ConfigurationSection section = plugin.getMenusManager().getMenusConfig()
                .getConfigurationSection("menus.second-menu");

        if (section != null) {

            Inventory inv = InventoryBuilder.createFromConfig(plugin, section, player);
            player.openInventory(inv);

        } else {

            player.sendMessage(ChatColor.RED + "Eror4ik, menushka ne naydena.");

        }

        return null;
    }
}

