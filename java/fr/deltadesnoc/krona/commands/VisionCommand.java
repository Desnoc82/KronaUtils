package fr.deltadesnoc.krona.commands;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VisionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("kronavision")){
            if(sender.hasPermission("krona.vision.use")) {
                if (args.length == 0) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 1));
                            sender.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.activate").replace("&", "§"));
                        }
                        else{
                            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            sender.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.desactivate").replace("&", "§"));
                        }
                        return true;
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(sender instanceof Player) {
                        if (!target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 1));
                            target.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.activate").replace("&", "§"));
                            sender.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.activate").replace("&", "§"));
                        } else {
                            target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            target.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.desactivate").replace("&", "§"));
                            sender.sendMessage(Kronalia.getInstance().getConfig().getString("vision.effect.desactivate").replace("&", "§"));
                        }
                    }
                }
                return true;
            }else {
                sender.sendMessage(Kronalia.getInstance().getConfig().getString("vision.permission").replace("&", "§"));
                return false;
            }
        }
        return false;
    }
}
