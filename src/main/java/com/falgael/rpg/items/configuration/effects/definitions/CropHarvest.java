package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.definitions.stats.BlockStats;
import com.falgael.rpg.items.configuration.effects.Action;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CropHarvest extends Action {

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyAdapter) {
        if (!(e instanceof BlockBreakEvent event)) return false;

        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
        if (block.isNone()) return false;

        // special crops
        if (block.specialHarvest()) {
            if (event.getBlock().getRelative(BlockFace.DOWN).getType() == event.getBlock().getType()) return false;
            event.setCancelled(true);
        }
        // ageable crop
        if (!block.ageable() || !(event.getBlock().getBlockData() instanceof Ageable cropAge)) return false;

        event.setCancelled(true);
        if (cropAge.getAge() != cropAge.getMaximumAge()) return true;

        proficiencyAdapter.calculateExperience(event.getPlayer(), block.getProficiencies(), block.getExperienceAmount());
        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        dropItem(drops, ++droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        if (event.getPlayer().getInventory().contains(event.getBlock().getBlockData().getPlacementMaterial(),1)) {
            int slot = event.getPlayer().getInventory().first(event.getBlock().getBlockData().getPlacementMaterial());
            if (event.getPlayer().getInventory().getItem(slot).getAmount() != 1) event.getPlayer().getInventory().getItem(slot).setAmount(event.getPlayer().getInventory().getItem(slot).getAmount() - 1);
            else event.getPlayer().getInventory().remove(event.getPlayer().getInventory().getItem(slot));
            StructureRotation rotation = getSurroundedJungleLog(event.getBlock());
            event.getBlock().setType(block.getMaterial());
            if (rotation != StructureRotation.NONE) {
                BlockData blockData = event.getBlock().getBlockData();
                blockData.rotate(rotation);
                event.getBlock().setBlockData(blockData);
            }
        } else {
            event.getBlock().setType(Material.AIR);
        }
        return true;
    }


    private StructureRotation getSurroundedJungleLog(Block target) {
        if (getSurroundedJungleLog(target, BlockFace.EAST)) return StructureRotation.CLOCKWISE_90;
        if (getSurroundedJungleLog(target,BlockFace.SOUTH)) return StructureRotation.CLOCKWISE_180;
        if (getSurroundedJungleLog(target, BlockFace.WEST)) return StructureRotation.COUNTERCLOCKWISE_90;
        return StructureRotation.NONE;
    }

    private boolean getSurroundedJungleLog(Block target, BlockFace blockFace) {
        if (target == null || blockFace == null) return false;
        return target.getRelative(blockFace).getType() == Material.JUNGLE_LOG
                || target.getRelative(blockFace).getType() == Material.JUNGLE_WOOD;
    }


}
