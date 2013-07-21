package RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import RageQuit.RageQuit;

public class CoolTP implements CommandExecutor{
	
	public FileConfiguration config;
	private final RageQuit plugin;

	public CoolTP(RageQuit plugin) {
		this.plugin = plugin;
		}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		config = plugin.getConfig();
		if (args.length == 1){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (commandLabel.equalsIgnoreCase("ctp")) {
					if (sender.hasPermission("darkcommand.cooltp")){
						Player target = (Bukkit.getServer().getPlayer(args[0]));
						if (!(target == null)){
							player.teleport(target);
							player.getWorld().playEffect(player.getLocation(), Effect.POTION_BREAK, 5000);
							player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 50000);
							player.getWorld().playEffect(player.getLocation(), Effect.ZOMBIE_CHEW_WOODEN_DOOR, 2000);
							if(!(config.getBoolean("logcommands") == false)){
								int current = config.getInt("Times.Done.CTP");
								int newint = current + 1;
								config.set("Times.Done.CTP", newint);
								plugin.saveConfig();
							}
						}else{
							sender.sendMessage("This player isn't online or doesnt exist!");
						}
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