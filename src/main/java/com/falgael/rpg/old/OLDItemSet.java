package com.falgael.rpg.old;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.NameBuilding;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
public enum OLDItemSet implements NameBuilding, DefaultItemSet {

    NONE(Proficiency.NONE, Rarity.NONE, 0, null, ""),
    //--------------------------------------------------------------------------------------------
    // MISC
    //--------------------------------------------------------------------------------------------

    KING_MIDAS(
            Proficiency.MISC,
            Rarity.EPIC,
            2,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.LOOT,5)
                    .create(),
            "From the King itself"
    ),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    LUMBERJACK_1(
            Proficiency.WOODWORK,
            Rarity.SIMPLE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT,0.5)
                    .create(),
            "For wood specialists"
    ),
    LUMBERJACK_2(
            Proficiency.WOODWORK,
            Rarity.COMMON,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .create(),
            "For wood specialists"
    ),
    LUMBERJACK_3(
            Proficiency.WOODWORK,
            Rarity.ADVANCED,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT,1.5)
                    .create(),
            "For wood specialists"
    ),
    LUMBERJACK_4(
            Proficiency.WOODWORK,
            Rarity.ELITE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT,2)
                    .create(),
            "For wood specialists"
    ),
    LUMBERJACK_5(Proficiency.WOODWORK, Rarity.EPIC,5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT,3)
                    .create(),
            "For wood specialists"
    ),
    LUMBERJACK_6(
            Proficiency.WOODWORK,
            Rarity.LEGENDARY,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                    .addFlag(ConfigurationFlag.LOOT,4)
                    .create(),
            "For wood specialists"
    ),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    MINER_1(
            Proficiency.STONEWORK,
            Rarity.SIMPLE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .create(),
            "For stone specialists"
    ),
    MINER_2(
            Proficiency.STONEWORK,
            Rarity.COMMON,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .create(),
            "For stone specialists"
    ),
    MINER_3(
            Proficiency.STONEWORK,
            Rarity.ADVANCED,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .create(),
            "For stone specialists"
    ),
    MINER_4(
            Proficiency.STONEWORK,
            Rarity.ELITE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .create(),
            "For stone specialists"
    ),
    MINER_5(
            Proficiency.STONEWORK,
            Rarity.EPIC,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .create(),
            "For stone specialists"
    ),
    MINER_6(
            Proficiency.STONEWORK,
            Rarity.LEGENDARY,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 4)
                    .create(),
            "For stone specialists"
    ),

    DEEP_MINER(
            Proficiency.STONEWORK,
            Rarity.EPIC,
            3,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING, 1)
                    .create(),
            "Mines to the deepest deep"
    ),

    GOTHMOGS_BREATH(
            Proficiency.STONEWORK,
            Rarity.LEGENDARY,
            1,
            new ItemConfiguration.Builder()
                    .addPotionEffect(PotionEffectType.FIRE_RESISTANCE)
                    .create(),
            "Breath of the Lord itself"
    ),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMER_1(
            Proficiency.FARMING,
            Rarity.SIMPLE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .create()
    ),
    FARMER_2(
            Proficiency.FARMING,
            Rarity.COMMON,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .create()
    ),
    FARMER_3(
            Proficiency.FARMING,
            Rarity.ADVANCED,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .create()
    ),
    FARMER_4(
            Proficiency.FARMING,
            Rarity.ELITE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 2).create()
    ),
    FARMER_5(
            Proficiency.FARMING,
            Rarity.EPIC,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .create()
    ),
    FARMER_6(Proficiency.FARMING, Rarity.LEGENDARY, 5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                    .addFlag(ConfigurationFlag.LOOT, 4)
                    .create()
    ),

    BUTCHER(
            Proficiency.FARMING,
            Rarity.COMMON,
            2,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_ADDITIVE,3)
                    .create()
    ),


    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    HUNTER_1(
            Proficiency.HUNTING,
            Rarity.SIMPLE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT,0.5)
                    .create()),
    HUNTER_2(
            Proficiency.HUNTING,
            Rarity.COMMON,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .create()),
    HUNTER_3(
            Proficiency.HUNTING,
            Rarity.ADVANCED,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT,1.5)
                    .create()),
    HUNTER_4(
            Proficiency.HUNTING,
            Rarity.ELITE,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT,2)
                    .create()),
    HUNTER_5(
            Proficiency.HUNTING,
            Rarity.EPIC,
            5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,3)
                    .create()),
    HUNTER_6(
            Proficiency.HUNTING,
            Rarity.LEGENDARY, 5,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT,4)
                    .create()),


    ;

    private final List<Proficiency> proficiencies;

    private final Rarity rarity;

    private final String name;

    private final int numberOfParts;

    private final ItemConfiguration configuration;

    private final List<String> description;

    OLDItemSet(Proficiency proficiency, Rarity rarity, int numberOfParts, ItemConfiguration configuration, String... description) {
        this(List.of(proficiency), rarity, numberOfParts, configuration, description);
    }

    OLDItemSet(List<Proficiency> proficiency, Rarity rarity, int numberOfParts, ItemConfiguration configuration, String... description) {
        this.name = buildName(this.name());
        this.proficiencies = proficiency;
        this.rarity = rarity;

        this.numberOfParts = numberOfParts > 6 || numberOfParts <= 0 ? 1 : numberOfParts;

        this.configuration = configuration;

        this.description = new ArrayList<>();
        Collections.addAll(this.description, description);
    }

    public List<Proficiency> getProficiency() {
        return proficiencies;
    }

    public boolean hasProficiency(Proficiency proficiency) {
        return proficiency == Proficiency.MISC || proficiency == Proficiency.NONE || hasExactProficiency(proficiency);
    }

    public boolean hasExactProficiency(Proficiency proficiency) {
        return proficiencies.contains(proficiency);
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return rarity.getColor() + name;
    }

    public int getPartNumber() {
        return numberOfParts;
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }


    public boolean validDescription() {
        return !description.equals("");
    }

    public List<String> getDescription() {
        return description;
    }



}