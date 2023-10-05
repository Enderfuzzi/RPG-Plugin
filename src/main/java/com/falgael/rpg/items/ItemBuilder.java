package com.falgael.rpg.items;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.tmp.EquipmentSet;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

import java.util.*;

public class ItemBuilder {

    private String name;

    private ProficiencyType proficiency = ProficiencyType.NONE;

    private Material material;

    //private ArrayList<String> lore = new ArrayList<>();

    private ArrayList<String> lore = new ArrayList<>();

    private int amount = 1;

    private Rarity rarity = Rarity.COMMON;

    private Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();

    private EquipmentSlot equipmentSlot = EquipmentSlot.HAND;

    private boolean currency = false;

    private boolean visibleEnchanted = false;

    private MusicInstrument musicInstrument = null;

    private EquipmentSet equipmentSet = EquipmentSet.NONE;

    private ItemConfiguration configuration;


    public ItemBuilder(Material material) {
        this.material = material;
    }


    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder addLore(String lore) {
        if (lore == null) return this;
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder addLore(Set<String> lore) {
        if (lore == null) return this;
        this.lore.addAll(lore.stream().toList());
        return this;
    }


    public ItemBuilder setRarity(Rarity itemType) {
        this.rarity = itemType;
        return this;
    }

    public ItemBuilder setEquipmentSlot(EquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
        return this;
    }

    //TODO Rebuild the Attributes for further usage
    public ItemBuilder addAttribute(Attribute attribute, double value, String attributeName) {
        attributes.put(attribute, new AttributeModifier(UUID.nameUUIDFromBytes(attributeName.getBytes()),attributeName,value,AttributeModifier.Operation.ADD_NUMBER, equipmentSlot));
        return this;
    }

    public ItemBuilder addAttribute(Attribute attribute, double value) {
        return addAttribute(attribute,value, attribute.name());
    }

    public ItemBuilder addProficiency(ProficiencyType proficiency) {
        if (!currency) this.proficiency = proficiency;
        return this;
    }

    public ItemBuilder setCurrency() {
        this.currency = true;
        proficiency = ProficiencyType.MISC;
        return this;
    }

    public ItemBuilder visibleEnchanted(boolean visibleEnchanted) {
        this.visibleEnchanted = visibleEnchanted;
        return this;
    }

    public ItemBuilder setMusicInstrument(MusicInstrument instrument) {
        this.musicInstrument = instrument;
        return this;
    }

    public ItemBuilder setEquipmentSet(EquipmentSet equipmentSet) {
        this.equipmentSet = equipmentSet;
        return this;
    }

    public ItemBuilder setConfiguration(ItemConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }


    public ItemStack create() {
        ItemStack result = new ItemStack(material,Math.max(1,amount));
        if (material == Material.AIR) return result;
        ItemMeta itemMeta = result.getItemMeta();

        if (name != null) itemMeta.setDisplayName(buildName());

        itemMeta.setUnbreakable(true);

        if (itemMeta instanceof MusicInstrumentMeta musicItemMeta) {
            if (musicInstrument != null) musicItemMeta.setInstrument(musicInstrument);
        }

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);

        itemMeta.setAttributeModifiers(attributes);

        ArrayList<String> tmpLore = buildLore();
        if (!tmpLore.isEmpty()) itemMeta.setLore(tmpLore);

        if (currency || visibleEnchanted) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        }


        result.setItemMeta(itemMeta);
        return result;
    }


    private String buildName() {
        return rarity.getRepresentation() + ChatColor.WHITE + name;
    }


    private ArrayList<String> buildLore() {
        ArrayList<String> result = new ArrayList<>();
        if (proficiency != ProficiencyType.NONE) result.add(proficiency.getRepresentation());

        if (configuration != null) {
            for (ConfigurationFlag configurationFlag : ConfigurationFlag.values()) {
                if (configuration.hasFlag(configurationFlag))
                    result.add(configurationFlag.createLore(configuration.getValue(configurationFlag)));
            }

        }


        if (lore != null) {
            for (String defaultLore : lore) {
                result.add(ConfigurationFlag.DEFAULT.createLore(defaultLore));
            }
        }

        if (equipmentSet != EquipmentSet.NONE) {
            result.add("");
            result.add(ConfigurationFlag.SET_BONUS.createLore(equipmentSet.getName()));
            if (equipmentSet.getProficiencyType() != ProficiencyType.NONE) result.add(equipmentSet.getProficiencyType().getRepresentation());

            for (ConfigurationFlag configurationFlag : ConfigurationFlag.values()) {
                if (!equipmentSet.hasConfiguration()) break;
                if (equipmentSet.getConfiguration().hasFlag(configurationFlag))
                    result.add(configurationFlag.createLore(equipmentSet.getConfiguration().getValue(configurationFlag)));
            }

            if (equipmentSet.hasDescription()) {
                equipmentSet.getDescription().forEach(v -> result.add(ConfigurationFlag.DEFAULT.createLore(v)));
            }
            result.add(ConfigurationFlag.SET_PART_NUMBER.createLore(Integer.toString(equipmentSet.getNumberOfParts())));
        }



        return result;
    }


}
