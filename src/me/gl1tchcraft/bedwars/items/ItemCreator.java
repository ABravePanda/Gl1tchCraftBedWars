package me.gl1tchcraft.bedwars.items;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemCreator {

	public static ItemStack createLeather(Material material, int r, int g, int b, ItemFlag flag) {
		ItemStack item = new ItemStack(material);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		meta.setColor(Color.fromRGB(r, g, b));
		meta.addItemFlags(flag);
		item.setItemMeta(meta);

		return item;
	}
	
	public static ItemStack createItem(Material material, String name, String description, int amount, ItemFlag flag) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(flag);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(description);
		meta.setLore(lore);
		item.setItemMeta(meta);

		return item;
	}
	
	public static ItemStack createShopItem(Material material, String name, String description, int amount) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(description);
		meta.setLore(lore);
		item.setItemMeta(meta);

		return item;
	}
	
	public static ItemStack createAmountItem(Material material, String name, int amount, ItemFlag flag) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.addItemFlags(flag);
		item.setItemMeta(meta);

		return item;
	}
	
	public static ItemStack createGlassItem(Material material, int amount, ItemFlag flag) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(" ");
		meta.addItemFlags(flag);
		item.setItemMeta(meta);

		return item;
	}
	
}
