package io.beailotus.antisleep;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiSleep extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Registering events...");
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("AntiSleep is now running!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("antisleep.bypass")) {
            player.setSleepingIgnored(false);
            return;
        }

        player.setSleepingIgnored(true);
    }
}
