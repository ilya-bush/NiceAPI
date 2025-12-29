package learn.code.niceapi.test;

import learn.code.niceapi.NiceAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MenuListener implements Listener {

    private final NiceAPI plugin;

    public MenuListener(NiceAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();
        if (e.getClickedInventory() == null) { return; }
        if (e.getCurrentItem() == null) { return; }

        if (inventory.getHolder(false) instanceof MenuHolder) {

            switch (e.getCurrentItem().getType()) {

                case DIAMOND_SWORD -> OpenSecondMenu.openSecondMenu(plugin, player);

            }

            e.setCancelled(true);

        }

    }

}
