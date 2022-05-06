package fr.deltadesnoc.krona.commands;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;

public class CapsLimitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("kronacaps")){
            if(sender.hasPermission("kronamanager.caps.bypass.command")){
                if(args.length == 0){
                    sender.sendMessage("§8[Krona§6Caps] §7La limite de majuscules par message est de : §a" + Kronalia.getInstance().getConfig().getInt("authorized-caps"));
                    return true;
                }else if(args.length == 1){
                    if(args[0].matches("-?\\d+")){
                        int nbHopper = Integer.parseInt(args[0]);
                        Kronalia.getInstance().getConfig().set("authorized-caps", nbHopper);
                        try {
                            Kronalia.getInstance().getConfig().save(new File(Kronalia.getInstance().getDataFolder(), "config.yml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        sender.sendMessage("§8[Krona§6Caps]  §7Nombre de majuscules par message change avec §asucces §7!");
                        return true;
                    }else{
                        sender.sendMessage("§8[Krona§6Caps] §cVeuillez entrer un nombre comme argument !");
                        return false;
                    }
                }
            }else {
                sender.sendMessage(Kronalia.getInstance().getConfig().getString("caps.permission").replace("&", "§"));
                return false;
            }
        }
        return false;
    }
}
