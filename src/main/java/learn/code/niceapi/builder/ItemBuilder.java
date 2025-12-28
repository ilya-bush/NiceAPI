package learn.code.niceapi.builder;

import learn.code.niceapi.utils.Color;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder name(String text) {
        meta.displayName(Color.parse(text).decoration(net.kyori.adventure.text.format.TextDecoration.ITALIC, false));
        return this;
    }

    public ItemBuilder lore(List<String> lines) {
        List<Component> lore = lines.stream()
                .map(line -> Color.parse(line).decoration(net.kyori.adventure.text.format.TextDecoration.ITALIC, false))
                .collect(Collectors.toList());
        meta.lore(lore);
        return this;
    }

    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    // Parsing from configuration
    public ItemStack ofSection(ConfigurationSection section) {
        Material material = Material.matchMaterial(section.getString("material", "STONE"));
        ItemBuilder builder = new ItemBuilder(material);

        if (section.contains("display-name")) {
            builder.name(section.getString("display-name"));
        }

        if (section.contains("lore")) {
            builder.lore(section.getStringList("lore"));
        }

        return builder.build();
    }

    public static ItemStack fromConfig(ConfigurationSection section) {
        if (section == null) return new ItemStack(Material.AIR);

        Material material = Material.matchMaterial(section.getString("material", "STONE"));
        if (material == null) material = Material.BARRIER;

        ItemBuilder builder = new ItemBuilder(material);

        if (section.contains("display-name")) {
            builder.name(section.getString("display-name"));
        }

        if (section.contains("lore")) {
            builder.lore(section.getStringList("lore"));
        }

        if (section.contains("amount")) {
            builder.amount(section.getInt("amount"));
        }

        return builder.build();
    }

}
