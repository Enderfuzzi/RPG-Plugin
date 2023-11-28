package com.falgael.rpg.manager;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.PredicateConsumer;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ProficiencyCalculationAdapter {


    double calculateMultiplier(Player player, Proficiency proficiency, ConfigurationFlag flag);
    DefaultItem getItem(Player player, EquipmentSlot slot);

    boolean fulfillLevelRequirement(Player player, DefaultItem item);


    List<DefaultItem> getEquippedItems(Player player);

    List<DefaultItemSet> getFulfilledSets(Player player, List<DefaultItem> equippedItems);

    void calculateExperience(Player player, List<Proficiency> proficiencies, long baseExperience);

    default void calculateExperience(Player player, Proficiency proficiency , long baseExperience) {
        calculateExperience(player, List.of(proficiency), baseExperience);
    }

    int calculateLoot(Player player, Proficiency proficiency);

    default int calculateLoot(Player player, List<Proficiency> proficiencies) {
        int result = 0;
        for (Proficiency proficiency : proficiencies) result += calculateLoot(player, proficiency);
        return result;
    }


    double calculateTotalDamage(Player player, List<Proficiency> proficiencies, double base);

    default double calculateTotalDamage(Player player,Proficiency proficiency, double base) {
        return calculateTotalDamage(player, List.of(proficiency), base);
    }



    default void dropAdditionalLoot(List<ItemStack> drops, int dropAmount, World world, Location location) {
        if (dropAmount < 1) return;
        if (drops.isEmpty()) return;
        if (world == null || location == null) return;

        for (ItemStack itemStack : drops) {
            if (itemStack.getType() == Material.AIR) continue;
            if (itemStack.getAmount() <= 0) continue;
            int tmpAmount = dropAmount;
            while (tmpAmount - 64 > 0) {
                world.dropItemNaturally(location,new ItemStack(itemStack.getType(), 64));
                tmpAmount -= 64;
            }
            world.dropItemNaturally(location, new ItemStack(itemStack.getType(), tmpAmount));
        }
    }

    default void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }


    boolean performAction(Event e, DefaultItem item);
    boolean performAction(Event e, DefaultItem item, Player player);

    boolean performAction(Player player, Event e, PredicateConsumer<DefaultItem> predicate);

    void applyPotionEffects(Player player);




}
