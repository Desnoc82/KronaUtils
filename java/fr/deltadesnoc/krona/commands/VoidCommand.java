package fr.deltadesnoc.krona.commands;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class VoidCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("kronavoid")){

            if(args.length == 1){

                if(args[0].equalsIgnoreCase("setSpawn")){
                    if(!(sender instanceof Player)) {
                        sender.sendMessage("\u001B[31m" + "Seul un joueur peut effectuer cette commande !");
                        return false;
                    }
                    Player player = (Player) sender;

                    if(player.hasPermission("void.setspawn")){
                        Location loc = player.getLocation();

                        File file = new File(Kronalia.getInstance().getDataFolder(), "void/void.yml");
                        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

                        configuration.set("spawn.x", loc.getX());
                        configuration.set("spawn.y", loc.getY());
                        configuration.set("spawn.z", loc.getZ());
                        configuration.set("spawn.world", loc.getWorld().getName());

                        try {
                            configuration.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        player.sendMessage(Kronalia.getInstance().getConfig().getString("void.spawn").replace("&", "§"));
                        return true;
                    }
                    else{
                        player.sendMessage(Kronalia.getInstance().getConfig().getString("void.permission").replace("&","§"));
                        return false;
                    }
                }
                else if(args[0].equalsIgnoreCase("list")){
                    if(sender.hasPermission("void.list")){

                        File file = new File(Kronalia.getInstance().getDataFolder(), "void/worldlist.yml");
                        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

                        ConfigurationSection worldSection = configuration.getConfigurationSection("worlds");

                        Set<String> worldList = worldSection.getKeys(false);

                        sender.sendMessage(" ");
                        sender.sendMessage(" §8[Krona§6Void] §b- listes :");
                        sender.sendMessage(" ");

                        for(String world : worldList){

                            if(configuration.getString("worlds." + world).equalsIgnoreCase("true")){
                                sender.sendMessage("  §f- §7Monde §7" + world + " §6: §aActiver.");
                            }else if(configuration.getString("worlds." + world).equalsIgnoreCase("false")){
                                sender.sendMessage("  §f- §7Monde §7" + world + " §6: §cDesactiver.");
                            }

                        }
                        sender.sendMessage(" ");

                        return true;
                    }else{
                        sender.sendMessage(Kronalia.getInstance().getConfig().getString("void.permission").replace("&","§"));
                        return false;
                    }
                }
                else if(args[0].equalsIgnoreCase("toggle")){

                    if(!(sender instanceof Player)) {
                        sender.sendMessage("\u001B[31m" + "Seul un joueur peut effectuer cette commande !");
                        return false;
                    }
                    Player player = (Player) sender;

                    if(sender.hasPermission("void.toggle")){

                        Location loc = player.getLocation();

                        File file = new File(Kronalia.getInstance().getDataFolder(), "void/worldlist.yml");
                        FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

                        if(configuration.getString("worlds." + loc.getWorld().getName()) != null){
                            String name = configuration.getString("worlds." + loc.getWorld().getName());
                            if (name.equalsIgnoreCase("true")) {
                                configuration.set("worlds." + loc.getWorld().getName(), "false");
                                player.sendMessage(Kronalia.getInstance().getConfig().getString("void.toggle.inactive").replace("&","§"));
                            } else if(name.equalsIgnoreCase("false")){
                                configuration.set("worlds." + loc.getWorld().getName(), "true");
                                player.sendMessage(Kronalia.getInstance().getConfig().getString("void.toggle.active").replace("&","§"));
                            }
                        }else{
                            player.sendMessage(Kronalia.getInstance().getConfig().getString("void.toggle.unknow").replace("&","§"));
                            configuration.set("worlds." + loc.getWorld().getName(), "false");
                        }

                        try {
                            configuration.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }else{
                        sender.sendMessage(Kronalia.getInstance().getConfig().getString("void.permission").replace("&","§"));
                        return false;
                    }
                }

            } else{


                return false;
            }

        }

        return false;
    }
}
