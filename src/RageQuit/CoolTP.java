package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoolTP implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 1){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (commandLabel.equalsIgnoreCase("ctp")) {
					if (sender.hasPermission("darkcommand.cooltp")){
						Player target = (Bukkit.getServer().getPlayer(args[0]));
						player.teleport(target);
						player.getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 5000);
						player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 50000);
						player.getWorld().playEffect(player.getLocation(), Effect.ZOMBIE_CHEW_WOODEN_DOOR, 2000);
					}else{
						sender.sendMessage("You don't have permission for this command!");
					}
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /ctp <Player_Name>");
		}
		return true;
	}
}