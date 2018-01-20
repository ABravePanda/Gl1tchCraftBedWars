package me.gl1tchcraft.bedwars.gameifno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.util.Vector;

import me.gl1tchcraft.bedwars.Main;
import me.gl1tchcraft.bedwars.events.GameMechanics;
import me.gl1tchcraft.bedwars.playerinfo.PlayerScoreboard;
import me.gl1tchcraft.bedwars.teaminfo.TeamManager;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class GameManager implements Listener {

	private Main plugin = Main.getPlugin(Main.class);
	
	private int lobbyCountdown = plugin.getConfig().getInt("LobbyTimer");
	private int emeraldCountdown = plugin.getConfig().getInt("EmeraldTimer");
	private int goldCountdown = plugin.getConfig().getInt("GoldTimer");
	private int ironCountdown = plugin.getConfig().getInt("IronTimer");
	private int diamondCountdown = plugin.getConfig().getInt("DiamondTimer");
	public int playersNeeded = plugin.getConfig().getInt("MinPlayers");
	
	public boolean isStarted;
	
	public static Location lobbySpawn;
	public static Location redSpawn;
	public static Location greenSpawn;
	public static Location yellowSpawn;
	public static Location blueSpawn;
	
	public static TeamManager redTeam = new TeamManager(1, Color.RED, "Red", GameManager.redSpawn, true);
	public static TeamManager blueTeam = new TeamManager(1, Color.BLUE, "Blue", GameManager.blueSpawn, true);
	public static TeamManager greenTeam = new TeamManager(1, Color.GREEN, "Green", GameManager.greenSpawn, true);
	public static TeamManager yellowTeam = new TeamManager(1, Color.YELLOW, "Yellow", GameManager.yellowSpawn, true);
	

	
	private int taskId = -1;
	
	public void setupGame() {
		
		redSpawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("RedSpawn.World")), plugin.getConfig().getDouble("RedSpawn.X"),
				plugin.getConfig().getDouble("RedSpawn.Y"), plugin.getConfig().getDouble("RedSpawn.Z"));
		blueSpawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("BlueSpawn.World")), plugin.getConfig().getDouble("BlueSpawn.X"),
				plugin.getConfig().getDouble("BlueSpawn.Y"), plugin.getConfig().getDouble("BlueSpawn.Z"));
		greenSpawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("GreenSpawn.World")), plugin.getConfig().getDouble("GreenSpawn.X"),
				plugin.getConfig().getDouble("GreenSpawn.Y"), plugin.getConfig().getDouble("GreenSpawn.Z"));
		yellowSpawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("YellowSpawn.World")), plugin.getConfig().getDouble("YellowSpawn.X"),
				plugin.getConfig().getDouble("YellowSpawn.Y"), plugin.getConfig().getDouble("YellowSpawn.Z"));
		lobbySpawn = new Location(Bukkit.getWorld(plugin.getConfig().getString("LobbySpawn.World")), plugin.getConfig().getDouble("LobbySpawn.X"),
				plugin.getConfig().getDouble("LobbySpawn.Y"), plugin.getConfig().getDouble("LobbySpawn.Z"));

	}
	
	public void lobbyWait(Player p) {
		
		int online = Bukkit.getOnlinePlayers().size();
	
		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.GRAY + " has joined the game." + ChatColor.GREEN + "" + ChatColor.BOLD + " (" + online + "/" + playersNeeded + ")");
	
		playerCheck(online);
		
		setupGame();
		
	}
	
	 
	public static void assignTeam(Player p) {
	int average = 1;
	 
	if (redTeam.getRedPlayers().size() < average) {
	redTeam.addRedPlayer(p);
	} else if (blueTeam.getBluePlayers().size() < average) {
	blueTeam.addBluePlayer(p);
	} else if (greenTeam.getGreenPlayers().size() < average) {
	greenTeam.addGreenPlayer(p);
	} else {
	yellowTeam.addYellowPlayer(p);
	}
	}
	
	public void gameStart() {
		
		spawnVillagers();
		System.out.println("Spawning Villagers");
		
		emeraldDrop();
		goldDrop();
		ironDrop();
		diamondDrop();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage("DEBUG: " + GameManager.yellowTeam.getTeam(p));
		}
		
		for(Player p : blueTeam.getBluePlayers()) {
			p.setPlayerListName("§b§lB§b " + p.getName());
			GameMechanics.equipArmor(p, 0, 0, 255);
			p.teleport(blueSpawn);
		}
		for(Player p : redTeam.getRedPlayers()) {
			p.setPlayerListName("§c§lR§c " + p.getName());
			GameMechanics.equipArmor(p, 255, 0, 0);
			p.teleport(redSpawn);
		}
		for(Player p : yellowTeam.getYellowPlayers()) {
			p.setPlayerListName("§e§lY§e " + p.getName());
			GameMechanics.equipArmor(p, 255, 250, 0);
			p.teleport(yellowSpawn);
		}
		for(Player p : greenTeam.getGreenPlayers()) {
			p.setPlayerListName("§a§lG§a " + p.getName());
			GameMechanics.equipArmor(p, 0, 255, 0);
			p.teleport(greenSpawn);
		}
		
			
		}
	
	public void spawnVillagers() {
		
		for(Entity e : Bukkit.getWorld(plugin.getConfig().getString("RedVillager.World")).getEntities()) {
			if(e instanceof Villager) {
				((Villager) e).setHealth(0);
			}
		}
		
		
		Location redvillagerl = new Location(Bukkit.getWorld(plugin.getConfig().getString("RedVillager.World")), plugin.getConfig().getDouble("RedVillager.X"),
				plugin.getConfig().getDouble("RedVillager.Y"), plugin.getConfig().getDouble("RedVillager.Z"));
		Location yellowvillagerl = new Location(Bukkit.getWorld(plugin.getConfig().getString("YellowVillager.World")), plugin.getConfig().getDouble("YellowVillager.X"),
				plugin.getConfig().getDouble("YellowVillager.Y"), plugin.getConfig().getDouble("YellowVillager.Z"));
		Location bluevillagerl = new Location(Bukkit.getWorld(plugin.getConfig().getString("BlueVillager.World")), plugin.getConfig().getDouble("BlueVillager.X"),
				plugin.getConfig().getDouble("BlueVillager.Y"), plugin.getConfig().getDouble("BlueVillager.Z"));
		Location greenvillagerl = new Location(Bukkit.getWorld(plugin.getConfig().getString("GreenVillager.World")), plugin.getConfig().getDouble("GreenVillager.X"),
				plugin.getConfig().getDouble("GreenVillager.Y"), plugin.getConfig().getDouble("GreenVillager.Z"));
		
		Entity redvillager = Bukkit.getWorld("bedwars").spawnEntity(redvillagerl, EntityType.VILLAGER);
		redvillager.setCustomName(ChatColor.RED + "Item Shop");
		redvillager.setCustomNameVisible(true);
		this.freezeEntity(redvillager);
		
		Entity yellowvillager = Bukkit.getWorld("bedwars").spawnEntity(yellowvillagerl, EntityType.VILLAGER);
		yellowvillager.setCustomName(ChatColor.YELLOW + "Item Shop");
		yellowvillager.setCustomNameVisible(true);
		this.freezeEntity(yellowvillager);
		
		Entity bluevillager = Bukkit.getWorld("bedwars").spawnEntity(bluevillagerl, EntityType.VILLAGER);
		bluevillager.setCustomName(ChatColor.BLUE + "Item Shop");
		bluevillager.setCustomNameVisible(true);
		this.freezeEntity(bluevillager);
		
		Entity greenvillager = Bukkit.getWorld("bedwars").spawnEntity(greenvillagerl, EntityType.VILLAGER);
		greenvillager.setCustomName(ChatColor.GREEN + "Item Shop");
		greenvillager.setCustomNameVisible(true);
		this.freezeEntity(greenvillager);
	}
	
	
	public void gameStop(Player p) {
		//bungee
		p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		p.getInventory().setHelmet(null);
		p.getInventory().clear();
		
		p.setGameMode(GameMode.ADVENTURE);
		
		plugin.playersInGame.clear();
		plugin.playerManager.clear();
		
		p.setPlayerListName(ChatColor.WHITE + p.getName());
		
		p.kickPlayer(ChatColor.RED + "Game Has Ended");
		
		
		plugin.playersLeftGame.clear();
		
		blueTeam.removeBluePlayers();
		redTeam.removeRedPlayers();
		yellowTeam.removeYellowPlayers();
		greenTeam.removeBluePlayers();
		
		PlayerScoreboard.scoreLobby(p);
		
	}
	
	public boolean playerCheck(int online) {
		
		if(online >= playersNeeded) {
			if(isStarted == false) {
				lobbyCountdown();
				setStarted(true);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public void emeraldDrop() {
		BossBar serverBB = plugin.getServer().createBossBar("§eYou're playing §c§lBED WARS §eon §c§lGl1tchCraft", BarColor.YELLOW, BarStyle.SOLID);
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				
				everyoneDead();

				
				
					if(emeraldCountdown > 0) {
						emeraldCountdown = emeraldCountdown - 1;
						for(Player p : Bukkit.getOnlinePlayers()) {
						PlayerScoreboard.scoreGame(p, emeraldCountdown);
						serverBB.addPlayer(p);
						}
						
					} else {
						emeraldCountdown = plugin.getConfig().getInt("EmeraldTimer");
						Location emerald = new Location(Bukkit.getWorld(plugin.getConfig().getString("EmeraldDropper.World")), plugin.getConfig().getDouble("EmeraldDropper.X"),
								plugin.getConfig().getDouble("EmeraldDropper.Y"), plugin.getConfig().getDouble("EmeraldDropper.Z"));
						Bukkit.getWorld("bedwars").dropItem(emerald, new ItemStack(Material.EMERALD)).setVelocity(new Vector(0, 0, 0));
					}
			}
			
		}, 0, 20L);
		
	}
	
	public void diamondDrop() {
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
					if(diamondCountdown > 0) {
						diamondCountdown = diamondCountdown - 1;
						
					} else {
						diamondCountdown = plugin.getConfig().getInt("DiamondTimer");
						Location d1 = new Location(Bukkit.getWorld(plugin.getConfig().getString("DiamondDropper1.World")), plugin.getConfig().getDouble("DiamondDropper1.X"),
								plugin.getConfig().getDouble("DiamondDropper1.Y"), plugin.getConfig().getDouble("DiamondDropper1.Z"));
						Location d2 = new Location(Bukkit.getWorld(plugin.getConfig().getString("DiamondDropper2.World")), plugin.getConfig().getDouble("DiamondDropper2.X"),
								plugin.getConfig().getDouble("DiamondDropper2.Y"), plugin.getConfig().getDouble("DiamondDropper2.Z"));
						Location d3 = new Location(Bukkit.getWorld(plugin.getConfig().getString("DiamondDropper3.World")), plugin.getConfig().getDouble("DiamondDropper3.X"),
								plugin.getConfig().getDouble("DiamondDropper3.Y"), plugin.getConfig().getDouble("DiamondDropper3.Z"));
						Location d4 = new Location(Bukkit.getWorld(plugin.getConfig().getString("DiamondDropper4.World")), plugin.getConfig().getDouble("DiamondDropper4.X"),
								plugin.getConfig().getDouble("DiamondDropper4.Y"), plugin.getConfig().getDouble("DiamondDropper4.Z"));
						Bukkit.getWorld("bedwars").dropItem(d1, new ItemStack(Material.DIAMOND)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(d2, new ItemStack(Material.DIAMOND)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(d3, new ItemStack(Material.DIAMOND)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(d4, new ItemStack(Material.DIAMOND)).setVelocity(new Vector(0, 0, 0));
					}
			}
			
		}, 0, 20L);
		
	}
	
	public void ironDrop() {
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
					if(ironCountdown > 0) {
						ironCountdown = ironCountdown - 1;
						
					} else {
						ironCountdown = plugin.getConfig().getInt("IronTimer");
						
						//Red
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 368, 122, 377), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 368, 122, 374), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Yellow
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 389, 122, 351), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 392, 122, 351), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Blue
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 391, 122, 410), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 389, 122, 410), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Green
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 419, 122, 374), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 419, 122, 376), new ItemStack(Material.IRON_INGOT)).setVelocity(new Vector(0, 0, 0));
					}
			}
			
		}, 0, 20L);
		
	}
	
	public void goldDrop() {
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
					if(goldCountdown > 0) {
						goldCountdown = goldCountdown - 1;
						
					} else {
						goldCountdown = plugin.getConfig().getInt("GoldTimer");
						
						//Red
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 368, 122, 374), new ItemStack(Material.GOLD_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Yellow
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 392, 122, 351), new ItemStack(Material.GOLD_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Blue
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 389, 122, 410), new ItemStack(Material.GOLD_INGOT)).setVelocity(new Vector(0, 0, 0));
						
						//Green
						Bukkit.getWorld("bedwars").dropItem(new Location(Bukkit.getWorld("bedwars"), 419, 122, 376), new ItemStack(Material.GOLD_INGOT)).setVelocity(new Vector(0, 0, 0));
					}
			}
			
		}, 0, 20L);
		
	}
	
	public void lobbyCountdown() {
		
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		taskId = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				if(lobbyCountdown > 0) {
					playerCheck(plugin.playersInGame.size());
					if(playerCheck(plugin.playersInGame.size()) == true) {
						lobbyCountdown = lobbyCountdown - 1;
						Bukkit.getServer().broadcastMessage("§eThe game will start in §a" + lobbyCountdown + " §eseconds.");
						for(Player online : Bukkit.getOnlinePlayers()) {
							online.playSound(online.getLocation(), Sound.BLOCK_NOTE_PLING, 2, 2);
							online.setLevel(lobbyCountdown);
						}
					} else {
						Bukkit.getServer().broadcastMessage("§c" + playersNeeded + "§e until game start.");
						Bukkit.getServer().getScheduler().cancelTask(taskId);
						lobbyCountdown = plugin.getConfig().getInt("LobbyTimer");
					}
					
					
				} else {
					Bukkit.getServer().getScheduler().cancelTask(taskId);
					gameStart();
					Bukkit.getServer().broadcastMessage("§eGood luck! The game is starting!");
				}
			}
		}, 0, 20L);
		
	}
	
	public void everyoneDead() {
		BukkitScheduler scheduler = plugin.getServer().getScheduler();
		taskId = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				int online = plugin.playersInGame.size();
				if(online == 1) {
					Bukkit.getServer().getScheduler().cancelTask(taskId);
					
					if(GameManager.redTeam.getRedPlayers().size() > 0) {
						Bukkit.broadcastMessage("§c§lRED TEAM WINS!");
					}
					if(GameManager.yellowTeam.getYellowPlayers().size() > 0) {
						Bukkit.broadcastMessage("§e§lYELLOW TEAM WINS!");
					}
					if(GameManager.blueTeam.getBluePlayers().size() > 0) {
						Bukkit.broadcastMessage("§b§lBLUE TEAM WINS!");
					}
					if(GameManager.greenTeam.getGreenPlayers().size() > 0) {
						Bukkit.broadcastMessage("§a§lGREEN TEAM WINS!");
					}
					
					for(Player p : Bukkit.getOnlinePlayers()) {
						gameStop(p);
					}
				}
			}
			
		}, 0, 20L);
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
	
	public void freezeEntity(Entity en){
        net.minecraft.server.v1_12_R1.Entity nmsEn = ((CraftEntity) en).getHandle();
        NBTTagCompound compound = new NBTTagCompound();
        nmsEn.c(compound);
        compound.setByte("NoAI", (byte) 1);
        nmsEn.f(compound);
    }
	
	
	
	
}
