package me.gl1tchcraft.bedwars.playerinfo;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.gl1tchcraft.bedwars.Main;
import me.gl1tchcraft.bedwars.gameifno.GameManager;


public class PlayerScoreboard {
	
	public static ScoreboardManager m;
	public static Scoreboard b;
	public static Objective o;
	public static Score gameMode;
	public static Score time;
	public static Score diamonds;
	public static Score emeralds;
	public static Score iron;
	public static Score gold;
	public static Score Redalive;
	public static Score Bluealive;
	public static Score Greenalive;
	public static Score Yellowalive;
	public static Score dead;
	public static Score blank1;
	public static Score blank2;
	public static Score blank3;
	public static Score blank4;
	
	private static Main plugin = Main.getPlugin(Main.class);
	
	public static void scoreGame(Player p, int timeLeft) {
		m = Bukkit.getScoreboardManager();
		b = m.getNewScoreboard();
		o = b.registerNewObjective("tnttag", "");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§c§lGl1tchCraft");
		
		time = o.getScore("§rNext Emerald: §a" + timeLeft + " seconds");
		time.setScore(10);
		
		blank1 = o.getScore(" ");
		blank1.setScore(9);
		
		emeralds = o.getScore("§aEmeralds: §c" + getAmount(p, Material.EMERALD));
		emeralds.setScore(8);
		
		diamonds = o.getScore("§bDiamonds: §c" + getAmount(p, Material.DIAMOND));
		diamonds.setScore(7);
		
		gold = o.getScore("§6Gold: §c" + getAmount(p, Material.GOLD_INGOT));
		gold.setScore(6);
		
		iron = o.getScore("§fIron: §c" + getAmount(p, Material.IRON_INGOT));
		iron.setScore(5);
		
		blank2 = o.getScore("  ");
		blank2.setScore(4);
		
		if(GameManager.greenTeam.getGreenPlayers().size() > 0) {
			Greenalive = o.getScore("§aGreen Team: §a§l\u2713 §7(" + GameManager.greenTeam.getGreenPlayers().size() + ")");
			Greenalive.setScore(3);
		} else {
			Greenalive = o.getScore("§aGreen Team: §c§l\u2718");
			Greenalive.setScore(3);
		}
		
		if(GameManager.blueTeam.getBluePlayers().size() > 0) {
			Bluealive = o.getScore("§bBlue Team: §a§l\u2713 §7(" + GameManager.blueTeam.getBluePlayers().size() + ")");
			Bluealive.setScore(2);
		} else {
			Bluealive = o.getScore("§bBlue Team: §c§l\u2718");
			Bluealive.setScore(2);
		}
		
		if(GameManager.yellowTeam.getYellowPlayers().size() > 0) {
			Yellowalive = o.getScore("§eYellow Team: §a§l\u2713 §7(" + GameManager.yellowTeam.getYellowPlayers().size() + ")");
			Yellowalive.setScore(1);
		} else {
			Yellowalive = o.getScore("§eYellow Team: §c§l\u2718");
			Yellowalive.setScore(1);
		}
		
		if(GameManager.redTeam.getRedPlayers().size() > 0) {
			Redalive = o.getScore("§cRed Team: §a§l\u2713 §7(" + GameManager.redTeam.getRedPlayers().size() + ")");
			Redalive.setScore(0);
		} else {
			Redalive = o.getScore("§cRed Team: §c§l\u2718");
			Redalive.setScore(0);
		}
		
		p.setScoreboard(b);
	}
	
	public static void scoreLobby(Player p) {
		m = Bukkit.getScoreboardManager();
		b = m.getNewScoreboard();
		o = b.registerNewObjective("tnttag", "");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§c§lGl1tchCraft");
		
		time = o.getScore("§aLoading Game...");
		time.setScore(4);
		
		blank1 = o.getScore(" ");
		blank1.setScore(3);
		
		gameMode = o.getScore("§rGame: §cBedWars");
		gameMode.setScore(2);
		
		blank2 = o.getScore("  ");
		blank2.setScore(1);
		
		Redalive = o.getScore("§rPlayers: §c" + plugin.playersInGame.size() + "§r/§c" + plugin.gameManager.playersNeeded);
		Redalive.setScore(0);
		
		p.setScoreboard(b);
	}
	
	public static int getAmount(Player player, Material id)
	{
	        PlayerInventory inventory = player.getInventory();
	        ItemStack[] items = inventory.getContents();
	        int has = 0;
	        for (ItemStack item : items)
	        {
	            if ((item != null) && (item.getType() == id) && (item.getAmount() > 0))
	            {
	                has += item.getAmount();
	            }
	        }
	        return has;
	    }

}
