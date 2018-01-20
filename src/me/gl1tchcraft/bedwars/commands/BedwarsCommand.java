package me.gl1tchcraft.bedwars.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import me.gl1tchcraft.bedwars.Main;
import me.gl1tchcraft.bedwars.gameifno.GameManager;
import me.gl1tchcraft.bedwars.inventory.InventoryManager;
import me.gl1tchcraft.bedwars.items.ItemCreator;
import net.md_5.bungee.api.ChatColor;

public class BedwarsCommand implements CommandExecutor {
	
	
    public String getArgs(String[] args, int num) { //You can use a method if you want
        StringBuilder sb = new StringBuilder(); //We make a String Builder
        for (int i = num; i < args.length; i++) { //We get all the arguments with a for loop
            sb.append(args[i]).append(" "); //We add the argument and the space
        }
        return sb.toString().trim(); //We return the message
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Main plugin = Main.getPlugin(Main.class);

        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("global")) {
            	String m = getArgs(args, 0);
        		if(plugin.gameManager.isStarted == true) {
        			if(plugin.playersInGame.contains(p)) {
        				if(GameManager.redTeam.getRedPlayers().contains(p)) {
        					for(Player ps : Bukkit.getOnlinePlayers()) {
        						ps.sendMessage("§9[GLOBAL] §c[RED] " + p.getName() + ":§7 " + m);
        					}
        				}
        				if(GameManager.greenTeam.getGreenPlayers().contains(p)) {
        					for(Player ps : Bukkit.getOnlinePlayers()) {
        						ps.sendMessage("§9[GLOBAL] §a[GREEN] " + p.getName() + ":§7 " + m);
        					}
        				}
        				if(GameManager.yellowTeam.getYellowPlayers().contains(p)) {
        					for(Player ps : Bukkit.getOnlinePlayers()) {
        						ps.sendMessage("§9[GLOBAL] §e[YELLOW] " + p.getName() + ":§7 " + m);
        					}
        				}
        				if(GameManager.blueTeam.getBluePlayers().contains(p)) {
        					for(Player ps : Bukkit.getOnlinePlayers()) {
        						ps.sendMessage("§9[GLOBAL] §b[BLUE] " + p.getName() + ":§7 " + m);
        					}
        				}
        			} else {
        				
        			}
        			
        			
        			
        		}
            }
            
            
            if(cmd.getName().equalsIgnoreCase("bedwars")) {
            	if(args.length > 0) {
            		if(args[0].equalsIgnoreCase("debug")) {
            			ItemStack fireball = ItemCreator.createItem(Material.FIREBALL, ChatColor.DARK_RED + "Fireball", ChatColor.GRAY + "Right click for a boom!", 1, ItemFlag.HIDE_ATTRIBUTES);
            			p.getInventory().addItem(fireball);
            			Entity villager = p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            			villager.setCustomName(ChatColor.RED + "Item Shop");
            			villager.setCustomNameVisible(true);
            			InventoryManager.setupInv(ChatColor.RED + "Personal Items", p);
            		}
            		if(args[0].equalsIgnoreCase("setup")) {
            			if(p.hasPermission("setup.bedwars.gl1tchcraft")) {
            				if(args[1].equalsIgnoreCase("redspawn")) {
            					plugin.getConfig().set("RedSpawn.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("RedSpawn.X", p.getLocation().getX());
            					plugin.getConfig().set("RedSpawn.Y", p.getLocation().getY());
            					plugin.getConfig().set("RedSpawn.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§cRed Spawn§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("greenspawn")) {
            					plugin.getConfig().set("GreenSpawn.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("GreenSpawn.X", p.getLocation().getX());
            					plugin.getConfig().set("GreenSpawn.Y", p.getLocation().getY());
            					plugin.getConfig().set("GreenSpawn.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§aGreen Spawn§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("yellowspawn")) {
            					plugin.getConfig().set("YellowSpawn.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("YellowSpawn.X", p.getLocation().getX());
            					plugin.getConfig().set("YellowSpawn.Y", p.getLocation().getY());
            					plugin.getConfig().set("YellowSpawn.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§eYellow Spawn§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("bluespawn")) {
            					plugin.getConfig().set("BlueSpawn.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("BlueSpawn.X", p.getLocation().getX());
            					plugin.getConfig().set("BlueSpawn.Y", p.getLocation().getY());
            					plugin.getConfig().set("BlueSpawn.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bBlue Spawn§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("lobbyspawn")) {
            					plugin.getConfig().set("LobbySpawn.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("LobbySpawn.X", p.getLocation().getX());
            					plugin.getConfig().set("LobbySpawn.Y", p.getLocation().getY());
            					plugin.getConfig().set("LobbySpawn.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§dLobby Spawn§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("emeralddropper")) {
            					plugin.getConfig().set("EmeraldDropper.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("EmeraldDropper.X", p.getLocation().getX());
            					plugin.getConfig().set("EmeraldDropper.Y", p.getLocation().getY() + 1);
            					plugin.getConfig().set("EmeraldDropper.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§aEmerald Dropper§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("diamonddropper1")) {
            					plugin.getConfig().set("DiamondDropper1.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("DiamondDropper1.X", p.getLocation().getX());
            					plugin.getConfig().set("DiamondDropper1.Y", p.getLocation().getY() + 1);
            					plugin.getConfig().set("DiamondDropper1.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bDiamond Dropper 1§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("diamonddropper2")) {
            					plugin.getConfig().set("DiamondDropper2.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("DiamondDropper2.X", p.getLocation().getX());
            					plugin.getConfig().set("DiamondDropper2.Y", p.getLocation().getY() + 1);
            					plugin.getConfig().set("DiamondDropper2.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bDiamond Dropper 2§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("diamonddropper3")) {
            					plugin.getConfig().set("DiamondDropper3.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("DiamondDropper3.X", p.getLocation().getX());
            					plugin.getConfig().set("DiamondDropper3.Y", p.getLocation().getY() + 1);
            					plugin.getConfig().set("DiamondDropper3.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bDiamond Dropper 3§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("diamonddropper4")) {
            					plugin.getConfig().set("DiamondDropper4.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("DiamondDropper4.X", p.getLocation().getX());
            					plugin.getConfig().set("DiamondDropper4.Y", p.getLocation().getY() + 1);
            					plugin.getConfig().set("DiamondDropper4.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bDiamond Dropper 4§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("diamondtimer")) {
            					plugin.getConfig().set("DiamondTimer", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§bDiamond Timer §7set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("emeraldTimer")) {
            					plugin.getConfig().set("EmeraldTimer", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§aEmerald Timer §7set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("irontimer")) {
            					plugin.getConfig().set("IronTimer", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§fIron Timer §7set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("goldtimer")) {
            					plugin.getConfig().set("GoldTimer", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§6Gold Timer §7set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("lobbytimer")) {
            					plugin.getConfig().set("LobbyTimer", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§dLobby Timer §7set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("minplayers")) {
            					plugin.getConfig().set("MinPlayers", Integer.parseInt(args[2]));
            					plugin.saveConfig();
            					p.sendMessage("§dPlayers Need§7 set to " + args[2]);
            				}
            				if(args[1].equalsIgnoreCase("redvillager")) {
            					plugin.getConfig().set("RedVillager.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("RedVillager.X", p.getLocation().getX());
            					plugin.getConfig().set("RedVillager.Y", p.getLocation().getY());
            					plugin.getConfig().set("RedVillager.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§cRed Villager§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("bluevillager")) {
            					plugin.getConfig().set("BlueVillager.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("BlueVillager.X", p.getLocation().getX());
            					plugin.getConfig().set("BlueVillager.Y", p.getLocation().getY());
            					plugin.getConfig().set("BlueVillager.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§bBlue Villager§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("yellowvillager")) {
            					plugin.getConfig().set("YellowVillager.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("YellowVillager.X", p.getLocation().getX());
            					plugin.getConfig().set("YellowVillager.Y", p.getLocation().getY());
            					plugin.getConfig().set("YellowVillager.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§eYellow Villager§7 setup.");
            				}
            				if(args[1].equalsIgnoreCase("greenvillager")) {
            					plugin.getConfig().set("GreenVillager.World", p.getLocation().getWorld().getName());
            					plugin.getConfig().set("GreenVillager.X", p.getLocation().getX());
            					plugin.getConfig().set("GreenVillager.Y", p.getLocation().getY());
            					plugin.getConfig().set("GreenVillager.Z", p.getLocation().getZ());
            					plugin.saveConfig();
            					p.sendMessage("§aGreen Villager§7 setup.");
            				}
            			} else {
            				p.sendMessage("§cYou don't have permission to do that!");
            			}
            		}
            		if(args[0].equalsIgnoreCase("team")) {
            			if(p.hasPermission("team.bedwars.gl1tchcraft")) {
            				if(plugin.gameManager.isStarted() == false) {
	            				Player ps = Bukkit.getPlayer(args[2]);
	            				if(ps == null) {
	            					p.sendMessage(ChatColor.RED + "Can't find " + args[2]);
	            					return true;
	            				}
	            				if(args[1].equalsIgnoreCase("red")) {
	            					GameManager.blueTeam.removeBluePlayer(p);
	            					GameManager.yellowTeam.removeYellowPlayer(p);
	            					GameManager.greenTeam.removeGreenPlayer(p);
	            					GameManager.redTeam.removeRedPlayer(p);
	            					GameManager.redTeam.addRedPlayer(p);
	            					ps.sendMessage("§cYou have been assigned to the red team.");
	            					p.sendMessage("§c" + ps.getName() + " has been assigned to the red team.");
	            				}
	            				if(args[1].equalsIgnoreCase("blue")) {
	            					GameManager.blueTeam.removeBluePlayer(p);
	            					GameManager.yellowTeam.removeYellowPlayer(p);
	            					GameManager.greenTeam.removeGreenPlayer(p);
	            					GameManager.redTeam.removeRedPlayer(p);
	            					GameManager.blueTeam.addBluePlayer(p);
	            					ps.sendMessage("§bYou have been assigned to the blue team.");
	            					p.sendMessage("§b" + ps.getName() + " has been assigned to the blue team.");
	            				}
	            				if(args[1].equalsIgnoreCase("yellow")) {
	            					GameManager.blueTeam.removeBluePlayer(p);
	            					GameManager.yellowTeam.removeYellowPlayer(p);
	            					GameManager.greenTeam.removeGreenPlayer(p);
	            					GameManager.redTeam.removeRedPlayer(p);
	            					GameManager.yellowTeam.addYellowPlayer(p);
	            					ps.sendMessage("§eYou have been assigned to the yellow team.");
	            					p.sendMessage("§e" + ps.getName() + " has been assigned to the yellow team.");
	            				}
	            				if(args[1].equalsIgnoreCase("green")) {
	            					GameManager.blueTeam.removeBluePlayer(p);
	            					GameManager.yellowTeam.removeYellowPlayer(p);
	            					GameManager.greenTeam.removeGreenPlayer(p);
	            					GameManager.redTeam.removeRedPlayer(p);
	            					GameManager.greenTeam.addGreenPlayer(p);
	            					ps.sendMessage("§aYou have been assigned to the green team.");
	            					p.sendMessage("§a" + ps.getName() + " has been assigned to the green team.");
	            				}
	            			} else {
	            				p.sendMessage("§cThe Game has already started!");
	            			}
            			}else {
            				p.sendMessage("§cYou don't have permission to do that!");
            			}
            		}
            		
            	} else {
            		p.sendMessage("§cIncorrect Arguments. Try /bedwars team,setup");
            	}
            }
            
        }
        return true;
	}

}
