package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.manager.DataStoreManagement;
import com.falgael.rpg.proficiency.ProficiencyTypes;
import com.falgael.rpg.proficiency.items.CustomBlocks;
import com.falgael.rpg.proficiency.items.CustomTools;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.proficiency.player.PlayerManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockBreakHandler implements Listener {

    private void experienceIncreaseMessage(@NotNull Player player, ProficiencyTypes proficiency) {
        long currentExperience = PlayerManager.getProficiencyData(player.getUniqueId()).getCurrentExperience(proficiency);
        long currentExperienceBorder = PlayerManager.getProficiencyData(player.getUniqueId()).getCurrentExperienceBorder(proficiency);
        TextComponent message = new TextComponent(ChatColor.GOLD + "" + ChatColor.ITALIC + proficiency.getName() + ": " + currentExperience + "/" + currentExperienceBorder + " Xp");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
        Bukkit.getLogger().info(player.getDisplayName() + " has " + currentExperience + " Xp of " + currentExperienceBorder + " from " + proficiency.getName());

        DataStoreManagement.saveProficiencyData();
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        if (block.isNone()) return;

        long experienceAmount = block.getExperienceAmount();
        int droppedBlocks = 0;
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Map<Enchantment,Integer> enchantments = item.getEnchantments();
        enchantments.forEach((e, i) -> item.removeEnchantment(e));

        CustomTools customTools = CustomTools.getItem(item);
        if (!customTools.isNone() && customTools.getProficiencyType() == block.getProficiency()) {
                experienceAmount *= customTools.getItemConfiguration().getExperienceModifier();
                droppedBlocks = customTools.getItemConfiguration().calculateDroppedBlocks();
        }

        if (droppedBlocks != 0) {
            Material toDrop = event.getBlock().getType();
            if (BlockBreak.getBlock(toDrop).hasAlternativeDrop()) {
                toDrop = BlockBreak.getBlock(toDrop).getAlternativeDrop();
            }
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(toDrop, droppedBlocks));
        }

        item.addUnsafeEnchantments(enchantments);

        experienceIncreaseMessage(event.getPlayer(),block.getProficiency());
        PlayerManager.getProficiencyData(event.getPlayer().getUniqueId()).increaseExperience(block.getProficiency(),experienceAmount);


    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (CustomTools customTools : CustomTools.values()) {
            event.getPlayer().getInventory().addItem(customTools.getItem());
        }

        for (CustomBlocks customBlocks : CustomBlocks.values()) {
            event.getPlayer().getInventory().addItem(customBlocks.getItem());
        }



    }

}
