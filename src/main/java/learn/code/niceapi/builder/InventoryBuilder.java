package learn.code.niceapi.builder;

import learn.code.niceapi.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private final Inventory inventory;

    public InventoryBuilder(String title, int size) {
        this.inventory = Bukkit.createInventory(null, size, Color.parse(title));
    }

    public static Inventory createFromConfig(ConfigurationSection section) {
        String title = section.getString("title", "Menu");
        int size = section.getInt("size", 27);

        Inventory inv = Bukkit.createInventory(null, size, Color.parse(title));

        ConfigurationSection items = section.getConfigurationSection("items");
        if (items != null) {
            for (String key : items.getKeys(false)) {
                ConfigurationSection itemSec = items.getConfigurationSection(key);

                ItemStack item = ItemBuilder.fromConfig(itemSec);

                int slot = itemSec.getInt("slot", 0);
                inv.setItem(slot, item);
            }
        }
        return inv;
    }

}
