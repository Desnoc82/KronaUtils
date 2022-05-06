package fr.deltadesnoc.krona.commands;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        File fileWorld = new File(Kronalia.getInstance().getDataFolder(), "void/worldlist.yml");
        FileConfiguration configurationWorld = YamlConfiguration.loadConfiguration(fileWorld);
        File fileVoid = new File(Kronalia.getInstance().getDataFolder(), "void/void.yml");
        FileConfiguration configurationVoid = YamlConfiguration.loadConfiguration(fileVoid);

        if(label.equalsIgnoreCase("kronareload")){
            if(sender.hasPermission("krona.reload")){
                if(args.length == 0){
                    Kronalia.getInstance().reloadConfig();
                    try {
                        configurationWorld.save(fileWorld);
                        configurationVoid.save(fileVoid);
                        Kronalia.getInstance().getConfig().save(new File(Kronalia.getInstance().getDataFolder(), "config.yml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sender.sendMessage(Kronalia.getInstance().getConfig().getString("reload.success").replace("&", "§"));
                    return true;
                }else {
                    sender.sendMessage("§cUsage : /kronareload");
                    return false;
                }
            }else {
                sender.sendMessage(Kronalia.getInstance().getConfig().getString("reload.permission").replace("&", "§"));
                return false;
            }
        }
        return false;
    }
}
