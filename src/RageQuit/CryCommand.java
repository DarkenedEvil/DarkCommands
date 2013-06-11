package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CryCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 0){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("darkcommand.cry")){
					if (commandLabel.equalsIgnoreCase("cry")) {
						Bukkit.getServer().broadcastMessage(ChatColor.BLUE + player.getName() + " is crying! :'(");
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