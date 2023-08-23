package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.blocks.CustomBlocks;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemHeldHandler implements Listener {
    @EventHandler
    public void onPlayerHeldItem(PlayerItemHeldEvent event) {
        Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Held Event");
        if (event.isCancelled()) return;
        if (!CustomBlocks.isStatOMeter(event.getPlayer().getInventory().getItemInMainHand())) {
            Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Is No StatOMeter");
            return;
        }
        Bukkit.getLogger().info("[" + ItemHeldHandler.class.getSimpleName() + "]: Is StatOMeter");
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setLore(loreModification(event.getPlayer()));

        item.setItemMeta(itemMeta);

    }


    private static List<String> loreModification(Player player) {
        List<String> result = new ArrayList<>();

        for (ProficiencyType proficiencyType : ProficiencyType.values()) {
            if (proficiencyType == ProficiencyType.NONE || proficiencyType == ProficiencyType.MISC) continue;
            result.add(proficiencyType.getRepresentation() + ": " + ChatColor.RESET + "" + PlayerManager.getProficiencyData(player.getUniqueId()).getLevel(proficiencyType));
        }
        return result;
    }

}
