package me.gl1tchcraft.bedwars.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

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
		
		ItemStack sign = ItemCreator.createShopItem(Material.SIGN, "§9Back", "§e<---", 1);
		inv.setItem(53, sign);
		
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
		
		ItemStack sign = ItemCreator.createShopItem(Material.SIGN, "§9Back", "§e<---", 1);
		inv.setItem(53, sign);
		
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
		
		ItemStack egg = ItemCreator.createShopItem(Material.EGG, "§9Single Block Bridge Egg", "§f3 Iron", 2);
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
		
		ItemStack sign = ItemCreator.createShopItem(Material.SIGN, "§9Back", "§e<---", 1);
		inv.setItem(53, sign);
		
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
	
	public static void toolsInventory(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "TOOLS");
		
		ItemStack shears = ItemCreator.createShopItem(Material.SHEARS, "§9Shears", "§f10 Iron", 1);
		inv.setItem(10, shears);
		
		ItemStack stonesword = ItemCreator.createShopItem(Material.STONE_SWORD, "§9Stone Sword", "§f15 Iron", 1);
		inv.setItem(11, stonesword);
		
		ItemStack ironsword = ItemCreator.createShopItem(Material.IRON_SWORD, "§9Iron Sword", "§e7 Gold", 1);
		inv.setItem(12, ironsword);
		
		ItemStack dsword = ItemCreator.createShopItem(Material.DIAMOND_SWORD, "§9Diamond Sword", "§a5 Emeralds", 1);
		inv.setItem(13, dsword);
		
		ItemStack stonepick = ItemCreator.createShopItem(Material.STONE_PICKAXE, "§9Stone Pickaxe", "§f15 Iron", 1);
		inv.setItem(14, stonepick);
		
		ItemStack ironpick = ItemCreator.createShopItem(Material.IRON_PICKAXE, "§9Iron Pickaxe", "§e12 Gold", 1);
		inv.setItem(15, ironpick);
		
		ItemStack dpick = ItemCreator.createShopItem(Material.DIAMOND_PICKAXE, "§9Diamond Pickaxe", "§a5 Emeralds", 1);
		inv.setItem(16, dpick);
		
		ItemStack tntdefuser = ItemCreator.createShopItem(Material.REDSTONE_TORCH_ON, "§9TNT Defuser", "§a2 Emeralds", 1);
		inv.setItem(19, tntdefuser);
		
		ItemStack bow = ItemCreator.createShopItem(Material.BOW, "§9Bow", "§f5 Iron Ingots", 1);
		inv.setItem(20, bow);
		
		ItemStack regarrows = ItemCreator.createShopItem(Material.ARROW, "§9Regular Arrow", "§e2 Gold", 8);
		inv.setItem(21, regarrows);
		
		ItemStack poisarrow = ItemCreator.createShopItem(Material.TIPPED_ARROW, "§9Poison Arrow", "§e15 Gold", 8);
		inv.setItem(22, poisarrow);
		
		ItemStack specarrow = ItemCreator.createShopItem(Material.SPECTRAL_ARROW, "§9Spectral Arrow", "§e25 Gold", 3);
		inv.setItem(23, specarrow);
		
		ItemStack kbs = ItemCreator.createShopItem(Material.STICK, "§Knockback Stick", "§f5 Iron", 1);
		inv.setItem(24, kbs);

		
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
		
		ItemStack sign = ItemCreator.createShopItem(Material.SIGN, "§9Back", "§e<---", 1);
		inv.setItem(53, sign);
		
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
	
	public static void armorInventory(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + "BedWars > " + ChatColor.DARK_RED + "ARMOR");
		
		ItemStack chainmail = ItemCreator.createShopItem(Material.CHAINMAIL_CHESTPLATE, "§9Full Chainmail Armor", "§b2 Diamonds", 1);
		inv.setItem(10, chainmail);
		
		ItemStack ironmale = ItemCreator.createShopItem(Material.IRON_CHESTPLATE, "§9Full Iron Armor", "§b10 Diamonds", 1);
		inv.setItem(11, ironmale);
		
		ItemStack diamondarmor = ItemCreator.createShopItem(Material.DIAMOND_CHESTPLATE, "§9Full Diamond Armor", "§b25 Diamonds", 1);
		inv.setItem(12, diamondarmor);
		
		ItemStack diamondarmorp2 = ItemCreator.createShopItem(Material.IRON_HELMET, "§9Full Iron Armor w/Prot II", "§b35 Diamonds", 1);
		diamondarmorp2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		inv.setItem(13, diamondarmorp2);

		
		ItemStack sign = ItemCreator.createShopItem(Material.SIGN, "§9Back", "§e<---", 1);
		inv.setItem(53, sign);
		
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
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 3);
				ItemStack wood = new ItemStack(Material.EGG, 2);
				if(p.getInventory().containsAtLeast(iron, 3)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eEggs §7for §f3 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.STICK) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 5);
				ItemStack wood = new ItemStack(Material.STICK, 1);
				if(p.getInventory().containsAtLeast(iron, 5)) {
					p.getInventory().removeItem(iron);
					wood.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eKnockback Stick §7for §f5 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			
			if(m == Material.SHEARS) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 10);
				ItemStack wood = new ItemStack(Material.SHEARS, 1);
				if(p.getInventory().containsAtLeast(iron, 10)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §fShears §7for §f10 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.STONE_SWORD) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 15);
				ItemStack wood = new ItemStack(Material.STONE_SWORD, 1);
				if(p.getInventory().containsAtLeast(iron, 15)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §8Stone Sword §7for §f15 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.IRON_SWORD) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 7);
				ItemStack wood = new ItemStack(Material.IRON_SWORD, 1);
				if(p.getInventory().containsAtLeast(iron, 7)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §fIron Sword §7for §e7 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.DIAMOND_SWORD) {
				ItemStack iron = new ItemStack(Material.EMERALD, 5);
				ItemStack wood = new ItemStack(Material.DIAMOND_SWORD, 1);
				if(p.getInventory().containsAtLeast(iron, 5)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §bDiamond Sword §7for §a5 Emeralds§7.");
				} else {
					p.sendMessage("§cYou don't have enough emeralds!");
				}
			}
			
			
			//
			if(m == Material.STONE_PICKAXE) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 15);
				ItemStack wood = new ItemStack(Material.STONE_PICKAXE, 1);
				if(p.getInventory().containsAtLeast(iron, 15)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §8Stone Pickaxe §7for §f15 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.IRON_PICKAXE) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 12);
				ItemStack wood = new ItemStack(Material.IRON_PICKAXE, 1);
				if(p.getInventory().containsAtLeast(iron, 12)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §fIron Pickaxe §7for §e12 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.DIAMOND_PICKAXE) {
				ItemStack iron = new ItemStack(Material.EMERALD, 5);
				ItemStack wood = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				if(p.getInventory().containsAtLeast(iron, 5)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §bDiamond Pickaxe §7for §a5 Emeralds§7.");
				} else {
					p.sendMessage("§cYou don't have enough emeralds!");
				}
			}
			
			if(m == Material.REDSTONE_TORCH_ON) {
				ItemStack iron = new ItemStack(Material.EMERALD, 2);
				ItemStack wood = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
				if(p.getInventory().containsAtLeast(iron, 2)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §cTNT Defuser §7for §a2 Emeralds§7.");
				} else {
					p.sendMessage("§cYou don't have enough emeralds!");
				}
			}
			
			if(m == Material.BOW) {
				ItemStack iron = new ItemStack(Material.IRON_INGOT, 5);
				ItemStack wood = new ItemStack(Material.BOW, 1);
				if(p.getInventory().containsAtLeast(iron, 5)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §fBow §7for §f5 Iron Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough iron!");
				}
			}
			
			if(m == Material.ARROW) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 2);
				ItemStack wood = new ItemStack(Material.ARROW, 8);
				if(p.getInventory().containsAtLeast(iron, 2)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §fArrows §7for §e2 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.SPECTRAL_ARROW) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 25);
				ItemStack wood = new ItemStack(Material.SPECTRAL_ARROW, 3);
				if(p.getInventory().containsAtLeast(iron, 25)) {
					p.getInventory().removeItem(iron);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §eSpectral Arrows §7for §e25 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.TIPPED_ARROW) {
				ItemStack iron = new ItemStack(Material.GOLD_INGOT, 15);
				ItemStack wood = new ItemStack(Material.TIPPED_ARROW, 8);
				if(p.getInventory().containsAtLeast(iron, 15)) {
					p.getInventory().removeItem(iron);
				    PotionMeta meta = ((PotionMeta) wood.getItemMeta());
				    meta.setBasePotionData(new PotionData(PotionType.POISON));
				    wood.setItemMeta(meta);
					p.getInventory().addItem(wood);
					p.sendMessage("§7You purchased §5Poison Arrows §7for §e15 Gold Ingots§7.");
				} else {
					p.sendMessage("§cYou don't have enough gold!");
				}
			}
			
			if(m == Material.DIAMOND_CHESTPLATE) {
				ItemStack iron = new ItemStack(Material.DIAMOND, 25);
				ItemStack cp = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				if(p.getInventory().containsAtLeast(iron, 25)) {
					p.getInventory().removeItem(iron);
					p.getInventory().setChestplate(cp);
					p.getInventory().setLeggings(dl);
					p.sendMessage("§7You purchased §bDiamond Armor §7for §b25 Diamonds§7.");
				} else {
					p.sendMessage("§cYou don't have enough diamonds!");
				}
			}
			
			if(m == Material.CHAINMAIL_CHESTPLATE) {
				ItemStack iron = new ItemStack(Material.DIAMOND, 2);
				ItemStack cp = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				ItemStack dl = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				if(p.getInventory().containsAtLeast(iron, 2)) {
					p.getInventory().removeItem(iron);
					p.getInventory().setChestplate(cp);
					p.getInventory().setLeggings(dl);
					p.sendMessage("§7You purchased §7Chainmail Armor §7for §b2 Diamonds§7.");
				} else {
					p.sendMessage("§cYou don't have enough diamonds!");
				}
			}
			
			if(m == Material.IRON_CHESTPLATE) {
				ItemStack iron = new ItemStack(Material.DIAMOND, 10);
				ItemStack cp = new ItemStack(Material.IRON_CHESTPLATE, 1);
				ItemStack dl = new ItemStack(Material.IRON_LEGGINGS, 1);
				if(p.getInventory().containsAtLeast(iron, 10)) {
					p.getInventory().removeItem(iron);
					p.getInventory().setChestplate(cp);
					p.getInventory().setLeggings(dl);
					p.sendMessage("§7You purchased §fIron Armor §7for §b10 Diamonds§7.");
				} else {
					p.sendMessage("§cYou don't have enough diamonds!");
				}
			}
			
			if(m == Material.IRON_HELMET) {
				ItemStack iron = new ItemStack(Material.DIAMOND, 35);
				ItemStack cp = new ItemStack(Material.IRON_CHESTPLATE, 1);
				cp.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack dl = new ItemStack(Material.IRON_LEGGINGS, 1);
				dl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				if(p.getInventory().containsAtLeast(iron, 35)) {
					p.getInventory().removeItem(iron);
					p.getInventory().setChestplate(cp);
					p.getInventory().setLeggings(dl);
					p.sendMessage("§7You purchased §fIron Armor w/Prot II §7for §b35 Diamonds§7.");
				} else {
					p.sendMessage("§cYou don't have enough diamonds!");
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
