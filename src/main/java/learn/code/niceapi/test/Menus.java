package learn.code.niceapi.test;

import learn.code.niceapi.NiceAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Menus {

    private final NiceAPI plugin;
    private FileConfiguration menusConfig;
    private File menusFile;

    public Menus(NiceAPI plugin) {
        this.plugin = plugin;
        setup();
    }

    public void setup() {
        this.menusFile = new File(plugin.getDataFolder(), "menus.yml");

        if (!menusFile.exists()) {
            menusFile.getParentFile().mkdirs();
            plugin.saveResource("menus.yml", false);
        }

        this.menusConfig = YamlConfiguration.loadConfiguration(menusFile);
    }

    public FileConfiguration getMenusConfig() {
        return menusConfig;
    }

    public void save() {
        try {
            menusConfig.save(menusFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Couldn't save menus.yml");
        }
    }

    public void reload() {
        menusConfig = YamlConfiguration.loadConfiguration(menusFile);
    }

}
