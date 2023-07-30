package com.falgael.rpg.proficiencies.items;

import com.falgael.rpg.RPG;
import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.data.woodwork.WoodworkItems;
import com.falgael.rpg.utility.items.ItemCreation;
import com.falgael.rpg.utility.items.ItemInformation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
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
        RecipeChoice upgrade = new RecipeChoice.ExactChoice(ItemCreation.createAxe(Material.WOODEN_AXE,ItemInformation.SIMPLE_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                " Axe", 0.0, 0.5, 0.0, 0.0, ItemInformation.LOOT_MODIFIER_COLOR + "+50% More Wood","Simple tool for harvesting"));
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
    }
}
