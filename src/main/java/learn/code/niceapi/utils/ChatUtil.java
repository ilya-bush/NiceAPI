package learn.code.niceapi.utils;

import learn.code.niceapi.NiceAPI;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class ChatUtil {
    private final NiceAPI pl;

    public ChatUtil(NiceAPI pl) {
        this.pl = pl;
    }

    // Color Parser
    private String getMessage(String path) {
        String raw = pl.getConfig().getString(path);
        if (raw == null) return ChatColor.RED + "Missing " + path;
        return ChatColor.translateAlternateColorCodes('&', raw);
    }

    // Main Messages
    public String playerNotOnlineMessage() { return getMessage("messages.player-not-online"); }
    public String noPermissionMessage() { return getMessage("messages.no-permission"); }
    public String notPlayerMessage() { return getMessage("messages.not-player"); }

    // Bow Command Messages
    public String givedBowMessage() { return getMessage("messages.gived-bow"); }
    public String giveOnJoinMessage() { return getMessage("messages.give-on-join"); }
    public String bowNameMessage() { return getMessage("messages.bow"); }
    public String bowDescriptionMessage() { return getMessage("messages.bow-description"); }

    // Feed Command Messages (/feed)
    public String fedMessage() { return getMessage("messages.fed"); }

    // Fly Command Messages (/fly)
    public String flyOnMessage() { return getMessage("messages.fly-on"); }
    public String flyOffMessage() { return getMessage("messages.fly-off"); }

    // God Command Messages (/god)
    public String godOnMessage() { return getMessage("god-on"); }
    public String godOffMessage() { return getMessage("god-off"); }

    // Heal Command Messages (/heal)
    public String healedMessage() { return getMessage("messages.healed"); }

    // Invisible Command Messages (/invisible)
    public String invisibleOnMessage() { return getMessage("messages.invisible-on"); }
    public String invisibleOffMessage() { return getMessage("messages.invisible-off"); }

    // Clear Inventory Command Messages (/clearinventory)
    public String clearedInventoryMessage() { return getMessage("messages.cleared-inventory"); }

    // On Events Messages
    public String shearSheepMessage() { return getMessage("messages.shear-sheep"); }
    public String shearMushroomCowMessage() { return getMessage("messages.shear-mushroom-cow"); }

    // Spawn And SetSpawn Commands Messages (/spawn, /setspawn)
    public String spawnSetMessage() { return getMessage("messages.spawn-set"); }
    public String spawnNotSetMessage() { return getMessage("messages.spawn-not-set"); }
    public String teleportedToSpawnMessage() { return getMessage("messages.teleported-to-spawn"); }
    public Location getSpawnLocationMessage() { return pl.getConfig().getLocation("spawn"); }
    public String getWorldName() { return pl.getConfig().getString("spawn.world"); }
    public double getX() { return pl.getConfig().getDouble("spawn.x"); }
    public double getY() { return pl.getConfig().getDouble("spawn.y"); }
    public double getZ() { return pl.getConfig().getDouble("spawn.z"); }
}
