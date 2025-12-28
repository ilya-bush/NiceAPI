package learn.code.niceapi.builder;

import learn.code.niceapi.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {

    public static Inventory createFromConfig(ConfigurationSection section) {
        String title = section.getString("title", "Меню");
        int size = section.getInt("size", 27);

        Inventory inv = Bukkit.createInventory(null, size, Color.parse(title));

        ConfigurationSection itemsSection = section.getConfigurationSection("items");
        if (itemsSection != null) {
            for (String key : itemsSection.getKeys(false)) {
                ConfigurationSection itemData = itemsSection.getConfigurationSection(key);
                if (itemData == null) continue;

                int slot = itemData.getInt("slot", 0);
                inv.setItem(slot, ItemBuilder.fromConfig(itemData));
            }
        }
        return inv;
    }
}
