package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;

public class BitchSlap implements CommandExecutor{
	
	public FileConfiguration config;
	private final RageQuit plugin;
	
	public BitchSlap(RageQuit plugin)    {
        this.plugin = plugin;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		config = plugin.getConfig();
		if (args.length == 1 ){
			if (sender instanceof Player) {
				if (sender.hasPermission("darkcommand.bitchslap")){
					if (commandLabel.equalsIgnoreCase("bitchslap")){
						Player player = (Player) sender;
						Player target = (Bukkit.getServer().getPlayer(args[0]));
							if (target != null){
								config = plugin.getConfig();
								Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " has bitchslapped " + args[0] + "!");
								Damageable dm = Bukkit.getServer().getPlayer(args[0]);
								double health = dm.getMaxHealth();
								double newhealth = health / 2;
								Bukkit.getServer().getPlayer(args[0]).setHealth(newhealth);
								if(!(config.getBoolean("logcommands") == false)){
									int current = config.getInt("Times.Done.BitchSlapped");
									int newint = current + 1;
									config.set("Times.Done.BitchSlapped", newint);
									plugin.saveConfig();
								}
						}else{
							sender.sendMessage("This person doesn't exist or isn't online!");
						}
					}
				}else{
					sender.sendMessage("You don't have permission for this command!");
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /bitchslap <Player_Name>");
		}
		return true;
	}
}