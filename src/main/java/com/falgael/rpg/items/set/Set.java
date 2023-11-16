package com.falgael.rpg.items.set;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;

import java.util.List;

public interface Set {
    List<Proficiency> getProficiency();
    Rarity getRarity();
    String getName();
    int getPartNumber();
    ItemConfiguration getConfiguration();
    boolean validDescription();
    List<String> getDescription();

    boolean hasProficiency(Proficiency proficiency);

    boolean hasExactProficiency(Proficiency proficiency);
}
