package me.gl1tchcraft.bedwars.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.md_5.bungee.api.ChatColor;

public class ClickEvent implements Listener {
	
	@EventHandler
	public void onVillagerClick(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if(e.getRightClicked() instanceof Villager) {
			Entity villager = e.getRightClicked();
			if(villager.isCustomNameVisible() == true) {
				if(villager.getCustomName().equalsIgnoreCase(ChatColor.RED + "Item Shop") || villager.getCustomName().equalsIgnoreCase(ChatColor.YELLOW + "Item Shop")
						|| villager.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Item Shop") || villager.getCustomName().equalsIgnoreCase(ChatColor.BLUE + "Item Shop")) {
					e.setCancelled(true);
					InventoryManager.setupInv(ChatColor.RED + "Player Item Shop", p);
					return;
				}
			}
		
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Material clicked = e.getCurrentItem().getType();
		Player p = (Player) e.getWhoClicked();
		if(e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.RED + "Player Item Shop")) {
			e.setCancelled(true);
			
			//TODO add inventories to open
			if(clicked == Material.WOOL) {
				p.closeInventory();
				InventoryManager.blockInventory(p);
			}
			if(clicked == Material.TNT) {
				p.closeInventory();
				InventoryManager.utilityInventory(p);
			}
			if(clicked == Material.GOLD_SWORD) {
				p.closeInventory();
				InventoryManager.toolsInventory(p);
			}
			if(clicked == Material.CHAINMAIL_BOOTS) {
				p.closeInventory();
			}
		}
		//If its BLOCKS
		if(e.getClickedInventory().getName().equalsIgnoreCase( ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "BLOCKS")) {
			e.setCancelled(true);
			if(clicked == Material.WOOL) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.WOOD) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.STAINED_GLASS) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.ENDER_STONE) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.OBSIDIAN) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.HAY_BLOCK) {
				InventoryManager.purchaseManager(p, clicked);
			}
		}
		if(e.getClickedInventory().getName().equalsIgnoreCase( ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "UTILITIES")) {
			e.setCancelled(true);
			if(clicked == Material.FIREBALL) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.TNT) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.EGG) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.ENDER_PEARL) {
				InventoryManager.purchaseManager(p, clicked);
			}
		}
		
		if(e.getClickedInventory().getName().equalsIgnoreCase( ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "TOOLS")) {
			e.setCancelled(true);
			if(clicked == Material.STONE_PICKAXE) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.IRON_PICKAXE) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.DIAMOND_PICKAXE) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.STONE_SWORD) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.IRON_SWORD) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.DIAMOND_SWORD) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.SHEARS) {
				InventoryManager.purchaseManager(p, clicked);
			}
			if(clicked == Material.REDSTONE_TORCH_ON) {
				InventoryManager.purchaseManager(p, clicked);
			}

		}
	}
	

}
