package me.gl1tchcraft.bedwars.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.bedwars.gameifno.GameManager;
import me.gl1tchcraft.bedwars.items.ItemCreator;
import me.gl1tchcraft.bedwars.playerinfo.PlayerScoreboard;
import net.md_5.bungee.api.ChatColor;

public class InventoryManager {
	
	public static void setupInv(String name, Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 54, name);
		
		ItemStack blocks = ItemCreator.createItem(Material.WOOL, ChatColor.YELLOW + "Blocks", ChatColor.GRAY + "Blocks to defend your bed.", 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(10, blocks);
		
		ItemStack utitlites = ItemCreator.createItem(Material.TNT, ChatColor.RED + "Utilities", ChatColor.GRAY + "Cool toys that go boom!", 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(11, utitlites);
		
		ItemStack tools = ItemCreator.createItem(Material.GOLD_SWORD, ChatColor.AQUA + "Tools", ChatColor.GRAY + "Things that hurt.", 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(12, tools);
		
		ItemStack armor = ItemCreator.createItem(Material.CHAINMAIL_BOOTS, ChatColor.BLUE + "Armor", ChatColor.GRAY + "Protect yo' self.", 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(13, armor);
		
		ItemStack divider = ItemCreator.createGlassItem(Material.STAINED_GLASS_PANE, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(36, divider);
		inv.setItem(37, divider);
		inv.setItem(38, divider);
		inv.setItem(39, divider);
		inv.setItem(40, divider);
		inv.setItem(41, divider);
		inv.setItem(42, divider);
		inv.setItem(43, divider);
		inv.setItem(44, divider);
		
		int emeraldamount = PlayerScoreboard.getAmount(p, Material.EMERALD);
		ItemStack emeraldamount2 = ItemCreator.createAmountItem(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Emeralds: " + ChatColor.YELLOW + "" + emeraldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(45, emeraldamount2);
		
		int diamondamount = PlayerScoreboard.getAmount(p, Material.DIAMOND);
		ItemStack diamondamount2 = ItemCreator.createAmountItem(Material.DIAMOND, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamonds: " + ChatColor.YELLOW + "" + diamondamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(46, diamondamount2);
		
		int goldamount = PlayerScoreboard.getAmount(p, Material.GOLD_INGOT);
		ItemStack goldamount2 = ItemCreator.createAmountItem(Material.GOLD_INGOT, ChatColor.GOLD + "" + ChatColor.BOLD + "Gold Ingots: " + ChatColor.YELLOW + "" + goldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(47, goldamount2);
		
		int ironamount = PlayerScoreboard.getAmount(p, Material.IRON_INGOT);
		ItemStack ironamount2 = ItemCreator.createAmountItem(Material.IRON_INGOT, ChatColor.WHITE + "" + ChatColor.BOLD + "Iron Ingots: " + ChatColor.YELLOW + "" + ironamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(48, ironamount2);
		
		p.openInventory(inv);
		
		
		
	}
	
	public static void blockInventory(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "BLOCKS");
		
		ItemStack wool = ItemCreator.createShopItem(Material.WOOL, "§9Wool", "§f6 Iron", 16);
		inv.setItem(10, wool);
		
		ItemStack wood = ItemCreator.createShopItem(Material.WOOD, "§9Planks", "§f16 Iron", 8);
		inv.setItem(11, wood);
		
		ItemStack glass = ItemCreator.createShopItem(Material.STAINED_GLASS, "§9Blast Proof Glass", "§e10 Gold", 16);
		inv.setItem(12, glass);
		
		ItemStack endstone = ItemCreator.createShopItem(Material.ENDER_STONE, "§9End Stone", "§e5 Gold", 24);
		inv.setItem(13, endstone);
		
		ItemStack obby = ItemCreator.createShopItem(Material.OBSIDIAN, "§9Obsidian", "§a3 Emeralds", 3);
		inv.setItem(14, obby);
		
		ItemStack hay = ItemCreator.createShopItem(Material.HAY_BLOCK, "§9Hay Block", "§f6 Iron", 32);
		inv.setItem(15, hay);
		
		ItemStack divider = ItemCreator.createGlassItem(Material.STAINED_GLASS_PANE, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(36, divider);
		inv.setItem(37, divider);
		inv.setItem(38, divider);
		inv.setItem(39, divider);
		inv.setItem(40, divider);
		inv.setItem(41, divider);
		inv.setItem(42, divider);
		inv.setItem(43, divider);
		inv.setItem(44, divider);
		
		int emeraldamount = PlayerScoreboard.getAmount(p, Material.EMERALD);
		ItemStack emeraldamount2 = ItemCreator.createAmountItem(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Emeralds: " + ChatColor.YELLOW + "" + emeraldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(45, emeraldamount2);
		
		int diamondamount = PlayerScoreboard.getAmount(p, Material.DIAMOND);
		ItemStack diamondamount2 = ItemCreator.createAmountItem(Material.DIAMOND, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamonds: " + ChatColor.YELLOW + "" + diamondamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(46, diamondamount2);
		
		int goldamount = PlayerScoreboard.getAmount(p, Material.GOLD_INGOT);
		ItemStack goldamount2 = ItemCreator.createAmountItem(Material.GOLD_INGOT, ChatColor.GOLD + "" + ChatColor.BOLD + "Gold Ingots: " + ChatColor.YELLOW + "" + goldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(47, goldamount2);
		
		int ironamount = PlayerScoreboard.getAmount(p, Material.IRON_INGOT);
		ItemStack ironamount2 = ItemCreator.createAmountItem(Material.IRON_INGOT, ChatColor.WHITE + "" + ChatColor.BOLD + "Iron Ingots: " + ChatColor.YELLOW + "" + ironamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(48, ironamount2);
		
		p.openInventory(inv);
	}
	
	public static void utilityInventory(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "UTILITIES");
		
		ItemStack fireball = ItemCreator.createShopItem(Material.FIREBALL, "§9Fireball", "§f64 Iron", 1);
		inv.setItem(10, fireball);
		
		ItemStack tnt = ItemCreator.createShopItem(Material.TNT, "§9Trinitrotoluene (TNT)", "§e15 Gold", 2);
		inv.setItem(11, tnt);
		
		ItemStack egg = ItemCreator.createShopItem(Material.EGG, "§9Egg", "§f10 Iron", 2);
		inv.setItem(12, egg);
		
		ItemStack epearl = ItemCreator.createShopItem(Material.ENDER_PEARL, "§9Ender Pearl", "§a2 Emeralds", 1);
		inv.setItem(13, epearl);

		
		ItemStack divider = ItemCreator.createGlassItem(Material.STAINED_GLASS_PANE, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(36, divider);
		inv.setItem(37, divider);
		inv.setItem(38, divider);
		inv.setItem(39, divider);
		inv.setItem(40, divider);
		inv.setItem(41, divider);
		inv.setItem(42, divider);
		inv.setItem(43, divider);
		inv.setItem(44, divider);
		
		int emeraldamount = PlayerScoreboard.getAmount(p, Material.EMERALD);
		ItemStack emeraldamount2 = ItemCreator.createAmountItem(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Emeralds: " + ChatColor.YELLOW + "" + emeraldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(45, emeraldamount2);
		
		int diamondamount = PlayerScoreboard.getAmount(p, Material.DIAMOND);
		ItemStack diamondamount2 = ItemCreator.createAmountItem(Material.DIAMOND, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamonds: " + ChatColor.YELLOW + "" + diamondamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(46, diamondamount2);
		
		int goldamount = PlayerScoreboard.getAmount(p, Material.GOLD_INGOT);
		ItemStack goldamount2 = ItemCreator.createAmountItem(Material.GOLD_INGOT, ChatColor.GOLD + "" + ChatColor.BOLD + "Gold Ingots: " + ChatColor.YELLOW + "" + goldamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(47, goldamount2);
		
		int ironamount = PlayerScoreboard.getAmount(p, Material.IRON_INGOT);
		ItemStack ironamount2 = ItemCreator.createAmountItem(Material.IRON_INGOT, ChatColor.WHITE + "" + ChatColor.BOLD + "Iron Ingots: " + ChatColor.YELLOW + "" + ironamount, 1, ItemFlag.HIDE_ATTRIBUTES);
		inv.setItem(48, ironamount2);
		
		p.openInventory(inv);
	}
	
	public static void purchaseManager(Player p, Material m) {
		String team = playerTeam(p);
		if(team != null) {
			//wool
			if(m == Material.WOOL) {
				//team stuffs
				ItemStack wool = null;
				if(team == "Red") {
				wool = new ItemStack(Material.WOOL, 16, (byte) 14);
				}
				if(team == "Yellow") {
				wool = new ItemStack(Material.WOOL, 16, (byte) 4);
				}
				if(team == "Green") {
				wool = new ItemStack(Material.WOOL, 16, (byte) 5);
				}
				if(team == "Blue") {
				wool = new ItemStack(Material.WOOL, 16, (byte) 3);
				}
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 6);
				if(p.getInventory().containsAtLeast(iron, 6)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wool);
					p.sendMessage("§7You purchased §fWool §7for §f6 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			//Glass
			if(m == Material.STAINED_GLASS) {
				//team stuffs
				ItemStack wool = null;
				if(team == "Red") {
				wool = new ItemStack(Material.STAINED_GLASS, 16, (byte) 14);
				}
				if(team == "Yellow") {
				wool = new ItemStack(Material.STAINED_GLASS, 16, (byte) 4);
				}
				if(team == "Green") {
				wool = new ItemStack(Material.STAINED_GLASS, 16, (byte) 5);
				}
				if(team == "Blue") {
				wool = new ItemStack(Material.STAINED_GLASS, 16, (byte) 3);
				}
				ItemStack gold = new ItemStack(Material.GOLD_INGOT, 10);
				if(p.getInventory().containsAtLeast(gold, 10)) {
					p.getInventory().removeItem(gold);
					p.getInventory().addItem(wool);
					p.sendMessage("§7You purchased §cBlast-Proof Glass §7for §e10 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			
			//Wood
			if(m == Material.WOOD) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 16);
				ItemStack wood = new ItemStack(Material.WOOD, 8);
				if(p.getInventory().containsAtLeast(iron, 16)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §ePlanks §7for §f16 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.HAY_BLOCK) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 6);
				ItemStack wood = new ItemStack(Material.HAY_BLOCK, 16);
				if(p.getInventory().containsAtLeast(iron, 6)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eHay Blocks §7for §f6 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.ENDER_STONE) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 5);
				ItemStack wood = new ItemStack(Material.ENDER_STONE, 24);
				if(p.getInventory().containsAtLeast(iron, 5)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eEnd Stone §7for §e5 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.OBSIDIAN) {
				ItemStack iron = new ItemStack(Material.EMERALD, 3);
				ItemStack wood = new ItemStack(Material.OBSIDIAN, 3);
				if(p.getInventory().containsAtLeast(iron, 3)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §9Obsidian §7for §a3 Emeralds§7.");
				} else {
					p.sendMessage("§cYou don't have enough emeralds!");
				}
			}
			
			
			
			
			if(m == Material.FIREBALL) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 64);
				ItemStack fireball = ItemCreator.createItem(Material.FIREBALL, ChatColor.DARK_RED + "Fireball", ChatColor.GRAY + "Right click for a boom!", 1, ItemFlag.HIDE_ATTRIBUTES);
				if(p.getInventory().containsAtLeast(iron, 64)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(fireball);
					p.sendMessage("§7You purchased §cFireball §7for §f64 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			if(m == Material.TNT) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 15);
				ItemStack wood = new ItemStack(Material.TNT, 3);
				if(p.getInventory().containsAtLeast(iron, 15)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §cTrinitrotoluene (TNT) §7for §e15 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.ENDER_PEARL) {
				ItemStack iron = new ItemStack(Material.EMERALD, 2);
				ItemStack wood = new ItemStack(Material.ENDER_PEARL, 1);
				if(p.getInventory().containsAtLeast(iron, 2)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §5Ender Peal §7for §a2 Emeralds§7.");
				} else {
					p.sendMessage("§cYou don't have enough emeralds!");
				}
			}
			
			if(m == Material.EGG) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 10);
				ItemStack wood = new ItemStack(Material.EGG, 2);
				if(p.getInventory().containsAtLeast(iron, 10)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eEggs §7for §f10 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iorn!");
				}
			}
		}
	}
	
	public static String playerTeam(Player p) {
		if(GameManager.redTeam.getRedPlayers().contains(p)) {
			return "Red";
		}
		if(GameManager.yellowTeam.getYellowPlayers().contains(p)) {
			return "Yellow";
		}
		if(GameManager.greenTeam.getGreenPlayers().contains(p)) {
			return "Green";
		}
		if(GameManager.blueTeam.getBluePlayers().contains(p)) {
			return "Blue";
		}
		return null;
	}

}
