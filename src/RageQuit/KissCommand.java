package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KissCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 1 ){
			if (sender instanceof Player) {
				if (sender.hasPermission("darkcommand.kiss")){
					if (commandLabel.equalsIgnoreCase("kiss")){
						Player player = (Player) sender;
						Player target = (Bukkit.getServer().getPlayer(args[0]));
						if (target != null){
							Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + " has given " + args[0] + " a kiss!");
						}else{
							sender.sendMessage("This player either doesn't exist or isn't online!");
						}
					}
				}else{
					sender.sendMessage("You don't have permission for this command!");
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		 }else{
			 sender.sendMessage("Usage: /kiss <Player_Name>");
		 }
		return true;
	}
}