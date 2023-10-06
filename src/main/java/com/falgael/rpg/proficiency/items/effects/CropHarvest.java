package com.falgael.rpg.proficiency.items.effects;

import com.falgael.rpg.proficiency.blocks.BlockBreak;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.tmp.Calculation;
import com.falgael.rpg.tmp.CustomItem;
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

public class CropHarvest {

    public static boolean effect(Event e) {
        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        CustomItem customItem = CustomItem.getItem(event.getPlayer().getInventory().getItemInMainHand());
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

        long experienceAmount = Calculation.calculateExperience(block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = Calculation.calculateLoot(block.getProficiency(), event.getPlayer());

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        Calculation.dropAdditionalLoot(drops, ++droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

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


    private static StructureRotation getSurroundedJungleLog(Block target) {
        if (getSurroundedJungleLog(target, BlockFace.EAST)) return StructureRotation.CLOCKWISE_90;
        if (getSurroundedJungleLog(target,BlockFace.SOUTH)) return StructureRotation.CLOCKWISE_180;
        if (getSurroundedJungleLog(target, BlockFace.WEST)) return StructureRotation.COUNTERCLOCKWISE_90;
        return StructureRotation.NONE;
    }

    private static boolean getSurroundedJungleLog(Block target, BlockFace blockFace) {
        if (target == null || blockFace == null) return false;
        return target.getRelative(blockFace).getType() == Material.JUNGLE_LOG || target.getRelative(blockFace).getType() == Material.JUNGLE_WOOD;
    }
}
