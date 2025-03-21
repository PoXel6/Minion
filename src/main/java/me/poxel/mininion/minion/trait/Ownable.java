package me.poxel.mininion.minion.trait;

import org.bukkit.entity.Player;


public interface Ownable {


	void setOwner(Player owner);

	void getOwner(Player owner);
}