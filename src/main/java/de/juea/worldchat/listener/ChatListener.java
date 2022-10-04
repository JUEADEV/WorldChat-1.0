package de.juea.worldchat.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void handlePlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        if (event.getMessage().startsWith("@") || event.getMessage().startsWith("@all")) {

            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendMessage("§8[§aWeltweit§8] §7" + player.getDisplayName() + "§8: §f" + event.getMessage()
                        .replace("@all ", "")
                        .replace("@ ", ""));
            }
        } else {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.getWorld().equals(player.getWorld())) {
                    all.sendMessage("§7" + player.getName() + "§8: §f" + event.getMessage());
                }
            }
        }

    }

}
