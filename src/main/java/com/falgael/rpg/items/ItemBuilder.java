package com.falgael.rpg.items;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.general.Rarity;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ItemBuilder {

    private String name;

    private ProficiencyType proficiency = ProficiencyType.NONE;

    private Material material;

    //private ArrayList<String> lore = new ArrayList<>();

    private HashMap<ItemModifier, String> lore = new HashMap<>();

    private int amount = 1;

    private boolean compressed = false;

    private Rarity rarity = Rarity.COMMON;

    private Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();

    private EquipmentSlot equipmentSlot = EquipmentSlot.HAND;

    private boolean currency = false;

    private boolean visibleEnchanted = false;

    private MusicInstrument musicInstrument = null;

    public ItemBuilder(Material material) {
        this.material = material;
    }


    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder addPrefix(String name) {
        this.name = name + " " + this.name;
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.put(ItemModifier.DEFAULT, lore);
        return this;
    }

    public ItemBuilder addLore(ItemModifier modifier, String lore) {
        this.lore.put(modifier, lore);
        return this;
    }
    /*
    public ItemBuilder addExperienceModifierLore(String text) {
        return addLore(text, ItemModifier.EXPERIENCE);
    }

    public ItemBuilder addLootModifierLore(String text) {
        return addLore(text, ItemModifier.LOOT);
    }

    public ItemBuilder addBurnModifierLore(String text) {
        return addLore(text, ItemModifier.BURN_TIME);
    }


     */
    public ItemBuilder setCompressed() {
        this.compressed = true;
        this.rarity = Rarity.ELITE;
        return this;
    }

    public ItemBuilder setRarity(Rarity itemType) {
        if (!compressed) this.rarity = itemType;
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
        lore.put(ItemModifier.CURRENCY, "");
        proficiency = ProficiencyType.MISC;
        return this;
    }

    public ItemBuilder visibleEnchanted() {
        visibleEnchanted = true;
        return this;
    }

    public ItemBuilder setMusicInstrument(MusicInstrument instrument) {
        this.musicInstrument = instrument;
        return this;
    }



    public ItemStack create() {
        ItemStack result = new ItemStack(material,Math.max(1,amount));
        ItemMeta itemMeta = result.getItemMeta();

        if (name != null) itemMeta.setDisplayName(buildName());

        itemMeta.setUnbreakable(true);

        if (itemMeta instanceof MusicInstrumentMeta musicItemMeta) {
            if (musicInstrument != null) musicItemMeta.setInstrument(musicInstrument);
        }

        // Item stats are visible
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        //itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemMeta.setAttributeModifiers(attributes);

        ArrayList<String> tmpLore = buildLore();
        if (!tmpLore.isEmpty()) itemMeta.setLore(tmpLore);

        if (compressed || currency || visibleEnchanted) {
            if (compressed) itemMeta.setDisplayName(buildCompressedName());
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        }


        result.setItemMeta(itemMeta);
        return result;
    }


    private String buildName() {
        return rarity.getRepresentation() + name;
    }

    private String buildCompressedName() {
        return rarity.getRepresentation() + "Compressed " + Utils.getMaterialName(material);
    }

    private ArrayList<String> buildLore() {
        ArrayList<String> result = new ArrayList<>();
        if (proficiency != ProficiencyType.NONE) result.add(proficiency.getRepresentation());

        for (ItemModifier itemModifier : ItemModifier.values()) {
            if (lore.containsKey(itemModifier)) result.add(itemModifier.createLore(lore.get(itemModifier)));
        }
        return result;
    }



}
