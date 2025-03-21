package me.poxel6.mininion.minion;

import org.bukkit.entity.Player;


public interface Ownable {


	void setOwner(Player owner);

	void getOwner(Player owner);
}