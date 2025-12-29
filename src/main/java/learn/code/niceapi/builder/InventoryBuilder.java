package learn.code.niceapi.builder;

import learn.code.niceapi.NiceAPI;
import learn.code.niceapi.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryBuilder {

    private static NiceAPI plugin;

    public static Inventory createFromConfig(ConfigurationSection section, InventoryHolder holder) {

        String title = section.getString("title", "Menu");
        int size = section.getInt("size", 27);

        Inventory inv = Bukkit.createInventory(holder, size, Color.parse(title));

        ConfigurationSection itemsSection = section.getConfigurationSection("items");
        if (itemsSection != null) {
            for (String key : itemsSection.getKeys(false)) {
                ConfigurationSection itemData = itemsSection.getConfigurationSection(key);
                if (itemData == null) continue;

                ItemStack item = ItemBuilder.fromConfig(section);

                if (itemData.isList("slot")) {

                    List<Integer> slots = itemData.getIntegerList("slot");

                    for (int s : slots) {

                        if (s >= 0 && s < size) {

                            inv.setItem(s, item);

                        }

                    }

                } else {

                    int slot = itemData.getInt("slot", 0);
                    if (slot >= 0 && slot < size) {

                        inv.setItem(slot, item);

                    }
                }
            }
        }

        return inv;
    }
}
