package com.falgael.rpg.utility.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Provides methods for creations of different special items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemCreation {

    /**
     * Creates an item with {@code Material}, Name and lore. Name and lore can be empty.
     * Note: the created item is unbreakable. The unbreakable is hidden, the attributes are hidden.
     * @param material The {@code Material} to create the item with
     * @param name The item name
     * @param lore The lore to add can be null
     * @return The new created item
     */

    public static ItemStack createItem(Material material, String name, String... lore) {
        if (material == null) return null;
        ItemStack result = new ItemStack(material,1);
        ItemMeta itemMeta = result.getItemMeta();

        if (!name.equals("")) itemMeta.setDisplayName(name);
        if (!lore[0].equals("")) itemMeta.setLore(new ArrayList<>(Arrays.asList(lore)));

        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        result.setItemMeta(itemMeta);
        return result;
    }

    /**
     * Creates an item with {@code Material} and name.
     * Note: the created item is unbreakable
     * @param material The {@code Material} to use for creation
     * @param itemName The item name
     * @return The new created item
     */
    public static ItemStack createItem(Material material, String itemName) {
        return createItem(material, itemName, "");
    }

    /**
     * Creates a new item only with a {@code Material}
     * @param material The {@code Material} to use for creation
     * @return the new created item
     */
    public static ItemStack createItem(Material material) {
        return createItem(material, "", "");
    }

    /**
     * Creates an axe. This creates an item with Movement speed, Strength, health and armor modification.
     * @param material The {@code Material} to create the axe with. Should only be used with axes.
     * @param name The name of the item
     * @param speedValue The speed modifier. 0.0 does not change the speed.
     * @param strengthValue The strength modifier. 0.0 does not change the strength.
     * @param healthValue The health modifier. 0.0 does not change the health.
     * @param armorValue The armor modifier. 0.0 does not change the armor.
     * @param lore The lore to add
     * @return The new axe item.
     */
    public static @NotNull ItemStack createAxe(Material material, String name, double speedValue, double strengthValue, double healthValue, double armorValue, String... lore) {
        ItemStack result = createItem(material,name,lore);
        ItemMeta itemMeta = result.getItemMeta();

        itemMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,new AttributeModifier(UUID.randomUUID(), "Speed", speedValue,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,new AttributeModifier(UUID.randomUUID(), "Damage", strengthValue,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH,new AttributeModifier(UUID.randomUUID(), "Health", healthValue,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,new AttributeModifier(UUID.randomUUID(), "Armor", armorValue,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND));

        result.setItemMeta(itemMeta);
        return result;
    }

}
