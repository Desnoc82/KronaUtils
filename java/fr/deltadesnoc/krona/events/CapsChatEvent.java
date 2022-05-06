package fr.deltadesnoc.krona.events;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CapsChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();

        if(!player.hasPermission("kronamanager.caps.bypass")){
            if(nbr_maj(e.getMessage()) > Kronalia.getInstance().getConfig().getInt("authorized-caps")){
                e.setCancelled(true);
                player.sendMessage(Kronalia.getInstance().getConfig().getString("caps.caps-limit").replace("&", "§"));
            }
        }

    }

    private static int nbr_maj(String chaine) {
        int compteur=0;
        for(int i = 0; i<chaine.length(); i++){
            char ch = chaine.charAt(i);
            if(Character.isUpperCase(ch))
                compteur++;
        }
        return compteur;
    }

}
