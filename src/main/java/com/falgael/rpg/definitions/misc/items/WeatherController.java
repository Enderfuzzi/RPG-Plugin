package com.falgael.rpg.definitions.misc.items;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.MainItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.identification.IdSets;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;

import java.util.ArrayList;
import java.util.List;

public class WeatherController extends MainItemDefinition {
    public WeatherController(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90100,
                        "Sunshine Creator I",
                        Material.GOAT_HORN,
                        Proficiency.MISC,
                        Rarity.ADVANCED,
                        "Clears the view to the sun",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addFlag(ConfigurationFlag.WEATHER_CLEAR, 12000)
                                .create()
                ) {
                    @Override
                    protected MusicInstrument getMusicInstrument() {
                        return MusicInstrument.SING;
                    }
                }
        );

        result.add(
                new Item(
                        90101,
                        "Sunshine Creator II",
                        Material.GOAT_HORN,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Nearly endless sunshine",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addFlag(ConfigurationFlag.WEATHER_CLEAR, 6000)
                                .create()
                ) {
                    @Override
                    protected MusicInstrument getMusicInstrument() {
                        return MusicInstrument.PONDER;
                    }
                }
        );

        result.add(
                new Item(
                        90102,
                        "Rain Creator",
                        Material.GOAT_HORN,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Make it rain",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addFlag(ConfigurationFlag.WEATHER_RAIN, 6000)
                                .create()
                ) {
                    @Override
                    protected MusicInstrument getMusicInstrument() {
                        return MusicInstrument.SEEK;
                    }
                }
        );

        result.add(
                new Item(
                        90103,
                        "Storm Creator",
                        Material.GOAT_HORN,
                        Proficiency.MISC,
                        Rarity.ADVANCED,
                        "Call to the gods of storm",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addFlag(ConfigurationFlag.WEATHER_THUNDER, 6000)
                                .create()
                ) {
                    @Override
                    protected MusicInstrument getMusicInstrument() {
                        return MusicInstrument.FEEL;
                    }
                }
        );

        return result;
    }
}
