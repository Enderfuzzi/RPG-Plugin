package com.falgael.rpg.items;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Item implements DefaultItem {

    private final int id;
    private final String name;
    private final Material material;
    private final List<Proficiency> proficiencies;
    private final Rarity rarity;
    private final List<String> loreDescription;
    private final DefaultItemSet itemSet;
    private final ItemConfiguration configuration;
    private ItemStack itemStackRepresentation;


    public Item(
            int id,
            String name,
            Material material,
            List<Proficiency> proficiencies,
            Rarity rarity,
            List<String> loreDescription,
            DefaultItemSet itemSet,
            ItemConfiguration configuration
    ) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.proficiencies = proficiencies;
        this.rarity = rarity;
        this.loreDescription = loreDescription;
        this.itemSet = itemSet;
        this.configuration = configuration;

        Bukkit.getLogger().info("Material: " + material);

        itemStackRepresentation = material == Material.AIR ? null : createItemStack();

    }

    public Item(
            int id,
            String name,
            Material material,
            Proficiency proficiency,
            Rarity rarity,
            DefaultItemSet itemSet,
            ItemConfiguration configuration
    ) {
        this(id,name, material, List.of(proficiency), rarity,"",itemSet, configuration);
    }

    public Item(
            int id,
            String name,
            Material material,
            Proficiency proficiency,
            Rarity rarity,
            List<String> loreDescription,
            DefaultItemSet itemSet,
            ItemConfiguration configuration
    ) {
        this(id,name, material, List.of(proficiency), rarity, loreDescription, itemSet, configuration);
    }

    public Item(
            int id,
            String name,
            Material material,
            List<Proficiency> proficiencies,
            Rarity rarity,
            String loreDescription,
            DefaultItemSet itemSet,
            ItemConfiguration configuration
    ) {
        this(id, name, material, proficiencies, rarity, List.of(loreDescription), itemSet, configuration);
    }

    public Item(
            int id,
            String name,
            Material material,
            Proficiency proficiency,
            Rarity rarity,
            String loreDescription,
            DefaultItemSet itemSet,
            ItemConfiguration configuration
    ) {
        this(id,name, material, List.of(proficiency), rarity, List.of(loreDescription), itemSet, configuration);
    }


    private ItemStack createItemStack() {
        ItemStack result = new ItemStack(material);
        //Bukkit.getLogger().info("Begin create Itemstack: " + name);
        //Bukkit.getLogger().info("ItemMeta " + result.hasItemMeta());
        //Bukkit.getLogger().info("Has item Meta");
        ItemMeta itemMeta = result.getItemMeta();

        itemMeta.setDisplayName(rarity.getColor() + name);
        if (rarity != Rarity.NONE) itemMeta.setUnbreakable(true);

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);

        if (itemMeta instanceof MusicInstrumentMeta musicMeta) {
            if (getMusicInstrument() != null) {
                musicMeta.setInstrument(getMusicInstrument());
            }
        } else if (itemMeta instanceof FireworkMeta fireworkMeta) {
            if (configuration.hasFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION)) {
                int value = configuration.getValue(ConfigurationFlag.ROCKET_FLIGHT_DURATION).intValue();
                if (value >= 0 && value <= 127) fireworkMeta.setPower(value);
                fireworkMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            }
        }

        ArrayList<String> tmpLore = buildLore();
        if (!tmpLore.isEmpty()) itemMeta.setLore(tmpLore);

        if (configuration != null) {
            if (configuration.hasFlag(ConfigurationFlag.CURRENCY) || configuration.hasFlag(ConfigurationFlag.ENCHANTED)) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.ARROW_INFINITE,1,true);
            }
        }
        result.setItemMeta(itemMeta);
        //Bukkit.getLogger().info("End create Itemstack: " + name);
        return result;
    }

    public @NotNull String getKey() {
        return name.toLowerCase().replace(" ", "_") + "_" + material.toString().toLowerCase() ;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    @Override
    public boolean hasProficiency(Proficiency proficiency) {
        return proficiency == Proficiency.MISC || proficiency == Proficiency.NONE || hasExactProficiency(proficiency);
    }

    @Override
    public boolean hasExactProficiency(Proficiency proficiency) {
        return proficiencies.contains(proficiency);
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public DefaultItemSet getEquipmentSet() {
        return itemSet;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public ItemStack getItemStackRepresentation() {
        return itemStackRepresentation;
    }

    private ArrayList<String> buildLore() {
        ArrayList<String> result = new ArrayList<>();
        result.add(spacer());
        result.add(rarity.getRepresentation());
        proficiencies.forEach(e -> {
                if (e != Proficiency.NONE) result.add(e.getRepresentation());
            });

        result.addAll(configurationLore(configuration));

        for (String defaultLore : loreDescription) {
            if (defaultLore.equals("")) continue;
            result.add(ConfigurationFlag.DEFAULT.createLore(defaultLore));
        }

        if (!itemSet.isDefault()) {
            result.add(spacer());
            result.add(ConfigurationFlag.SET_BONUS.createLore(itemSet.getRarity().getColor() + itemSet.getName()));
            for (Proficiency type : itemSet.getProficiency()) {
                if (type != Proficiency.NONE) result.add(type.getRepresentation());
            }

            result.addAll(configurationLore(itemSet.getConfiguration()));

            itemSet.getDescription().forEach(v -> {
                if (!v.equals("")) result.add(ConfigurationFlag.DEFAULT.createLore(v));
            });
            result.add(spacer());
            result.add(ConfigurationFlag.SET_PART_NUMBER.createLore(Integer.toString(itemSet.getPartNumber())));
        }
        return result;
    }

    private @NotNull List<String> configurationLore(ItemConfiguration configuration) {
        ArrayList<String> result = new ArrayList<>();
        if (configuration == null) return result;
        for (ConfigurationFlag configurationFlag : ConfigurationFlag.values()) {
            if (!configurationFlag.hasRepresentation()) continue;
            if (configuration.hasFlag(configurationFlag)) result.add(configurationFlag.createLore(configuration.getValue(configurationFlag)));
        }
        return result;
    }


    protected MusicInstrument getMusicInstrument() {
        return null;
    }

    private String spacer() {
        return "-".repeat(name.length());
    }

}
