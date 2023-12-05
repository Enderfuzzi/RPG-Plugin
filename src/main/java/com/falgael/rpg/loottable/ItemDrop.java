package com.falgael.rpg.loottable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ItemDrop {

    default void dropItem(List<ItemStack> drops, int dropAmount, World world, Location location) {
        if (dropAmount < 1) return;
        if (drops.isEmpty()) return;
        if (world == null || location == null) return;

        for (ItemStack itemStack : drops) {
            if (itemStack.getType() == Material.AIR) continue;
            if (itemStack.getAmount() <= 0) continue;
            int tmpAmount = dropAmount;
            while (tmpAmount - 64 > 0) {
                world.dropItemNaturally(location,new ItemStack(itemStack.getType(), 64));
                tmpAmount -= 64;
            }
            world.dropItemNaturally(location, new ItemStack(itemStack.getType(), tmpAmount));
        }
    }

    default void dropItem(List<ItemStack> drops, int dropAmount, Player player) {
        dropItem(drops, dropAmount, player, player.getLocation());
    }

    default void dropItem(List<ItemStack> drops, int dropAmount, Player player, Location location) {
        dropItem(drops, dropAmount, player.getWorld(), location);
    }


    default void dropItem(ItemStack drop, int dropAmount, World world, Location location) {
        dropItem(List.of(drop), dropAmount, world, location);
    }

    default void dropItem(ItemStack drop, int dropAmount, Player player) {
        dropItem(drop, dropAmount, player, player.getLocation());
    }

    default void dropItem(ItemStack drop, int dropAmount, Player player, Location location) {
        dropItem(drop, dropAmount, player.getWorld(), location);
    }

}
