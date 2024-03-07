package com.falgael.rpg.items.set;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.identification.ID;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;

import java.util.List;

public class ItemSet implements DefaultItemSet, NameBuilding {

    private final int id;
    private final String name;
    private final List<Proficiency> proficiencies;
    private final Rarity rarity;

    private final int numberOfParts;

    private final List<String> description;
    private final ItemConfiguration configuration;

    public ItemSet(
            int id,
            String name,
            Proficiency proficiency,
            Rarity rarity,
            int numberOfParts,
            ItemConfiguration configuration
    ) {
        this(id, name, proficiency, rarity, numberOfParts, "", configuration);
    }

    public ItemSet(
            ID id,
            String name,
            Proficiency proficiency,
            Rarity rarity,
            int numberOfParts,
            String description,
            ItemConfiguration configuration
    ) {
        this(id.getId(), name, List.of(proficiency), rarity, numberOfParts, List.of(description), configuration);
    }


    public ItemSet(
            int id,
            String name,
            Proficiency proficiency,
            Rarity rarity,
            int numberOfParts,
            String description,
            ItemConfiguration configuration
    ) {
        this(id, name, List.of(proficiency), rarity, numberOfParts, List.of(description), configuration);
    }


    public ItemSet(
            int id,
            String name,
            List<Proficiency> proficiencies,
            Rarity rarity,
            int numberOfParts,
            List<String> description,
            ItemConfiguration configuration
    ) {
        this.id = id;
        this.name = name;
        this.proficiencies = proficiencies;
        this.rarity = rarity;
        this.numberOfParts = numberOfParts;
        this.description = description;
        this.configuration = configuration;
    }


    @Override
    public List<Proficiency> getProficiency() {
        return proficiencies;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPartNumber() {
        return numberOfParts;
    }

    @Override
    public ItemConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public boolean validDescription() {
        return !description.equals("");
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public boolean hasExactProficiency(Proficiency proficiency) {
        return proficiencies.contains(proficiency);
    }

    @Override
    public String getKey() {
        return getName().toLowerCase().replace(" ", "_");
    }

    @Override
    public int getId() {
        return id;
    }
}
