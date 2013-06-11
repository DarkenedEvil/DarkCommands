package RageQuit;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

public final class RageQuit extends JavaPlugin {


		public void onEnable(){
			
				this.getCommand("RageQuit").setExecutor(new RageQuitCommand());
				this.getCommand("rq").setExecutor(new RageQuitCommand());
				this.getCommand("hug").setExecutor(new HugCommand());
				this.getCommand("kiss").setExecutor(new KissCommand());
				this.getCommand("bitchslap").setExecutor(new BitchSlap());
				this.getCommand("cry").setExecutor(new CryCommand());
				this.getCommand("slap").setExecutor(new SlapCommand());
				this.getCommand("chillpill").setExecutor(new ChillPillCommand());
				this.getCommand("ctp").setExecutor(new CoolTP());
				
				boolean stats = true;
				
				if (stats){
					try {
					    Metrics metrics = new Metrics(this);
					    metrics.start();
					} catch (IOException e) {
					}
				}
				
				getLogger().info("V 1.5 enabled!");
		}
		
		public void onDisable(){
				getLogger().info("V 1.5 disabled!");
		}
		
	}
