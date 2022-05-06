package fr.deltadesnoc.krona.events;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillEvent implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent e){
        Player player = e.getEntity().getPlayer();
        EntityDamageEvent deathCause = player.getLastDamageCause();
        if(deathCause.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            Entity entity = (((EntityDamageByEntityEvent)deathCause).getDamager());
            if(entity instanceof Player) {
                Player killerPlayer = (Player)entity;
                if(killerPlayer.getInventory().getItemInHand().hasItemMeta()){
                    e.setDeathMessage(Kronalia.getInstance().getConfig().getString("kill-meta").replace("&", "§").replace("<killer>",killerPlayer.getName()).replace("<target>", player.getName()).replace("<killerItem>", killerPlayer.getInventory().getItemInHand().getItemMeta().getDisplayName()));
                }else{
                    e.setDeathMessage(Kronalia.getInstance().getConfig().getString("kill").replace("&", "§").replace("<killer>",killerPlayer.getName()).replace("<target>", player.getName()));
                }
            }
        }
    }
}
