package me.poxel6.mininion.minions;

import org.bukkit.entity.Player;

public interface Minion {
    void setOwner(Player owner);

    void getOwner(Player owner);

    boolean needFuel();

    void spawnMinion();

    void pickUp();
}