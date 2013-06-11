package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RageQuitCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 0){
			if (sender instanceof Player) {
				if (sender.hasPermission("darkcommand.ragequit")){
					Player player = (Player) sender;
					if (commandLabel.equalsIgnoreCase("ragequit")) {
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + " has ragequit!");
						player.kickPlayer("You have ragequit!");
						return true;
					} 
					else if (commandLabel.equalsIgnoreCase("rq")) {
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + " has ragequit!");
						player.kickPlayer("You have ragequit!");
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