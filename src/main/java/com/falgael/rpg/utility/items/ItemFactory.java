package com.falgael.rpg.utility.items;

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

public class ItemFactory {

    private String name;

    private Material material;

    private ArrayList<String> lore = new ArrayList<>();

    private int amount = 1;

    private boolean compressed = false;

    private ItemType type = ItemType.COMMON;

    private Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();

    private EquipmentSlot equipmentSlot = EquipmentSlot.HAND;

    public ItemFactory(Material material) {
        this.material = material;
    }

    public ItemFactory setName(String name) {
        this.name = name;
        return this;
    }

    public ItemFactory addPrefix(String name) {
        this.name = name + " " + this.name;
        return this;
    }

    public ItemFactory setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemFactory addLore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemFactory addExperienceModifierLore(String text) {
        this.lore.add(ItemModifier.EXPERIENCE.getRepresentation() + text);
        return this;
    }

    public ItemFactory addLootModifierLore(String text) {
        this.lore.add(ItemModifier.LOOT.getRepresentation() + text);
        return this;
    }

    public ItemFactory setCompressed(boolean compressed) {
        this.compressed = compressed;
        this.type = ItemType.RARE;
        return this;
    }

    public ItemFactory setType(ItemType itemType) {
        this.type = itemType;
        return this;
    }

    public ItemFactory setEquipmentSlot(EquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
        return this;
    }

    private void addAttribute(Attribute attribute, double value, String name) {
        attributes.put(attribute, new AttributeModifier(UUID.randomUUID(),name,value,AttributeModifier.Operation.ADD_SCALAR, equipmentSlot));
    }

    public ItemFactory addSpeedAttribute(double value) {
        addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,value,"Movement Speed");
        return this;
    }

    public ItemFactory addHealthAttribute(double value) {
        addAttribute(Attribute.GENERIC_MAX_HEALTH,value,"Health");
        return this;
    }

    public ItemFactory addDamageAttribute(double value) {
        addAttribute(Attribute.GENERIC_ATTACK_DAMAGE,value,"Attack Damage");
        return this;
    }

    public ItemFactory addArmorAttribute(double value) {
        addAttribute(Attribute.GENERIC_ARMOR,value,"Armor");
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

        itemMeta.setLore(lore);

        if (compressed) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        }


        result.setItemMeta(itemMeta);
        return result;
    }


    private String buildName() {
        return type.getPrefix() + name;
    }

}
