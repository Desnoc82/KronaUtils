package fr.deltadesnoc.krona.events;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Arrays;

public class HopperPlaceEvent implements Listener {

    @EventHandler
    public void onPlaceHopper(BlockPlaceEvent e){
        Player player = e.getPlayer();
        Block block = e.getBlock();
        if(!player.hasPermission("kronahopper.bypass")){
            if(block.getType().equals(Material.HOPPER)) {
                int nbHopper = (int) Arrays.stream(block.getChunk().getTileEntities()).filter(tileEntity -> tileEntity.getType().equals(Material.HOPPER)).count();
                if(nbHopper == Kronalia.getInstance().getConfig().getInt("hopper-limit")+1){
                    e.setCancelled(true);
                    player.sendMessage(Kronalia.getInstance().getConfig().getString("hoppers.place-hopper-limit").replace("&","§").replace("%nbHoppers%", String.valueOf(Kronalia.getInstance().getConfig().getInt("hopper-limit"))));
                }
            }
        }

    }

}
