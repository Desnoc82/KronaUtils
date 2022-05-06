package fr.deltadesnoc.krona.commands;

import fr.deltadesnoc.krona.Kronalia;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PotionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("kronapotion") && sender instanceof Player){


            Player player = (Player) sender;

            if(args.length > 0){
                player.sendMessage(Kronalia.getInstance().getConfig().getString("potions.stack.args").replace("&", "§"));
                return false;
            }

            if(!checkInv(player)){
                player.sendMessage(Kronalia.getInstance().getConfig().getString("potions.stack.no-potion").replace("&", "§"));
                return false;
            }else{
                //Regen
                stackPotion(player, 8193, Kronalia.getInstance().getConfig().getBoolean("regeneration.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.normal.level1.number"));
                stackPotion(player, 8225, Kronalia.getInstance().getConfig().getBoolean("regeneration.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.normal.level2.number"));
                stackPotion(player, 8257, Kronalia.getInstance().getConfig().getBoolean("regeneration.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.normal.long.number"));
                stackPotion(player, 16385, Kronalia.getInstance().getConfig().getBoolean("regeneration.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.splash.level1.number"));
                stackPotion(player, 16417, Kronalia.getInstance().getConfig().getBoolean("regeneration.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.splash.level2.number"));
                stackPotion(player, 16449, Kronalia.getInstance().getConfig().getBoolean("regeneration.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("regeneration.splash.long.number"));
                //speed
                stackPotion(player, 8194, Kronalia.getInstance().getConfig().getBoolean("speed.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("speed.normal.level1.number"));
                stackPotion(player, 8226, Kronalia.getInstance().getConfig().getBoolean("speed.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("speed.normal.level2.number"));
                stackPotion(player, 8258, Kronalia.getInstance().getConfig().getBoolean("speed.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("speed.normal.long.number"));
                stackPotion(player, 16386, Kronalia.getInstance().getConfig().getBoolean("speed.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("speed.splash.level1.number"));
                stackPotion(player, 16418, Kronalia.getInstance().getConfig().getBoolean("speed.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("speed.splash.level2.number"));
                stackPotion(player, 16450, Kronalia.getInstance().getConfig().getBoolean("speed.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("speed.splash.long.number"));
                //fire_resistance
                stackPotion(player, 8195, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.normal.level1.number"));
                stackPotion(player, 8227, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.normal.level2.number"));
                stackPotion(player, 8259, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.normal.long.number"));
                stackPotion(player, 16387, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.splash.level1.number"));
                stackPotion(player, 16419, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.splash.level2.number"));
                stackPotion(player, 16451, Kronalia.getInstance().getConfig().getBoolean("fire_resistance.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("fire_resistance.splash.long.number"));
                //poison
                stackPotion(player, 8196, Kronalia.getInstance().getConfig().getBoolean("poison.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("poison.normal.level1.number"));
                stackPotion(player, 8228, Kronalia.getInstance().getConfig().getBoolean("poison.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("poison.normal.level2.number"));
                stackPotion(player, 8260, Kronalia.getInstance().getConfig().getBoolean("poison.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("poison.normal.long.number"));
                stackPotion(player, 16388, Kronalia.getInstance().getConfig().getBoolean("poison.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("poison.splash.level1.number"));
                stackPotion(player, 16420, Kronalia.getInstance().getConfig().getBoolean("poison.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("poison.splash.level2.number"));
                stackPotion(player, 16452, Kronalia.getInstance().getConfig().getBoolean("poison.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("poison.splash.long.number"));
                //heal
                stackPotion(player, 8197, Kronalia.getInstance().getConfig().getBoolean("heal.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("heal.normal.level1.number"));
                stackPotion(player, 8229, Kronalia.getInstance().getConfig().getBoolean("heal.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("heal.normal.level2.number"));
                stackPotion(player, 8261, Kronalia.getInstance().getConfig().getBoolean("heal.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("heal.normal.long.number"));
                stackPotion(player, 16389, Kronalia.getInstance().getConfig().getBoolean("heal.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("heal.splash.level1.number"));
                stackPotion(player, 16421, Kronalia.getInstance().getConfig().getBoolean("heal.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("heal.splash.level2.number"));
                stackPotion(player, 16453, Kronalia.getInstance().getConfig().getBoolean("heal.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("heal.splash.long.number"));
                //night_vision
                stackPotion(player, 8198, Kronalia.getInstance().getConfig().getBoolean("night_vision.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.normal.level1.number"));
                stackPotion(player, 8230, Kronalia.getInstance().getConfig().getBoolean("night_vision.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.normal.level2.number"));
                stackPotion(player, 8262, Kronalia.getInstance().getConfig().getBoolean("night_vision.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.normal.long.number"));
                stackPotion(player, 16390, Kronalia.getInstance().getConfig().getBoolean("night_visioneal.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.splash.level1.number"));
                stackPotion(player, 16422, Kronalia.getInstance().getConfig().getBoolean("night_vision.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.splash.level2.number"));
                stackPotion(player, 16454, Kronalia.getInstance().getConfig().getBoolean("night_vision.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("night_vision.splash.long.number"));
                //weakness
                stackPotion(player, 8200, Kronalia.getInstance().getConfig().getBoolean("weakness.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("weakness.normal.level1.number"));
                stackPotion(player, 8232, Kronalia.getInstance().getConfig().getBoolean("weakness.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("weakness.normal.level2.number"));
                stackPotion(player, 8264, Kronalia.getInstance().getConfig().getBoolean("weakness.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("weakness.normal.long.number"));
                stackPotion(player, 16392, Kronalia.getInstance().getConfig().getBoolean("weakness.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("weakness.splash.level1.number"));
                stackPotion(player, 16424, Kronalia.getInstance().getConfig().getBoolean("weakness.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("weakness.splash.level2.number"));
                stackPotion(player, 16456, Kronalia.getInstance().getConfig().getBoolean("weakness.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("weakness.splash.long.number"));
                //strength
                stackPotion(player, 8201, Kronalia.getInstance().getConfig().getBoolean("strength.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("strength.normal.level1.number"));
                stackPotion(player, 8233, Kronalia.getInstance().getConfig().getBoolean("strength.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("strength.normal.level2.number"));
                stackPotion(player, 8265, Kronalia.getInstance().getConfig().getBoolean("strength.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("strength.normal.long.number"));
                stackPotion(player, 16393, Kronalia.getInstance().getConfig().getBoolean("strength.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("strength.splash.level1.number"));
                stackPotion(player, 16425, Kronalia.getInstance().getConfig().getBoolean("strength.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("strength.splash.level2.number"));
                stackPotion(player, 16457, Kronalia.getInstance().getConfig().getBoolean("strength.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("strength.splash.long.number"));
                //slowness
                stackPotion(player, 8202, Kronalia.getInstance().getConfig().getBoolean("slowness.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("slowness.normal.level1.number"));
                stackPotion(player, 8234, Kronalia.getInstance().getConfig().getBoolean("slowness.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("slowness.normal.level2.number"));
                stackPotion(player, 8266, Kronalia.getInstance().getConfig().getBoolean("slowness.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("slowness.normal.long.number"));
                stackPotion(player, 16394, Kronalia.getInstance().getConfig().getBoolean("slowness.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("slowness.splash.level1.number"));
                stackPotion(player, 16426, Kronalia.getInstance().getConfig().getBoolean("slowness.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("slowness.splash.level2.number"));
                stackPotion(player, 16458, Kronalia.getInstance().getConfig().getBoolean("slowness.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("slowness.splash.long.number"));
                //jump_boost
                stackPotion(player, 8203, Kronalia.getInstance().getConfig().getBoolean("jump_boost.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.normal.level1"));
                stackPotion(player, 8235, Kronalia.getInstance().getConfig().getBoolean("jump_boost.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.normal.level2"));
                stackPotion(player, 8267, Kronalia.getInstance().getConfig().getBoolean("jump_boost.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.normal.long"));
                stackPotion(player, 16395, Kronalia.getInstance().getConfig().getBoolean("jump_boost.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.splash.level1"));
                stackPotion(player, 16427, Kronalia.getInstance().getConfig().getBoolean("jump_boost.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.splash.level2"));
                stackPotion(player, 16459, Kronalia.getInstance().getConfig().getBoolean("jump_boost.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("jump_boost.splash.long"));
                //damage
                stackPotion(player, 8204, Kronalia.getInstance().getConfig().getBoolean("damage.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("damage.normal.level1.number"));
                stackPotion(player, 8236, Kronalia.getInstance().getConfig().getBoolean("damage.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("damage.normal.level2.number"));
                stackPotion(player, 8268, Kronalia.getInstance().getConfig().getBoolean("damage.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("damage.normal.long.number"));
                stackPotion(player, 16396, Kronalia.getInstance().getConfig().getBoolean("damage.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("damage.splash.level1.number"));
                stackPotion(player, 16428, Kronalia.getInstance().getConfig().getBoolean("damage.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("damage.splash.level2.number"));
                stackPotion(player, 16460, Kronalia.getInstance().getConfig().getBoolean("damage.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("damage.splash.long.number"));
                //water_breath
                stackPotion(player, 8205, Kronalia.getInstance().getConfig().getBoolean("water_breath.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.normal.level1.number"));
                stackPotion(player, 8237, Kronalia.getInstance().getConfig().getBoolean("water_breath.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.normal.level2.number"));
                stackPotion(player, 8269, Kronalia.getInstance().getConfig().getBoolean("water_breath.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.normal.long.number"));
                stackPotion(player, 16397, Kronalia.getInstance().getConfig().getBoolean("water_breath.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.splash.level1.number"));
                stackPotion(player, 16429, Kronalia.getInstance().getConfig().getBoolean("water_breath.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.splash.level2.number"));
                stackPotion(player, 16461, Kronalia.getInstance().getConfig().getBoolean("water_breath.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("water_breath.splash.long.number"));
                //invisibility
                stackPotion(player, 8206, Kronalia.getInstance().getConfig().getBoolean("invisibility.normal.level1.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.normal.level1.number"));
                stackPotion(player, 8238, Kronalia.getInstance().getConfig().getBoolean("invisibility.normal.level2.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.normal.level2.number"));
                stackPotion(player, 8270, Kronalia.getInstance().getConfig().getBoolean("invisibility.normal.long.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.normal.long.number"));
                stackPotion(player, 16398, Kronalia.getInstance().getConfig().getBoolean("invisibility.splash.level1.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.splash.level1.number"));
                stackPotion(player, 16430, Kronalia.getInstance().getConfig().getBoolean("invisibility.splash.level2.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.splash.level2.number"));
                stackPotion(player, 16462, Kronalia.getInstance().getConfig().getBoolean("invisibility.splash.long.bool"), Kronalia.getInstance().getConfig().getInt("invisibility.splash.long.number"));

                player.sendMessage(Kronalia.getInstance().getConfig().getString("potions.stack.succes").replace("&", "§"));
            }
        }

        return false;
    }

    private void stackPotion(Player player, int potionID, boolean potionauthorize, int stackNumber){
        ItemStack[] items = player.getInventory().getContents();
        int has = 0;
        byte b;
        int i;
        ItemStack[] arrayOfItemStack1;
        for (i = (arrayOfItemStack1 = items).length, b = 0; b < i; ) {
            ItemStack item = arrayOfItemStack1[b];
            if (item != null && item.getType() == Material.POTION && item.getAmount() > 0 && item.getDurability() == potionID)
                has += item.getAmount();
            b++;
        }
        if (has > 0) {
            if(potionauthorize){
                while(has > stackNumber){
                    replace(player, stackNumber, potionID);
                    has -= stackNumber;
                }
            }
        }
    }

    public void replace(Player player, int number, int potionID){
        ItemStack[] potion = new ItemStack[] { new ItemStack(Material.POTION, number, (short)potionID) };
        player.getInventory().removeItem(potion);
        player.getInventory().addItem(potion);
    }

    public boolean checkInv(Player player) {

        ItemStack[] items = player.getInventory().getContents();
        int potionCompt = 0;

        for(ItemStack item : items){
            if(item != null && item.getType() == Material.POTION){
                potionCompt++;
            }
        }
        return potionCompt > 0;
    }

}
