package fr.deltadesnoc.krona.events;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SpamChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();

        if(!player.hasPermission("kronamanager.spam.bypass")){
            if(!Kronalia.getInstance().hasChatCooldown(player)){
                Kronalia.getInstance().addPlayerChatCooldown(player, (int) System.currentTimeMillis());
            }else{
                int time = (int) System.currentTimeMillis();
                int remainingCooldown = (time - Kronalia.getInstance().getPlayerChatCooldown(player)) / 1000;
                int cooldown = Kronalia.getInstance().getConfig().getInt("cooldown");
                if(remainingCooldown >= cooldown){
                    e.setCancelled(false);
                    Kronalia.getInstance().removePlayerChatCooldown(player);
                    Kronalia.getInstance().addPlayerChatCooldown(player, (int) System.currentTimeMillis());
                }
                else{
                    e.setCancelled(true);
                    player.sendMessage(Kronalia.getInstance().getConfig().getString("spam").replace("&", "§").replace("%time%", String.valueOf(cooldown - remainingCooldown)));
                }
            }
        }

    }

}
