package me.gl1tchcraft.bedwars;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.gl1tchcraft.bedwars.commands.BedwarsCommand;
import me.gl1tchcraft.bedwars.events.GameMechanics;
import me.gl1tchcraft.bedwars.gameifno.GameManager;
import me.gl1tchcraft.bedwars.inventory.ClickEvent;
import me.gl1tchcraft.bedwars.playerinfo.PlayerManager;
import me.gl1tchcraft.bedwars.teaminfo.TeamManager;
import me.gl1tchcraft.bedwars.worldmanagement.WorldManager;

public class Main extends JavaPlugin {
	
	public HashMap<UUID, PlayerManager> playerManager = new HashMap<UUID, PlayerManager>();
	public HashMap<UUID, TeamManager> teamManager = new HashMap<UUID, TeamManager>();
	
	public ArrayList<Player> playersInGame = new ArrayList<Player>();
	public ArrayList<Player> playersLeftGame = new ArrayList<Player>();
	
	
	
	public GameMechanics gameMechanics;
	public GameManager gameManager;
	
	@Override
	public void onEnable() {
		copy();
		
		this.getServer().getPluginManager().registerEvents(new GameMechanics(), this);
		this.getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		this.getCommand("bedwars").setExecutor(new BedwarsCommand());
		this.getCommand("global").setExecutor(new BedwarsCommand());
		registerConfig();
		instanceClasses();
	}
	
	@Override
	public void onDisable() {
		delete();
		
	}
	
	public void registerConfig() {
		saveDefaultConfig();
	}
	
	public void instanceClasses() {
		gameMechanics = new GameMechanics();
		gameManager = new GameManager();
	}
	
	public void copy() {
        File dataFolder = new File(this.getDataFolder().getPath());
        String strData = dataFolder.toString();
        String[] split = strData.toString().split(File.pathSeparator);
        String rootFolder = split[split.length];
        File root = new File(rootFolder);
     
        File srcDir = new File(root+File.pathSeparator+"backup");
        if (!srcDir.exists()) {
            Bukkit.getLogger().warning("Backup does not exist!");
            return;
        }
        File destDir = new File(root+File.pathSeparator+"bedwars");
        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Bukkit.getServer().createWorld(new WorldCreator("bedwars"));
        Bukkit.getLogger().warning("-------------------------------------LOADED---------------------------------");
    }
	
	 public void delete() {
	        Bukkit.getServer().unloadWorld("bedwars", true);
	        File dir = new File(Bukkit.getServer().getWorld("bedwars").getWorldFolder().getPath());
	        try {
	        	 FileDeleteStrategy.FORCE.delete(dir);
	        }
	        catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
}
