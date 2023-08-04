package com.falgael.rpg.proficiencies.items;

import com.falgael.rpg.RPG;
import com.falgael.rpg.proficiencies.data.woodwork.WoodworkItems;
import com.falgael.rpg.utility.items.ItemCreation;
import com.falgael.rpg.utility.items.ItemFactory;
import com.falgael.rpg.utility.recipe.RecipeBuilder;
import com.falgael.rpg.utility.recipe.RecipeType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.recipe.CraftingBookCategory;

public class SpecialCraftingRecipe {


    private ItemStack[] ingredients = new ItemStack[9];

    private ItemStack result = new ItemStack(Material.AIR);


    public SpecialCraftingRecipe(ItemStack[] ingredients, ItemStack result) {
        if (ingredients.length != 9) {

        }
        this.ingredients = ingredients;
        this.result = result;
    }


    public boolean compare(ItemStack[] ingredients) {
        if (ingredients.length != this.ingredients.length) return false;
        for (int i = 0; i < this.ingredients.length; i++) {
            if (!this.ingredients[i].equals(ingredients[i])) return false;
        }
        return true;
    }

    public ItemStack getResult() {
        return result;
    }

    public static void testRecipe() {

        ItemStack item = ItemCreation.createItem(Material.STONE);
        RecipeChoice upgrade = new RecipeChoice.ExactChoice(WoodworkItems.SIMPLE_AXE);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME),"upgradecore"),item);
        recipe.shape(" S ","   ","   ");
        recipe.setIngredient('S',upgrade);
        //recipe.setIngredient('A',Material.AIR);
        recipe.setCategory(CraftingBookCategory.EQUIPMENT);
        //ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME),"upgradecore"),item);
        //recipe.addIngredient(upgrade);
        //Bukkit.addRecipe(recipe);
        Bukkit.getLogger().info("Added recipe");
        Bukkit.addRecipe(recipe);


        ItemStack item2 = new ItemFactory(Material.OAK_STAIRS).setAmount(4).create();
        RecipeChoice upgrade2 = new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG));
        StonecuttingRecipe recipe2 = new StonecuttingRecipe(new NamespacedKey(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME),"upgradecore2"),item2,upgrade2);
        Bukkit.addRecipe(recipe2);

        ItemStack item3 = new ItemFactory(Material.OAK_SLAB).setAmount(12).create();
        RecipeChoice upgrade3 = new RecipeChoice.ExactChoice(new ItemStack(Material.OAK_LOG));
        StonecuttingRecipe recipe3 = new StonecuttingRecipe(new NamespacedKey(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME),"upgradecore3"),item3,upgrade3);
        Bukkit.addRecipe(recipe3);


        Bukkit.addRecipe(new RecipeBuilder(new ItemStack(Material.OAK_SLAB), "STAIR_TO_SLAB", RecipeType.STONECUTTER)
                .addIngredient(new ItemStack(Material.OAK_STAIRS)).create());



    }
}
