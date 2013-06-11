package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BitchSlap implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 1 ){
			if (sender instanceof Player) {
				if (sender.hasPermission("darkcommand.bitchslap")){
					if (commandLabel.equalsIgnoreCase("bitchslap")){
						Player player = (Player) sender;
						Player target = (Bukkit.getServer().getPlayer(args[0]));
							if (target != null){
								Bukkit.getServer().broadcastMessage(ChatColor.GOLD + player.getName() + " has bitchslapped " + args[0] + "!");
								int health = Bukkit.getServer().getPlayer(args[0]).getMaxHealth();
								int newhealth = health / 2;
								Bukkit.getServer().getPlayer(args[0]).setHealth(newhealth);
								return true;
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