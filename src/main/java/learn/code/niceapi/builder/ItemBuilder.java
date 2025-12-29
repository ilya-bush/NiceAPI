package learn.code.niceapi.builder;

import learn.code.niceapi.NiceAPI;
import learn.code.niceapi.utils.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class ItemBuilder {

    private static NiceAPI plugin;

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder name(String text) {
        if (text != null) {
            meta.displayName(Color.parse(text).decoration(TextDecoration.ITALIC, false));
        }
        return this;
    }

    public ItemBuilder lore(List<String> lines) {
        if (lines != null && !lines.isEmpty()) {
            List<Component> lore = lines.stream()
                    .map(line -> Color.parse(line).decoration(TextDecoration.ITALIC, false))
                    .collect(Collectors.toList());
            meta.lore(lore);
        }
        return this;
    }

    public ItemBuilder hideAttributes(boolean hide) {
        if (hide) meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }

    public ItemBuilder glowing(boolean glowing) {
        if (glowing) {

            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        }

        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack fromConfig(ConfigurationSection section) {

        Material mat = Material.matchMaterial(section.getString("material", "STONE"));
        if (mat == null) mat = Material.BARRIER;

        ItemBuilder builder = new ItemBuilder(mat)
                .name(section.getString("display-name"))
                .lore(section.getStringList("lore"))
                .hideAttributes(section.getBoolean("hide-attributes", false));


        return builder.build();

    }
}
