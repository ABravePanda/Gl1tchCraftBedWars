package me.gl1tchcraft.bedwars.teaminfo;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeamManager {
	
	private int maxPlayers;
	private Color color;
	private String name;
	private Location spawnLocation;
	private boolean hasBed;
	public static ArrayList<Player> redPlayers = new ArrayList<Player>();
	public static ArrayList<Player> bluePlayers = new ArrayList<Player>();
	public static ArrayList<Player> greenPlayers = new ArrayList<Player>();
	public static ArrayList<Player> yellowPlayers = new ArrayList<Player>();
	private Player p;
	
	public TeamManager(int maxPlayers, Color color, String name, Location spawnLocation, boolean hasBed) {
		this.setMaxPlayers(maxPlayers);
		this.setColor(color);
		this.setName(name);
		this.setSpawnLocation(spawnLocation);
		this.setHasBed(hasBed);
		
	}
	
	public String getTeam(Player p) {
		if(redPlayers.contains(p)) {
			return "Red";
		}
		if(bluePlayers.contains(p)) {
			return "Blue";
		}
		if(greenPlayers.contains(p)) {
			return "Green";
		}
		if(yellowPlayers.contains(p)) {
			return "Yellow";
		}
		return null;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getSpawnLocation() {
		return spawnLocation;
	}

	public void setSpawnLocation(Location spawnLocation) {
		this.spawnLocation = spawnLocation;
	}

	public boolean isHasBed() {
		return hasBed;
	}

	public void setHasBed(boolean hasBed) {
		this.hasBed = hasBed;
	}

	//ALL LISTS (RED)
	public void addRedPlayer(Player p) {
		redPlayers.add(p);
	}
	
	public void removeRedPlayer(Player p) {
		redPlayers.remove(p);
	}
	
	public void removeRedPlayers() {
		redPlayers.clear();
	}
	
	public ArrayList<Player> getRedPlayers() {
		return redPlayers;
	}
	
	public void setRedPlayers(ArrayList<Player> p) {
		TeamManager.redPlayers = p;
	}
	
	//ALL LISTS (YELLOW)
	public void addYellowPlayer(Player p) {
		yellowPlayers.add(p);
	}
	
	public void removeYellowPlayer(Player p) {
		yellowPlayers.remove(p);
	}
	
	public void removeYellowPlayers() {
		yellowPlayers.clear();
	}
	
	public ArrayList<Player> getYellowPlayers() {
		return yellowPlayers;
	}
	
	public void setYellowPlayers(ArrayList<Player> p) {
		TeamManager.yellowPlayers = p;
	}
	
	//ALL LISTS (Green)
	public void addGreenPlayer(Player p) {
		greenPlayers.add(p);
	}
	
	public void removeGreenPlayer(Player p) {
		greenPlayers.remove(p);
	}
	
	public void removeGreenPlayers() {
		greenPlayers.clear();
	}
	
	public ArrayList<Player> getGreenPlayers() {
		return greenPlayers;
	}
	
	public void setGreenPlayers(ArrayList<Player> p) {
		TeamManager.greenPlayers = p;
	}
	
	//ALL LISTS (BLUE)
	public void addBluePlayer(Player p) {
		bluePlayers.add(p);
	}
	
	public void removeBluePlayer(Player p) {
		bluePlayers.remove(p);
	}
	
	public void removeBluePlayers() {
		bluePlayers.clear();
	}
	
	public ArrayList<Player> getBluePlayers() {
		return bluePlayers;
	}
	
	public void setBluePlayers(ArrayList<Player> p) {
		TeamManager.bluePlayers = p;
	}


}
