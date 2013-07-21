package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SlapCommand implements CommandExecutor{
	
	public FileConfiguration config;
	private final RageQuit plugin;

	public SlapCommand(RageQuit plugin) {
		this.plugin = plugin;
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			config = plugin.getConfig();
			if (args.length == 1 ){
				if (sender instanceof Player) {
					if (sender.hasPermission("darkcommand.slap")){
						if (commandLabel.equalsIgnoreCase("slap")){
							Player player = (Player) sender;
							Player target = (Bukkit.getServer().getPlayer(args[0]));	
							if (target != null){
								Bukkit.getServer().broadcastMessage(ChatColor.RED + player.getName() + " has slapped " + args[0] + "!");
								if(!(config.getBoolean("logcommands") == false)){
									int current = config.getInt("Times.Done.Slapped");
									int newint = current + 1;
									config.set("Times.Done.Slapped", newint);
									plugin.saveConfig();
								}
						}else{
							sender.sendMessage("This player either doesn't exist or isn't online!");
						}
					}
				}else{
					sender.sendMessage("You don't have permission to use this command!");
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /slap <Player_Name>");
		}
			return true;
	}
}