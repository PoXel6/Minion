package me.poxel.mininion.minion;

import org.bukkit.entity.Player;


public interface Ownable {


	void setOwner(Player owner);

	void getOwner(Player owner);
}