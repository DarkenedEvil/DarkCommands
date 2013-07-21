package RageQuit;

import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import RageQuit.Metrics.Graph;

public final class RageQuit extends JavaPlugin {
	
	public FileConfiguration config;
	
	public void loadConfig(){
		if(! (getDataFolder().exists())){
	    getDataFolder().mkdir();	    
		config = getConfig();
		config.options().header("Commands Done. Dont Edit ANYTHING except 'logcommands'." +
		" Set that to false if you don't want me to upload commands done to make the plugin better:(");
	    config.set("Times.Done.Cried", 0);
	    config.set("Times.Done.RageQuit", 0);
	    config.set("Times.Done.Hug", 0);
	    config.set("Times.Done.Kiss", 0);
	    config.set("Times.Done.CTP", 0);
	    config.set("Times.Done.Slapped", 0);
	    config.set("Times.Done.Chilled", 0);
	    config.set("Times.Done.BitchSlapped", 0);
	    config.set("logcommands", false);
	    saveConfig();
	    getLogger().info("Config Created");
	    }else{
	    	getLogger().info("Config Exists! Not creating one.");
	    }
	}
		public void onEnable(){
			
				loadConfig();
			
				this.getCommand("RageQuit").setExecutor(new RageQuitCommand(this));
				this.getCommand("rq").setExecutor(new RageQuitCommand(this));
				this.getCommand("hug").setExecutor(new HugCommand(this));
				this.getCommand("kiss").setExecutor(new KissCommand(this));
				this.getCommand("bitchslap").setExecutor(new BitchSlap(this));
				this.getCommand("cry").setExecutor(new CryCommand(this));
				this.getCommand("slap").setExecutor(new SlapCommand(this));
				this.getCommand("chillpill").setExecutor(new ChillPillCommand(this));
				this.getCommand("ctp").setExecutor(new CoolTP(this));
				
				boolean stats = true;
								
				if (stats){
					try {
					    Metrics metrics = new Metrics(this);
					    Graph graph = metrics.createGraph("Commands Done");
					    
						final int cried = getConfig().getInt("Times.Done.Cried");
					    final int ragequit = getConfig().getInt("Times.Done.Ragequit");
					    final int kiss = getConfig().getInt("Times.Done.Kiss");
					    final int hug = getConfig().getInt("Times.Done.Hug");
					    final int ctp = getConfig().getInt("Times.Done.CTP");
					    final int slap = getConfig().getInt("Times.Done.Slapped");
					    final int chilled = getConfig().getInt("Times.Done.Chilled");
					    final int bitched = getConfig().getInt("Times.Done.BitchSlapped");
						
					    graph.addPlotter(new Metrics.Plotter("Times people have cried"){
					    	 @Override
					    	 public int getValue() {
					    		 return cried;
					    	 }
					    });
					    
					    graph.addPlotter(new Metrics.Plotter("Times people have ragequit"){
					    	@Override
					    	public int getValue(){
					    	return ragequit;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have been bitchslapped"){
					    	@Override
					    	public int getValue(){
					    	return bitched;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have CTP"){
					    	@Override
					    	public int getValue(){
					    	return ctp;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have kissed"){
					    	@Override
					    	public int getValue(){
					    	return kiss;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have hugged"){
					    	@Override
					    	public int getValue(){
					    	return hug;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have been slapped"){
					    	@Override
					    	public int getValue(){
					    	return slap;
					    }
					});
					    graph.addPlotter(new Metrics.Plotter("Times people have chilled"){
					    	@Override
					    	public int getValue(){
					    	return chilled;
					    }
					});
					    metrics.start();
					} catch (IOException e) {
					}
				}
				getLogger().info("V 1.5.1 enabled!");
		}
		

		public void onDisable(){
				getLogger().info("V 1.5.1 disabled!");
				saveConfig();
		}
		
		public void onReload(){
				getLogger().info("Reloaded!");
				saveConfig();
		}
		
	}
