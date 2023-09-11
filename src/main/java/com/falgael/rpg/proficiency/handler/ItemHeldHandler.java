package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.RPG;
import com.falgael.rpg.proficiency.items.CustomItem;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class ItemHeldHandler implements Listener {

    private static int taskId;

    private static ArrayList<Player> activePlayer = new ArrayList<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        activePlayer.add(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        activePlayer.remove(event.getPlayer());
    }


    public static void startCheck() {
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME), new Thread(() -> {
            for (Player player : activePlayer) {
                applyEffects(CustomTool.getItem(player.getInventory().getItemInMainHand()), player, EquipmentSlot.HAND);
                applyEffects(CustomTool.getItem(player.getInventory().getItemInOffHand()), player, EquipmentSlot.OFF_HAND);



                if (CustomItem.isStatOMeter(player.getInventory().getItemInMainHand())) {
                    loreModification(player,player.getInventory().getItemInMainHand());
                }
                if (CustomItem.isStatOMeter(player.getInventory().getItemInOffHand())) {
                    loreModification(player,player.getInventory().getItemInOffHand());
                }


            }
        }), 200,100);
    }

    public static void stopCheck() {
        Bukkit.getServer().getScheduler().cancelTask(taskId);
    }


    public void applyEffects() {
        /*
        for (Player player : activePlayer) {
            CustomTool tool = CustomTool.getItem(player.getInventory().getItemInMainHand());
            if (tool.isNone()) continue;

            if (tool.getItemConfiguration().hasCustomPotionEffect() && tool.getItemConfiguration().getCustomPotionEffect().getSlot() == EquipmentSlot.HAND) {
                for (PotionEffect potionEffect : tool.getItemConfiguration().getCustomPotionEffect().getPotionEffects()) {
                    player.addPotionEffect(potionEffect);
                }

            }
        }
        */

    }


    @EventHandler
    public void onPlayerHeldItem(PlayerMoveEvent event) {
        /*
        Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Held Event");
        if (event.isCancelled()) return;

        CustomTool tool = CustomTool.getItem(event.getPlayer().getInventory().getItemInMainHand());
        if (tool.isNone()) return;

        if (tool.getItemConfiguration().hasCustomPotionEffect() && tool.getItemConfiguration().getCustomPotionEffect().getSlot() == EquipmentSlot.HAND) {
            for (PotionEffect potionEffect : tool.getItemConfiguration().getCustomPotionEffect().getPotionEffects()) {
                event.getPlayer().addPotionEffect(potionEffect);
            }

        }

        if (!CustomItem.isStatOMeter(event.getPlayer().getInventory().getItemInMainHand())) {
            Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Is No StatOMeter");
            return;
        }
        Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Is StatOMeter");
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setLore(loreModification(event.getPlayer()));

        item.setItemMeta(itemMeta);
        */
    }


    private static void loreModification(Player player, ItemStack item) {

        ItemMeta itemMeta = item.getItemMeta();

        List<String> newLore = new ArrayList<>();

        for (ProficiencyType proficiencyType : ProficiencyType.values()) {
            if (proficiencyType == ProficiencyType.NONE || proficiencyType == ProficiencyType.MISC) continue;
            newLore.add(proficiencyType.getRepresentation() + ": " + ChatColor.RESET + "" + PlayerManager.getProficiencyData(player.getUniqueId()).getLevel(proficiencyType));
        }

        itemMeta.setLore(newLore);

        item.setItemMeta(itemMeta);
    }

    private static void applyEffects(CustomTool tool, Player player, EquipmentSlot slot) {
        if (tool.isNone()) return;
        if (!tool.getItemConfiguration().hasPotionEffect()) return;
        if (tool.getItemConfiguration().getEquipmentSlot() != slot) return;

        for (PotionEffect potionEffect : tool.getItemConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
    }


}
