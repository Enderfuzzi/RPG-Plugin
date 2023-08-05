package com.falgael.rpg.items;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import com.falgael.rpg.proficiency.items.Rarity;
import com.falgael.rpg.utility.Utils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class ItemBuilder {

    private String name;

    private ProficiencyTypes proficiency = ProficiencyTypes.NONE;

    private Material material;

    private ArrayList<String> lore = new ArrayList<>();

    private int amount = 1;

    private boolean compressed = false;

    private Rarity rarity = Rarity.COMMON;

    private Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();

    private EquipmentSlot equipmentSlot = EquipmentSlot.HAND;

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
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder addExperienceModifierLore(String text) {
        this.lore.add(ItemModifier.EXPERIENCE.getRepresentation() + text);
        return this;
    }

    public ItemBuilder addLootModifierLore(String text) {
        this.lore.add(ItemModifier.LOOT.getRepresentation() + text);
        return this;
    }

    public ItemBuilder setCompressed(boolean compressed) {
        this.compressed = compressed;
        this.rarity = Rarity.ELITE;
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

    private void addAttribute(Attribute attribute, double value, String name) {
        attributes.put(attribute, new AttributeModifier(UUID.randomUUID(),name,value,AttributeModifier.Operation.ADD_SCALAR, equipmentSlot));
    }

    public ItemBuilder addSpeedAttribute(double value) {
        addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,value,"Movement Speed");
        return this;
    }

    public ItemBuilder addHealthAttribute(double value) {
        addAttribute(Attribute.GENERIC_MAX_HEALTH,value,"Health");
        return this;
    }

    public ItemBuilder addDamageAttribute(double value) {
        addAttribute(Attribute.GENERIC_ATTACK_DAMAGE,value,"Attack Damage");
        return this;
    }

    public ItemBuilder addArmorAttribute(double value) {
        addAttribute(Attribute.GENERIC_ARMOR,value,"Armor");
        return this;
    }

    public ItemBuilder addProficiency(ProficiencyTypes proficiency) {
        this.proficiency = proficiency;
        return this;
    }


    public ItemStack create() {
        ItemStack result = new ItemStack(material,Math.max(1,amount));
        ItemMeta itemMeta = result.getItemMeta();

        if (name != null) itemMeta.setDisplayName(buildName());

        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemMeta.setAttributeModifiers(attributes);
        if (proficiency != ProficiencyTypes.NONE) lore.add(0,proficiency.getRepresentation());
        itemMeta.setLore(lore);

        if (compressed) {
            itemMeta.setDisplayName(buildCompressedName());
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

}