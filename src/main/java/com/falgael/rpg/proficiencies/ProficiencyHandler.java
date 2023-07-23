package com.falgael.rpg.proficiencies;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

/**
 * Manages the proficiencies of all Players
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyHandler implements Listener {

    /** Assigns Experience data to each player */
    private static HashMap<Player, ProficiencyData> experiences = new HashMap<>();

    /**
     * Method to send a formatted Message for the proficiencies increase
     * @param player The player to target
     * @param proficiencyRepresentation The representation of the proficiency
     * @param currentExperience The current Experience of the {@code Player}
     * @param currentExperienceBorder The current Experience Border of the {@code Player}
     */
    private void experienceIncreaseMessage(@NotNull Player player, String proficiencyRepresentation, int currentExperience, int currentExperienceBorder) {
        TextComponent message = new TextComponent(ChatColor.GOLD + "" + ChatColor.ITALIC + proficiencyRepresentation + ": " + currentExperience + "/" + currentExperienceBorder + " Xp");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
        Bukkit.getLogger().info(player.getDisplayName() + " has " + currentExperience + " Xp of " + currentExperienceBorder + " from " + proficiencyRepresentation);
    }


    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        if (!experiences.containsKey(event.getPlayer())) {
            experiences.put(event.getPlayer(), new ProficiencyData());
        }
    }

    /**
     * Searches each block break proficiencies of a player when destroying a block
     * @param event describes the {@code BlockBreakEvent}
     */
    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent event) {
        if (event.isCancelled()) return;
        for (ProficiencyExperienceFramework ef : experiences.get(event.getPlayer()).getBlockBreakProficiency()) {
            if (ef.givesBlockBreakingExperience(event.getBlock())) {
                ef.increaseExperience(ef.amountBlockBreakingExperience(event.getBlock()));
                experienceIncreaseMessage(event.getPlayer(),ef.getProficiencyRepresentation(),ef.getCurrentExperience(),ef.getCurrentExperienceBorder());
                return;
            }
        }
    }

    /**
     * Searches each block craft proficiencies of a {@code Player} when crafting a block. Works with crafting whole stacks with shift-click.
     * @param event describes the {@code CraftItemEvent}
     */
    @EventHandler
    public void onCraft(@NotNull CraftItemEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getWhoClicked() instanceof Player player)) return;
        Bukkit.getLogger().info("Crafting result name: " + Objects.requireNonNull(event.getCurrentItem()).getType());
        Bukkit.getLogger().info("Size of crafting: " + event.getCurrentItem().getAmount());

        for (ProficiencyExperienceFramework ef : experiences.get(player).getBlockBreakProficiency()) {
            if (ef.givesBlockCraftingExperience(event.getCurrentItem().getType(),event.getInventory())) {

                int craftedAmount = 1;

                if (event.isShiftClick()) {
                    for (ItemStack is : event.getInventory().getMatrix()) {
                        if (is == null) continue;
                        if (craftedAmount == 1 || (is.getAmount() > 0 && is.getAmount() < craftedAmount)) {
                            craftedAmount = is.getAmount();
                        }
                    }
                    Bukkit.getLogger().info("Amount to craft with shift: " + craftedAmount);
                }

                ef.increaseExperience(ef.amountBlockCraftingExperience(event.getCurrentItem().getType()) * craftedAmount);
                experienceIncreaseMessage(player,ef.getProficiencyRepresentation(),ef.getCurrentExperience(),ef.getCurrentExperienceBorder());
            }
        }
    }

    /**
     * Checks if the {@code Player} is allowed to craft an item. If not set the result to air.
     * @param event describes {@code PrepareItemCraftEvent}
     */
    @EventHandler
    public void onPrepareItemCraft(@NotNull PrepareItemCraftEvent event) {
        if (experiences.get(event.getView().getPlayer()).isForbiddenToCraft(event.getInventory().getResult().getType())) {
            event.getInventory().setResult(new ItemStack(Material.AIR));
        }
    }

}