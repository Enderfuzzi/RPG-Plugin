package com.falgael.rpg.utility.items;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemFactory {

    private String name;

    private Material material;

    private ArrayList<String> lore;

    private int amount = 1;

    private boolean compressed = false;

    public ItemFactory(Material material) {
        this.material = material;
        this.name = material.name();
    }

    public ItemFactory setName(String name) {
        this.name = name;
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

    public ItemFactory setCompressed(boolean compressed) {
        this.compressed = compressed;
        return this;
    }

    public ItemStack crate() {
        ItemStack result = new ItemStack(material,Math.max(1,amount));
        ItemMeta itemMeta = result.getItemMeta();
        itemMeta.setDisplayName(!compressed ? name : ItemInformation.RARE_ITEM_COLOR + "Compressed " +
                StringUtils.capitalize(material.name().replace("_", " ").toLowerCase()));
            //has to be fixed
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        if (compressed) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addEnchant(Enchantment.KNOCKBACK,1,true);
        }


        result.setItemMeta(itemMeta);
        return result;
    }


}
