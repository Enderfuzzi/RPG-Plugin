package com.falgael.rpg.experience;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Manages the experience of all Players
 * @author falgael
 * @version 0.0.1
 */
public class ExperienceHandler implements Listener {

    /** Assigns Experience data to each player */
    private static HashMap<Player,ExperienceData> experiences = new HashMap<>();

    private void experienceIncreaseMessage(@NotNull Player player, String proficiencyRepresentation, int currentExperience, int currentExperienceBorder) {
        TextComponent message = new TextComponent(ChatColor.GOLD + "" + ChatColor.ITALIC + proficiencyRepresentation + ": " + currentExperience + "/" + currentExperienceBorder + " Xp");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
        Bukkit.getLogger().info(player.getDisplayName() + " has " + currentExperience + " Xp of " + currentExperienceBorder + " from " + proficiencyRepresentation);
    }


    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        if (!experiences.containsKey(event.getPlayer())) {
            experiences.put(event.getPlayer(), new ExperienceData());
        }
    }

    /**
     * Searches each block break experience of a player when destroying a block
     * @param event describes the {@code BlockBreakEvent}
     */
    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent event) {
        for (ExperienceFramework ef : experiences.get(event.getPlayer()).getBlockBreakProficiency()) {
            if (ef.givesBlockBreakingExperience(event.getBlock())) {
                ef.increaseExperience(ef.amountBlockBreakingExperience(event.getBlock()));
                experienceIncreaseMessage(event.getPlayer(),ef.getProficiencyRepresentation(),ef.getCurrentExperience(),ef.getCurrentExperienceBorder());
                return;
            }
        }
    }
    @EventHandler
    public void onCraft(@NotNull CraftItemEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        Bukkit.getLogger().info("Crafting result name: " + event.getCurrentItem().getType().toString());
        Bukkit.getLogger().info("Size of crafting: " + event.getCurrentItem().getAmount());


        for (ExperienceFramework ef : experiences.get(player).getBlockBreakProficiency()) {
            if (ef.givesBlockCraftingExperience(event.getCurrentItem().getType(),event.getInventory())) {

                int craftedAmount = 1;

                if (event.isShiftClick()) {
                    for (ItemStack is : event.getInventory().getMatrix()) {
                        if (is == null) continue;
                        if (craftedAmount == 1 || (is.getAmount() > 0 && is.getAmount() <= craftedAmount)) {
                            craftedAmount = is.getAmount();
                        }
                    }
                    Bukkit.getLogger().info("Amount to craft: " + craftedAmount);
                }

                ef.increaseExperience(ef.amountBlockCraftingExperience(event.getCurrentItem().getType()) * event.getCurrentItem().getAmount() * craftedAmount);
                experienceIncreaseMessage(player,ef.getProficiencyRepresentation(),ef.getCurrentExperience(),ef.getCurrentExperienceBorder());
            }
        }
    }


}
