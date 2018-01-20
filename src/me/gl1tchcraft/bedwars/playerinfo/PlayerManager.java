package me.gl1tchcraft.bedwars.playerinfo;

import java.util.UUID;

import org.bukkit.event.Listener;

public class PlayerManager implements Listener {

	private UUID uuid;
	private boolean inGame;
	private int coins;
	private boolean isDead;
	private boolean hasTnt;
	
	public PlayerManager(UUID uuid, boolean inGame, int coins, boolean isDead, boolean hasTnt) {
		this.setUuid(uuid);
		this.setInGame(inGame);
		this.setCoins(coins);
		this.setDead(isDead);
		this.setHasTnt(hasTnt);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isHasTnt() {
		return hasTnt;
	}

	public void setHasTnt(boolean hasTnt) {
		this.hasTnt = hasTnt;
	}
	
	
}
