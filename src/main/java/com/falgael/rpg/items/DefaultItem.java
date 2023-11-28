package com.falgael.rpg.items;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DefaultItem {


    int getId();
    String getName();
    List<Proficiency> getProficiencies();
    boolean hasProficiency(Proficiency proficiency);
    boolean hasExactProficiency(Proficiency proficiency);
    Rarity getRarity();
    DefaultItemSet getEquipmentSet();
    ItemConfiguration getConfiguration();
    ItemStack getItemStackRepresentation();


    @NotNull String getKey();


    boolean isBreakingTool();
    boolean isWeapon();

    default boolean isDefault() {
        return false;
    }

}
