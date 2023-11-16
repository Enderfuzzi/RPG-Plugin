package com.falgael.rpg.items;

import org.bukkit.inventory.ItemStack;

public interface ItemStackManipulation {

    default ItemStack modifyItemAmount(ItemStack itemStack, int amount) {
        ItemStack result = new ItemStack(itemStack);
        result.setAmount(amount);
        return result;
    }



}
