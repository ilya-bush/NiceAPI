package learn.code.niceapi.test;

import learn.code.niceapi.NiceAPI;
import learn.code.niceapi.builder.InventoryBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenMainMenu {

    public static Inventory openMainMenu(NiceAPI plugin, Player player) {

        ConfigurationSection section = plugin.getMenusManager().getMenusConfig()
                .getConfigurationSection("menus.main-menu");

        if (section != null) {

            MenuHolder holder = new MenuHolder();
            Inventory inv = InventoryBuilder.createFromConfig(plugin, section, holder);
            holder.setInventory(inv);
            player.openInventory(inv);

        } else {

            player.sendMessage(ChatColor.RED + "Eror4ik, menushka ne naydena.");

        }

        return null;
    }
}
