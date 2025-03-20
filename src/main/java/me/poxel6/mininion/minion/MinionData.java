package me.poxel6.mininion.minion;

import me.poxel6.mininion.Mininion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;


public abstract class MinionData {


	private static final String MINION_METADATA_KEY = "isMinion";
	private static final Mininion PLUGIN = Mininion.getInstance();
	private final ArmorStand minion;

	protected MinionData(Player owner) {
		minion = getArmorStand(getPlayerLocation(owner));
		minion.setMetadata(MINION_METADATA_KEY, new FixedMetadataValue(Mininion.getInstance(), true));
		minion.setCustomName(PLUGIN.getConfig().getString("GENERAL.DISPLAY_NAME", "Minion"));
		minion.setCustomNameVisible(true);
		minion.setSmall(true);
		minion.setGravity(false);
		minion.setInvulnerable(true);
		minion.setArms(true);
		setEquipment();
	}

	@NotNull
	private ArmorStand getArmorStand(@NotNull Location location) {
		if (location.getWorld() == null) {
			throw new IllegalArgumentException("World cannot be Null!");
		}
		return (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
	}

	private Player getHeadConfig(String pathToHead) {
		return Bukkit.getPlayer(PLUGIN.getConfig().getString(pathToHead));
		//    return PLUGIN.getConfig().getOfflinePlayer("APPEARANCE.HEAD").getPlayer();
	}

	@NotNull
	private ItemStack getChestplateConfig(String pathToChestplate) {
		return new ItemStack(
				Material.matchMaterial(
						PLUGIN.getConfig().getString(pathToChestplate, "LEATHER_CHESTPLATE")));
	}

	@NotNull
	private ItemStack getLeggingsConfig(String pathToLeggings) {
		return new ItemStack(
				Material.matchMaterial(PLUGIN.getConfig().getString(pathToLeggings, "LEATHER_LEGGINGS")));
	}

	@NotNull
	private ItemStack getBootsConfig(String pathToBoots) {
		var boots = Material.matchMaterial(PLUGIN.getConfig().getString(pathToBoots, "LEATHER_BOOTS"));
		if (boots == null) {
			return new ItemStack(Material.LEATHER_BOOTS);
		}
		return new ItemStack(boots);
	}

	private void setEquipment() {
		var equipment = minion.getEquipment();
		if (equipment == null) {
		}
		// TODO: Fix this.
		//    equipment.setHelmet(setHeadSkin(getHeadConfig("APPEARANCE.HEAD")));
		//    equipment.setChestplate(getChestplateConfig("APPEARANCE.CHESTPLATE"));
		//    equipment.setLeggings(getLeggingsConfig("APPEARANCE.LEGGINGS"));
		//    equipment.setBoots(getBootsConfig("APPEARANCE.BOOTS"));
	}

	private Location getPlayerLocation(@NotNull Player player) {
		return new Location(
				player.getWorld(),
				player.getLocation().getX(),
				player.getLocation().getY(),
				player.getLocation().getZ());
	}

	@NotNull
	private ItemStack setHeadSkin(Player player) {
		var itemStack = new ItemStack(Material.PLAYER_HEAD);
		var skullMeta = (SkullMeta) itemStack.getItemMeta();
		skullMeta.setOwningPlayer(player);
		itemStack.setItemMeta(skullMeta);
		return itemStack;
	}
}
