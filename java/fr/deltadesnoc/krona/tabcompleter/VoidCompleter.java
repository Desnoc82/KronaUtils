package fr.deltadesnoc.krona.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VoidCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if(args.length == 1){

            if(sender.hasPermission("void.setspawn")) commands.add("setSpawn");
            if(sender.hasPermission("void.list")) commands.add("list");
            if(sender.hasPermission("void.toggle")) commands.add("toggle");

            StringUtil.copyPartialMatches(args[0], commands, completions);

        }

        Collections.sort(completions);
        return completions;
    }
}
