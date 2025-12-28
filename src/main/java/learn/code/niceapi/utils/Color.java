package learn.code.niceapi.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import org.jetbrains.annotations.NotNull;

public class Color {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    public static @NotNull Component parse(@NotNull String message) {

        return MINI_MESSAGE.deserialize(message);

    }
}
