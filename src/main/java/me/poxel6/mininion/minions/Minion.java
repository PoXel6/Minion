package me.poxel6.mininion.minions;

import me.poxel6.mininion.Mininion;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

public abstract class Minion {
  private static final String MINION_METADATA_KEY = "isMinion";
  @NotNull private final Player owner;
  private final ArmorStand minion;

  protected Minion(@NotNull Player owner) {
    this.owner = owner;
    var location = getPlayerLocation(owner);
    minion = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

    minion.setCustomName("Mininion");
    minion.setCustomNameVisible(true);
    minion.setSmall(true);
    minion.setGravity(false);
    minion.setInvulnerable(true);
    minion.setArms(true);

    // get these from the config file or something
    minion.getEquipment().setHelmet(new ItemStack(Material.PLAYER_HEAD));
    minion.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
    minion.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
    minion.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));

    minion.setMetadata(MINION_METADATA_KEY, new FixedMetadataValue(Mininion.getInstance(), true));
  }

  private Location getPlayerLocation(@NotNull Player player) {
    return new Location(
        player.getWorld(),
        player.getLocation().getX(),
        player.getLocation().getY(),
        player.getLocation().getZ());
  }
}
