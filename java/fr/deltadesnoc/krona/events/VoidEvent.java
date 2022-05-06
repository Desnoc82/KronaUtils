package fr.deltadesnoc.krona.events;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;

public class VoidEvent implements Listener {

    @EventHandler
    public void onFall(PlayerMoveEvent e){

        Player player = e.getPlayer();

        if(e.getFrom().getY() >= 0 && e.getTo().getY() < 0){

            player.sendMessage(String.valueOf(e.getTo().getY()));
            Location loc = player.getLocation();

            File file = new File(Kronalia.getInstance().getDataFolder(), "void/worldlist.yml");
            FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

            if(configuration.getString("worlds." + loc.getWorld().getName()).equalsIgnoreCase("true")){
                File fileVoid = new File(Kronalia.getInstance().getDataFolder(), "void/void.yml");
                FileConfiguration configurationVoid = YamlConfiguration.loadConfiguration(fileVoid);

                if(configurationVoid.getString("spawn.world") != null){
                    World world = Bukkit.getWorld(configurationVoid.getString("spawn.world"));
                    int x = configurationVoid.getInt("spawn.x");
                    int y = configurationVoid.getInt("spawn.y");
                    int z = configurationVoid.getInt("spawn.z");

                    Location location = new Location(world, x, y, z);

                    player.setFallDistance(0);
                    player.teleport(location);
                }

            }

        }

    }

}
