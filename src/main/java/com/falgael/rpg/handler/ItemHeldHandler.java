package com.falgael.rpg.handler;

import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.manager.PlayerExperienceManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ItemHeldHandler extends MainHandler {

    private int taskId;

    private ArrayList<Player> activePlayer = new ArrayList<>();

    private PlayerExperienceManagement playerExperienceManager;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        activePlayer.add(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        activePlayer.remove(event.getPlayer());
    }


    public ItemHeldHandler(PlayerExperienceManagement playerExperienceManager, MainManagement mainManager, Plugin plugin) {
        super(mainManager);
        this.playerExperienceManager = playerExperienceManager;
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Thread(() -> {
            for (Player player : activePlayer) {
                proficiencyAdapter.applyPotionEffects(player);
                checkStatOMeter(player);
            }
        }), 200,100);
    }

    public void stopCheck() {
        Bukkit.getServer().getScheduler().cancelTask(taskId);
    }


    private void loreModification(ItemStack item, Player player) {
        if (!item.hasItemMeta()) return;
        ItemMeta itemMeta = item.getItemMeta();

        List<String> newLore = new ArrayList<>();

        for (Proficiency proficiency : Proficiency.values()) {
            if (proficiency == Proficiency.NONE || proficiency == Proficiency.MISC) continue;
            newLore.add(proficiency.getRepresentation() + ": " + ChatColor.RESET + "" + playerExperienceManager.getLevel(player.getUniqueId(), proficiency));
        }

        itemMeta.setLore(newLore);

        item.setItemMeta(itemMeta);
    }

    private void checkStatOMeter(Player player) {
        if (checkStatOMeter(player.getInventory().getItemInMainHand(), player)) return;
        if (checkStatOMeter(player.getInventory().getItemInOffHand(), player)) return;
    }

    private boolean checkStatOMeter(ItemStack item, Player player) {
        if (itemAdapter.getItem(item).getId() == -1) {
            loreModification(item, player);
            return true;
        }
        return false;
    }


}
