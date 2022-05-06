package fr.deltadesnoc.krona;

import fr.deltadesnoc.krona.commands.*;
import fr.deltadesnoc.krona.events.*;
import fr.deltadesnoc.krona.tabcompleter.VoidCompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kronalia extends JavaPlugin {

    private static Kronalia instance;
    private Map<Player, Integer> chatCooldown;
    private Map<Player, Integer> rtpCooldown;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    @Override
    public void onLoad() {
        instance = this;
        chatCooldown = new HashMap<>();
    }
    public void registerCommands(){
        registerCommand("kronavision", new VisionCommand());
        registerCommand("kronareload", new ReloadCommand());
        registerCommand("kronavoid", new VoidCommand());
        registerTabCompletor("kronavoid", new VoidCompleter());
        registerCommand("kronahopper", new HopperLimitCommand());
        registerCommand("kronacaps", new CapsLimitCommand());
        registerCommand("kronapotion", new PotionCommand());
    }

    public void registerCommand(String name, CommandExecutor executor){
        getCommand(name).setExecutor(executor);
    }

    public void registerTabCompletor(String name, TabCompleter completer){
        getCommand(name).setTabCompleter(completer);
    }

    public void registerEvents(){
        registerEvent(new VoidEvent());
        registerEvent(new SpamChatEvent());
        registerEvent(new CapsChatEvent());
        registerEvent(new HopperPlaceEvent());
        registerEvent(new KillEvent());
    }

    public void registerEvent(Listener listener){
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static Kronalia getInstance() {
        return instance;
    }

    public Map<Player, Integer> getChatCooldown() {
        return chatCooldown;
    }

    public int getPlayerChatCooldown(Player player){
        return getChatCooldown().get(player);
    }

    public void addPlayerChatCooldown(Player player, int cooldown){
        getChatCooldown().put(player, cooldown);
    }

    public void removePlayerChatCooldown(Player player){
        getChatCooldown().remove(player);
    }

    public boolean hasChatCooldown(Player player){
        return getChatCooldown().containsKey(player);
    }

    public Map<Player, Integer> getRTPCooldown() {
        return rtpCooldown;
    }

    public int getPlayerRTPCooldown(Player player){
        return getRTPCooldown().get(player);
    }

    public void addPlayerRTPCooldown(Player player, int cooldown){
        getRTPCooldown().put(player, cooldown);
    }

    public void removePlayerRTPCooldown(Player player){
        getRTPCooldown().remove(player);
    }

    public boolean hasRTPCooldown(Player player){
        return getRTPCooldown().containsKey(player);
    }
}
