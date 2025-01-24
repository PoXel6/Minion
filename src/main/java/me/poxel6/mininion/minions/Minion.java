package me.poxel6.mininion.minions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class Minion implements ArmorStand {
  @NotNull private final Player owner;

  Minion(@NotNull Player owner) {
    this.owner = owner;

    var location = getPlayerLocation(owner);
    var armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

    armorStand.setSmall(true);
    armorStand.setGravity(false);
    armorStand.setCustomName("Mininions");
    armorStand.setInvulnerable(true);
    armorStand.setArms(true);

    armorStand.getEquipment().setHelmet(new ItemStack(Material.PLAYER_HEAD));
    armorStand.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
    armorStand.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
    armorStand.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
  }

  private Location getPlayerLocation(@NotNull Player player) {
    return new Location(
        player.getWorld(),
        player.getLocation().getX(),
        player.getLocation().getY(),
        player.getLocation().getZ());
  }
}
