package com.falgael.rpg.items;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import com.falgael.rpg.items.set.ItemSet;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
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

    private List<Proficiency> proficiency = new ArrayList<>();

    private Material material;


    private ArrayList<String> lore = new ArrayList<>();

    private int amount = 1;

    private Rarity rarity = Rarity.NONE;

    private Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();

    private EquipmentSlot equipmentSlot = EquipmentSlot.HAND;

    private boolean currency = false;

    private boolean visibleEnchanted = false;

    private MusicInstrument musicInstrument = null;

    private ItemSet itemSet = ItemSet.NONE;

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

    public ItemBuilder addLore(List<String> lore) {
        if (lore == null) return this;
        this.lore.addAll(lore);
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

    public ItemBuilder addProficiency(Proficiency proficiency) {
        this.proficiency.add(proficiency);
        return this;
    }

    public ItemBuilder addProficiency(List<Proficiency> proficiency) {
        this.proficiency = proficiency;
        return this;
    }


    public ItemBuilder setCurrency(boolean currency) {
        this.currency = currency;
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

    public ItemBuilder setEquipmentSet(ItemSet itemSet) {
        this.itemSet = itemSet;
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

        if (name != null) itemMeta.setDisplayName(rarity.getColor() + name);
        if (rarity != Rarity.NONE)

        itemMeta.setUnbreakable(true);

        if (itemMeta instanceof MusicInstrumentMeta musicItemMeta) {
            if (musicInstrument != null) musicItemMeta.setInstrument(musicInstrument);
        }

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);

        itemMeta.setAttributeModifiers(attributes);

        ArrayList<String> tmpLore = buildLore();
        if (!tmpLore.isEmpty()) itemMeta.setLore(tmpLore);

        if (configuration != null) {
            if (configuration.hasFlag(ConfigurationFlag.CURRENCY) || configuration.hasFlag(ConfigurationFlag.ENCHANTED)) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
            }
        }

        result.setItemMeta(itemMeta);
        return result;
    }


    private ArrayList<String> buildLore() {
        ArrayList<String> result = new ArrayList<>();
        result.add(rarity.getRepresentation());
        if (!currency) {
            proficiency.forEach(e -> {
                if (e != Proficiency.NONE) result.add(e.getRepresentation());
            });
        }

        if (configuration != null) result.addAll(configurationLore(configuration));


        if (lore != null) {
            for (String defaultLore : lore) {
                if (defaultLore.equals("")) continue;
                result.add(ConfigurationFlag.DEFAULT.createLore(defaultLore));
            }
        }

        if (itemSet != ItemSet.NONE) {
            result.add("");
            result.add(ConfigurationFlag.SET_BONUS.createLore(itemSet.getName()));
            for (Proficiency type : itemSet.getProficiency()) {
                if (type != Proficiency.NONE) result.add(type.getRepresentation());
            }

            if (itemSet.hasConfiguration()) result.addAll(configurationLore(itemSet.getConfiguration()));

            itemSet.getDescription().forEach(v -> result.add(ConfigurationFlag.DEFAULT.createLore(v)));


            result.add(ConfigurationFlag.SET_PART_NUMBER.createLore(Integer.toString(itemSet.getPartNumber())));
        }



        return result;
    }

    private static List<String> configurationLore(ItemConfiguration configuration) {
        ArrayList<String> result = new ArrayList<>();
        if (configuration == null) return result;
        for (ConfigurationFlag RPGConfigurationFlag : ConfigurationFlag.values()) {
            if (!RPGConfigurationFlag.hasRepresentation()) continue;
            if (configuration.hasFlag(RPGConfigurationFlag)) result.add(RPGConfigurationFlag.createLore(configuration.getValue(RPGConfigurationFlag)));
        }
        return result;
    }


}
