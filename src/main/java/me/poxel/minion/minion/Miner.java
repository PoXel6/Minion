package me.poxel.minion.minion;

import java.util.List;


public interface Miner extends MinionStorage {


	void getBlocksInRange();

	void setWhitelist(List list);

	void setBlacklist(List list);
}
