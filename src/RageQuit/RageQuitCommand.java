package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class RageQuitCommand implements CommandExecutor {
	
	public FileConfiguration config;
	private final RageQuit plugin;
	
	public RageQuitCommand(RageQuit plugin)    {
        this.plugin = plugin;
    }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		config = plugin.getConfig();
		if (args.length == 0){
			if (sender instanceof Player) {
				if (sender.hasPermission("darkcommand.ragequit")){
					Player player = (Player) sender;
					if (commandLabel.equalsIgnoreCase("ragequit")) {
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + " has ragequit!");
						player.kickPlayer("You have ragequit!");
						if(!(config.getBoolean("logcommands") == false)){
							int current = config.getInt("Times.Done.RageQuit");
							int newint = current + 1;
							config.set("Times.Done.RageQuit", newint);
							plugin.saveConfig();
						}
						return true;
					} 
					else if (commandLabel.equalsIgnoreCase("rq")) {
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + " has ragequit!");
						player.kickPlayer("You have ragequit!");
						if(!(config.getBoolean("logcommands") == false)){
							int current = config.getInt("Times.Done.RageQuit");
							int newint = current + 1;
							config.set("Times.Done.RageQuit", newint);
							plugin.saveConfig();
						}
						return true;
					} 
				}else{
					sender.sendMessage("You don't have permission for this command!");
				}
			}else{
				sender.sendMessage("You must be player!");
			}
		}else{
			sender.sendMessage("Usage: /ragequit or /rq");
		}
		return true;
	}
}	