package com.falgael.rpg.proficiency.items.effects;

import org.bukkit.event.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CropPlant {

    public static boolean effect(Event e, int radius, Material toPlace, Material toPlaceOn) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (event.getClickedBlock().getType() != Material.FARMLAND) return false;
        Location location = event.getClickedBlock().getLocation();
        Player player = event.getPlayer();


        ArrayList<Location> candidates = new ArrayList<>();

        location.subtract(Math.floor(radius / 2),0,Math.floor(radius / 2));

        location.add(0,1,0);

        for (int j = 0; j < radius; j++) {
            for (int i = 0; i< radius; i++) {
                if (location.getBlock().getType() == Material.AIR && location.getBlock().getRelative(BlockFace.DOWN).getType() == toPlaceOn) candidates.add(location.clone());
                location.add(0,0,1);
            }
            location.subtract(0,0,radius);
            location.add(1,0,0);
        }

        HashMap<Integer, ? extends ItemStack> playerItems = player.getInventory().all(toPlace.createBlockData().getPlacementMaterial());
        if (playerItems.isEmpty()) return false;

        int amountToPlace = candidates.size();
        ArrayList<Integer> indexToRemove = new ArrayList<>();
        for (Map.Entry<Integer, ? extends ItemStack> entry : playerItems.entrySet()) {
            if (entry == null) continue;
            if (amountToPlace < entry.getValue().getAmount()) {
                player.getInventory().getItem(entry.getKey()).setAmount(entry.getValue().getAmount() - amountToPlace);
                amountToPlace = 0;
                break;
            } else if (amountToPlace - entry.getValue().getAmount() == 0) {
                indexToRemove.add(entry.getKey());
                amountToPlace = 0;
                break;
            }
            amountToPlace -= entry.getValue().getAmount();
            indexToRemove.add(entry.getKey());
        }
        if (amountToPlace > 0) return false;

        playerItems.keySet().removeIf(indexToRemove::contains);


        for (Location loc : candidates) loc.getBlock().setType(toPlace);
        return true;
    }
}
