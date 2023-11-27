package com.falgael.rpg.items;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.OLDItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DefaultItem {


    int getID();
    String getName();
    List<Proficiency> getProficiencies();
    boolean hasProficiency(Proficiency proficiency);
    boolean hasExactProficiency(Proficiency proficiency);
    Rarity getRarity();
    OLDItemSet getEquipmentSet();
    ItemConfiguration getConfiguration();
    ItemStack getItemStackRepresentation();


    @NotNull String getKey();


    boolean isBreakingTool();
    boolean isWeapon();

}
