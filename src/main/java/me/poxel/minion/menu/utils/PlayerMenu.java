package me.poxel.minion.menu.utils;

import org.bukkit.entity.Player;


public class PlayerMenu {


	private Player owner;
	private Player target;

	public PlayerMenu(Player owner) {
		this.owner = owner;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
