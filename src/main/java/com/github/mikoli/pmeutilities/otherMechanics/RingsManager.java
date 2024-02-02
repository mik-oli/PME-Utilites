package com.github.mikoli.pmeutilities.otherMechanics;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IRing;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class RingsManager {

    private final PMEUtilities plugin;
    private final HashMap<Player, IRing> playersWithRing = new HashMap<>();

    public RingsManager(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    public boolean isItemRing(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;
        if (!meta.hasCustomModelData()) return false;

        for (ICustomItem customItem : CustomItemsUtils.getCustomRings()) {
            if (customItem.getDataModelId() == meta.getCustomModelData()) return true;
        }
        return false;
    }

    public IRing getRingFromItem(ItemStack item) {
        ItemMeta meta = item.getItemMeta();

        for (ICustomItem ring : CustomItemsUtils.getCustomRings()) {
            if (meta.getCustomModelData() == ring.getDataModelId()) {
                return (IRing) ring;
            }
        }
        return null;
    }

    public boolean hasPlayerRing(Player player) {
        return playersWithRing.containsKey(player) ;
    }

    public void addPlayerRing(Player player, IRing ring) {
        playersWithRing.put(player, ring);
    }

    public void removePlayerRing(Player player) {
        playersWithRing.remove(player);
    }

    public void playerAddEffect(Player player, IRing ring) {
        for (int i = 0; i < ring.getPotionEffectsTypes().length; i++)
            player.addPotionEffect(ring.getPotionEffectsTypes()[i].createEffect(PotionEffect.INFINITE_DURATION, ring.getEffectsStrength()[i]));
    }

    public void playerRemoveEffect(Player player, IRing ring) {
        for (int i = 0; i < ring.getPotionEffectsTypes().length; i++)
            player.removePotionEffect(ring.getPotionEffectsTypes()[i]);
    }

    public void runTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : playersWithRing.keySet()) {
                    if (!player.isOnline()) continue;
                    ItemStack item = player.getInventory().getItemInOffHand();
                    if (!isItemRing(item)) {
                        removePlayerRing(player);
                        for (PotionEffect effect : player.getActivePotionEffects()) {
                            if (effect.getDuration() == PotionEffect.INFINITE_DURATION) {
                                player.removePotionEffect(effect.getType());
                            }
                        }
                    } else if (isItemRing(item)) {
                        playerAddEffect(player, playersWithRing.get(player));
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 100L);
    }
}
