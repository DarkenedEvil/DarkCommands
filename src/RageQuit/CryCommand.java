package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CryCommand implements CommandExecutor{
	
	public FileConfiguration config;
	private final RageQuit plugin;
	
	public CryCommand(RageQuit plugin)    {
        this.plugin = plugin;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		config = plugin.getConfig();
		if (args.length == 0){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("darkcommand.cry")){
					if (commandLabel.equalsIgnoreCase("cry")) {
						Bukkit.getServer().broadcastMessage(ChatColor.BLUE + player.getName() + " is crying! :'(");
						if(!(config.getBoolean("logcommands") == false)){
							int current = config.getInt("Times.Done.Cried");
							int newint = current + 1;
							config.set("Times.Done.Cried", newint);
							plugin.saveConfig();
						}
					}
				}else{
					sender.sendMessage("You don't have permission for this command!");
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /cry");
		}
		return true;
	}
}