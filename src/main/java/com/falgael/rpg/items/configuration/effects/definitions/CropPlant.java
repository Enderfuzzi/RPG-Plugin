package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.items.configuration.effects.IntAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CropPlant extends IntAction {

    private final Material toPlace;
    private final Material toPlaceOn;
    
    
    public CropPlant(int value, Material toPlace, Material toPlaceOn) {
        super(value);
        this.toPlace = toPlace;
        this.toPlaceOn = toPlaceOn;
    }

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (event.getClickedBlock().getType() != Material.FARMLAND) return false;
        Location location = event.getClickedBlock().getLocation();
        Player player = event.getPlayer();
        ArrayList<Location> candidates = new ArrayList<>();
        location.subtract(Math.floor(value / 2),0,Math.floor(value / 2));
        location.add(0,1,0);
        for (int j = 0; j < value; j++) {
            for (int i = 0; i< value; i++) {
                if (location.getBlock().getType() == Material.AIR
                        && location.getBlock().getRelative(BlockFace.DOWN).getType() == toPlaceOn) {
                    candidates.add(location.clone());
                }
                location.add(0,0,1);
            }
            location.subtract(0,0,value);
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