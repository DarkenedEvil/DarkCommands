package RageQuit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ChillPillCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 0){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (commandLabel.equalsIgnoreCase("chillpill")) {
					if (sender.hasPermission("darkcommand.chillpill")){
						sender.sendMessage("You take pill out of your inventory and take it.");
						player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 1));
						player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 300, 1));
						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 1));
						sender.sendMessage("ChillPill side affects are kicking in!");
					}else{
						sender.sendMessage("You don't have permission for this command");
					}
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /chillpill ");
		}
		return true;
	}
}	