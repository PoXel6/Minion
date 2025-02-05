package me.poxel6.mininion.minions;

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

public abstract class Minion {
  private static final String MINION_METADATA_KEY = "isMinion";
  private static final Mininion PLUGIN = Mininion.getInstance();
  private final ArmorStand minion;

  protected Minion(Player owner) {
    minion = createMinion(getPlayerLocation(owner));
    setCustomName(PLUGIN.getConfig().getString("GENERAL.DISPLAY_NAME", "Minion"), true);
    setSmall(true);
    setGravity(false);
    setInvulnerable(true);
    setArms(true);
    setEquipment(true);

    minion.setMetadata(MINION_METADATA_KEY, new FixedMetadataValue(Mininion.getInstance(), true));
  }

  @NotNull
  private static ArmorStand createMinion(@NotNull Location location) {
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

  private void setArms(boolean b) {
    minion.setArms(b);
  }

  private void setInvulnerable(boolean b) {
    minion.setInvulnerable(b);
  }

  private void setGravity(boolean b) {
    minion.setGravity(b);
  }

  private void setSmall(boolean b) {
    minion.setSmall(b);
  }

  private void setEquipment(boolean b) {
    var equipment = minion.getEquipment();
    if (equipment == null) {
      return;
    }
    if (b) {
      //      equipment.setHelmet(setHeadSkin(getHeadConfig("APPEARANCE.HEAD")));
      equipment.setHelmet(setHeadSkin(getHeadConfig("APPEARANCE.HEAD")));
      equipment.setChestplate(getChestplateConfig("APPEARANCE.CHESTPLATE"));
      equipment.setLeggings(getLeggingsConfig("APPEARANCE.LEGGINGS"));
      equipment.setBoots(getBootsConfig("APPEARANCE.BOOTS"));
    }
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

  private void setCustomName(String customName, Boolean visibility) {
    minion.setCustomName(customName);
    minion.setCustomNameVisible(visibility);
  }
}
