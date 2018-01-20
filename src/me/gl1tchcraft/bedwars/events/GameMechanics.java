package me.gl1tchcraft.bedwars.events;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.logging.log4j.spi.ReadOnlyThreadContextMap;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Bed;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.bedwars.Main;
import me.gl1tchcraft.bedwars.gameifno.GameManager;
import me.gl1tchcraft.bedwars.items.ItemCreator;
import me.gl1tchcraft.bedwars.playerinfo.PlayerManager;
import me.gl1tchcraft.bedwars.playerinfo.PlayerScoreboard;
import me.gl1tchcraft.bedwars.teaminfo.TeamManager;
import net.md_5.bungee.api.ChatColor;

public class GameMechanics implements Listener {
	
	private Main plugin = Main.getPlugin(Main.class);
	private ArrayList<Material> blocks = new ArrayList<Material>();
	private ArrayList<Material> allowedBlocks = new ArrayList<Material>();
	
	private int taggersSelected;
	

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if(plugin.gameManager.isStarted() == false) {
			Player p = e.getPlayer();	
			UUID uuid = p.getUniqueId();
			
			if(plugin.playersLeftGame.contains(p)) {
				// TODO bungee pushback.
			}
			
			p.setGameMode(GameMode.ADVENTURE);
			e.setJoinMessage("");
			
			GameManager.assignTeam(p);
			p.sendMessage("DEBUG: " + GameManager.redTeam.getTeam(p));
			
			if(plugin.gameManager.isStarted == false) {
				for(Entity e2 : Bukkit.getWorld("bedwars").getEntities()) {
					if(e2 instanceof Item) {
						e2.remove();
					}
				}
			}
			
			plugin.playerManager.put(uuid, new PlayerManager(uuid, false, 0, false, false));
			plugin.playersInGame.add(p);
			plugin.gameManager.lobbyWait(p);
			p.teleport(GameManager.lobbySpawn);
			PlayerScoreboard.scoreLobby(p);
			p.sendMessage(p.getWorld().getName());
			
			
		} else {
			//TODO bungee pushback.
		}
	}
	
	public static void equipArmor(Player p, int r, int g, int b) {
		ItemStack helmet = ItemCreator.createLeather(Material.LEATHER_HELMET, r, g, b, ItemFlag.HIDE_ATTRIBUTES);
		ItemStack chest = ItemCreator.createLeather(Material.LEATHER_CHESTPLATE, r, g, b, ItemFlag.HIDE_ATTRIBUTES);
		ItemStack legs = ItemCreator.createLeather(Material.LEATHER_LEGGINGS, r, g, b, ItemFlag.HIDE_ATTRIBUTES);
		ItemStack boots = ItemCreator.createLeather(Material.LEATHER_BOOTS, r, g, b, ItemFlag.HIDE_ATTRIBUTES);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(legs);
		p.getInventory().setBoots(boots);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();	
		UUID uuid = p.getUniqueId();
		
		p.getInventory().clear();
		e.setQuitMessage("");
		plugin.playerManager.remove(uuid);
		plugin.playersInGame.remove(p);
		plugin.playersLeftGame.add(p);
		
		p.setPlayerListName(ChatColor.WHITE + p.getName());
		
		GameManager.redTeam.removeRedPlayer(p);
		GameManager.blueTeam.removeBluePlayer(p);
		GameManager.yellowTeam.removeYellowPlayer(p);
		GameManager.greenTeam.removeGreenPlayer(p);
		
	}
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		if(e.getEntity() instanceof TNTPrimed || e.getEntity() instanceof Fireball) {
			allowedBlocks.add(Material.WOOL);
			allowedBlocks.add(Material.WOOD);
			allowedBlocks.add(Material.ENDER_STONE);
			
			for(Block b : e.blockList()) {
				for(Material m : allowedBlocks) {
					if(b.getType() == m) {
						b.setType(Material.AIR);
					} else {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	@EventHandler
    public void craftItem(PrepareItemCraftEvent e) {
		  e.getInventory().setResult(new ItemStack(Material.AIR));
	}
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
			e.setCancelled(true);
		}
	}

	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(plugin.gameManager.isStarted() == false) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void foodLevelChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void placeBlockEvent(BlockPlaceEvent e) {
		if(!e.getPlayer().hasPermission("place.bedwars.gl1tchcraft")) {
		//Add allowed blocks
			blocks.add(Material.WOOL);
			blocks.add(Material.ENDER_STONE);
			blocks.add(Material.STAINED_GLASS);
			
			if(!blocks.contains(e.getBlock().getType())) {
			e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void breakBlockEvent(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(plugin.gameManager.isStarted() == false) {
			e.setCancelled(true);
		}
		blocks.add(Material.WOOL);
		blocks.add(Material.ENDER_STONE);
		blocks.add(Material.STAINED_GLASS);
		
		
		if(!blocks.contains(e.getBlock().getType())) {
			if(e.getBlock().getType() == Material.BED_BLOCK) {
				Bed bed = (Bed)e.getBlock().getState();
				Block bedBlock = e.getBlock();
				DyeColor color = bed.getColor();
				
				if(color == DyeColor.RED) {
					if(GameManager.redTeam.getRedPlayers().contains(p)) {
						e.setCancelled(true);
					} else {
						e.setCancelled(true);
						bedBlock.setType(Material.AIR);
						Bukkit.broadcastMessage("§c§lRed Team has lost their bed!");
						GameManager.redTeam.setHasBed(false);
					}
				}
				if(color == DyeColor.LIGHT_BLUE) {
					if(GameManager.blueTeam.getBluePlayers().contains(p)) {
						e.setCancelled(true);
					} else {
						e.setCancelled(true);
						bedBlock.setType(Material.AIR);
						Bukkit.broadcastMessage("§b§lBlue Team has lost their bed!");
						GameManager.blueTeam.setHasBed(false);
					}
				}
				if(color == DyeColor.YELLOW) {
					if(GameManager.yellowTeam.getYellowPlayers().contains(p)) {
						e.setCancelled(true);
					} else {
						e.setCancelled(true);
						bedBlock.setType(Material.AIR);
						Bukkit.broadcastMessage("§e§lYellow Team has lost their bed!");
						GameManager.yellowTeam.setHasBed(false);
					}
				}
				if(color == DyeColor.LIME) {
					if(GameManager.greenTeam.getGreenPlayers().contains(p)) {
						e.setCancelled(true);
					} else {
						e.setCancelled(true);
						bedBlock.setType(Material.AIR);
						Bukkit.broadcastMessage("§a§lGreen Team has lost their bed!");
						GameManager.greenTeam.setHasBed(false);
					}
				}
				
			} else {
				e.setCancelled(true);
			}
		}
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getItem() != null) {
			if(e.getItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				ItemStack fireball = ItemCreator.createItem(Material.FIREBALL, ChatColor.DARK_RED + "Fireball", ChatColor.GRAY + "Right click for a boom!", 1, ItemFlag.HIDE_ATTRIBUTES);
				p.getInventory().removeItem(fireball);
				Fireball fireballer = p.getWorld().spawn(p.getEyeLocation().clone().add(0, 1, 0), Fireball.class);
				fireballer.setVelocity(p.getEyeLocation().getDirection().multiply(2));
				fireballer.setIsIncendiary(true);
			}

		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.getDrops().clear();
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		if(plugin.gameManager.isStarted() == true) {
			if(GameManager.greenTeam.getGreenPlayers().contains(p)) {
				if(GameManager.greenTeam.isHasBed() == false) {
					p.getInventory().clear();
					plugin.playerManager.remove(uuid);
					plugin.playersInGame.remove(p);
					plugin.playersLeftGame.add(p);
					GameManager.greenTeam.getGreenPlayers().remove(p);
					for(Player ps : Bukkit.getOnlinePlayers()) {
					p.setPlayerListName(ChatColor.GRAY + p.getName());
					}
					Bukkit.broadcastMessage("§a" + p.getName() + " has died §lFINAL DEATH");
					e.setRespawnLocation(GameManager.greenSpawn);
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					e.setRespawnLocation(GameManager.greenSpawn);
					GameMechanics.equipArmor(p, 0, 255, 0);
				}
			}
			if(GameManager.redTeam.getRedPlayers().contains(p)) {
				if(GameManager.redTeam.isHasBed() == false) {
					p.getInventory().clear();
					plugin.playerManager.remove(uuid);
					plugin.playersInGame.remove(p);
					plugin.playersLeftGame.add(p);
					GameManager.redTeam.getRedPlayers().remove(p);
					for(Player ps : Bukkit.getOnlinePlayers()) {
					p.setPlayerListName(ChatColor.GRAY + p.getName());
					}
					Bukkit.broadcastMessage("§c" + p.getName() + " has died §lFINAL DEATH");
					e.setRespawnLocation(GameManager.redSpawn);
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					e.setRespawnLocation(GameManager.redSpawn);
					GameMechanics.equipArmor(p, 255, 0, 0);
				}
			}
			if(GameManager.blueTeam.getBluePlayers().contains(p)) {
				if(GameManager.blueTeam.isHasBed() == false) {
					p.getInventory().clear();
					plugin.playerManager.remove(uuid);
					plugin.playersInGame.remove(p);
					plugin.playersLeftGame.add(p);
					GameManager.blueTeam.getBluePlayers().remove(p);
					Bukkit.broadcastMessage("§b" + p.getName() + " has died §lFINAL DEATH");
					for(Player ps : Bukkit.getOnlinePlayers()) {
					p.setPlayerListName(ChatColor.GRAY + p.getName());
					}
					e.setRespawnLocation(GameManager.blueSpawn);
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					e.setRespawnLocation(GameManager.blueSpawn);
					GameMechanics.equipArmor(p, 0, 0, 255);
				}
			}
			if(GameManager.yellowTeam.getYellowPlayers().contains(p)) {
				if(GameManager.yellowTeam.isHasBed() == false) {
					p.getInventory().clear();
					plugin.playerManager.remove(uuid);
					plugin.playersInGame.remove(p);
					plugin.playersLeftGame.add(p);
					GameManager.yellowTeam.getYellowPlayers().remove(p);
					for(Player ps : Bukkit.getOnlinePlayers()) {
					p.setPlayerListName(ChatColor.GRAY + p.getName());
					}
					Bukkit.broadcastMessage("§b" + p.getName() + " has died §lFINAL DEATH");
					e.setRespawnLocation(GameManager.yellowSpawn);
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					e.setRespawnLocation(GameManager.yellowSpawn);
					GameMechanics.equipArmor(p, 255, 250, 0);
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();
		
		//if game is going
		if(plugin.gameManager.isStarted == true) {
			//if player is in game
			if(plugin.playersInGame.contains(p)) {
				e.setCancelled(true);
				//if player is on red team
				if(GameManager.redTeam.getRedPlayers().contains(p)) {
					for(Player red : GameManager.redTeam.getRedPlayers()) {
						red.sendMessage("§c[RED] " + p.getName() + ":§7 " + m);
					}
				}
				if(GameManager.greenTeam.getGreenPlayers().contains(p)) {
					for(Player red : GameManager.greenTeam.getGreenPlayers()) {
						red.sendMessage("§a[GREEN] " + p.getName() + ":§7 " + m);
					}
				}
				if(GameManager.yellowTeam.getYellowPlayers().contains(p)) {
					for(Player red : GameManager.yellowTeam.getYellowPlayers()) {
						red.sendMessage("§e[YELLOW] " + p.getName() + ":§7 " + m);
					}
				}
				if(GameManager.blueTeam.getBluePlayers().contains(p)) {
					for(Player red : GameManager.blueTeam.getBluePlayers()) {
						red.sendMessage("§b[BLUE] " + p.getName() + ":§7 " + m);
					}
				}
			} else {
				for(Player online : Bukkit.getOnlinePlayers()) {
					if(!plugin.playersInGame.contains(online)) {
						online.sendMessage("§7[SPECTATOR] " + p.getName() + ":§7 " + m);
					}
				}
			}
			
			
			
		}
		
	}
	

}
