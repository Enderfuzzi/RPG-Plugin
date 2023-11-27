package com.falgael.rpg.items.set;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;

import java.util.List;

public interface DefaultItemSet {
    List<Proficiency> getProficiency();
    Rarity getRarity();
    String getName();
    int getPartNumber();
    ItemConfiguration getConfiguration();
    boolean validDescription();
    List<String> getDescription();

    default boolean hasProficiency(Proficiency proficiency) {
        return proficiency == Proficiency.MISC || proficiency == Proficiency.NONE || hasExactProficiency(proficiency);
    }

    boolean hasExactProficiency(Proficiency proficiency);
}
