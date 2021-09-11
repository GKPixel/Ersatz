package com.pikachu.papiaddon.placeholderapi;

import com.pikachu.papiaddon.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPIListener extends PlaceholderExpansion {
    private final String prefix;

    public PlaceholderAPIListener(Main plugin, String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        PlaceholderAPIEvent event = new PlaceholderAPIEvent(identifier, player, prefix);
        Bukkit.getServer().getPluginManager().callEvent(event);
        return event.getResult();
    }

    @Override
    public @NotNull String getIdentifier() {
        return prefix;
    }

    @Override
    public @NotNull String getAuthor() {
        return "RobotHanzo";
    }

    @Override
    public @NotNull String getVersion() {
        return "1";
    }
}
