package learn.code.niceapi.utils;

import learn.code.niceapi.NiceAPI;
import org.bukkit.ChatColor;

public class ChatUtil {
    private final NiceAPI pl;

    public ChatUtil(NiceAPI pl) {
        this.pl = pl;
    }

    // Color Parser
    private String getMessage(String path) {
        String raw = pl.getConfig().getString(path);
        if (raw == null) return "";
        return ChatColor.translateAlternateColorCodes('&', raw);
    }

    // Main Messages
    public String playerNotOnlineMessage() { return getMessage("messages.player-not-online"); }
    public String noPermissionMessage() { return getMessage("messages.no-permission"); }
    public String notPlayerMessage() { return getMessage("messages.not-player"); }
}
