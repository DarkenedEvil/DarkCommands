package RageQuit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ChillPillCommand implements CommandExecutor{

	public FileConfiguration config;
	private final RageQuit plugin;
	
	public ChillPillCommand(RageQuit plugin)    {
        this.plugin = plugin;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		config = plugin.getConfig();
		if (args.length == 0){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (commandLabel.equalsIgnoreCase("chillpill")) {
					if (sender.hasPermission("darkcommand.chillpill")){
						sender.sendMessage(ChatColor.GREEN + "You take pill out of your inventory and take it.");
						player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 1));
						player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 300, 1));
						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 1));
						sender.sendMessage(ChatColor.RED + "ChillPill side affects are kicking in!");
						if(!(config.getBoolean("logcommands") == false)){
							int current = config.getInt("Times.Done.Chilled");
							int newint = current + 1;
							config.set("Times.Done.Chilled", newint);
							plugin.saveConfig();
						}
					}else{
						sender.sendMessage("You don't have permission for this command");
					}
				}
			}else{
				sender.sendMessage("You must be a player to use this command!");
			}
		}else{
			sender.sendMessage("Usage: /chillpill");
		}
		return true;
	}
}	