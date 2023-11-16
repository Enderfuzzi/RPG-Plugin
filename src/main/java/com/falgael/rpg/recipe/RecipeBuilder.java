package com.falgael.rpg.recipe;

import com.falgael.rpg.RPG;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
public class RecipeBuilder {

    private Plugin plugin;

    private ItemStack result;

    private ArrayList<ItemStack> ingredients = new ArrayList<>();

    private String key;

    private ArrayList<String> shape = new ArrayList<>();

    private HashMap<Character, ItemStack> mappedIngredients = new HashMap<>();

    private RecipeType type;

    private CraftingBookCategory craftingBookCategory = CraftingBookCategory.MISC;

    public enum RecipeType {
        STONECUTTER,
        SHAPELESS,
        SHAPED
    }

    public RecipeBuilder(Plugin plugin, Material result, String key, RecipeType type) {
        this(plugin, result, key, type);
    }

    public RecipeBuilder(Plugin plugin, ItemStack result, String key, RecipeType type) {
        this.plugin = plugin;
        this.result = result;
        this.key = key;
        this.type = type;
    }

    public RecipeBuilder addIngredient(ItemStack ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public RecipeBuilder addIngredient(Character key, ItemStack ingredient) {
        mappedIngredients.put(key,ingredient);
        return this;
    }

    public RecipeBuilder addShape(String row1, String row2, String row3) {
        shape.add(row1);
        shape.add(row2);
        shape.add(row3);
        return this;
    }

    public RecipeBuilder setCategory(CraftingBookCategory craftingBookCategory) {
        this.craftingBookCategory = craftingBookCategory;
        return this;
    }

    public Recipe create(NamespacedKey namespacedKey) {
        switch (type) {
            case STONECUTTER:
                return new StonecuttingRecipe(namespacedKey,result,new RecipeChoice.ExactChoice(ingredients));
            case SHAPED:
                ShapedRecipe resultRecipe = new ShapedRecipe(namespacedKey,result);
                resultRecipe.shape(shape.get(0),shape.get(1),shape.get(2));
                for (Map.Entry<Character,ItemStack> tmp : mappedIngredients.entrySet()) {
                    resultRecipe.setIngredient(tmp.getKey(),new RecipeChoice.ExactChoice(ingredients));
                }
                resultRecipe.setCategory(craftingBookCategory);
                return resultRecipe;
            case SHAPELESS:
            default:
                ShapelessRecipe shapelessRecipe = new ShapelessRecipe(namespacedKey,result).addIngredient(new RecipeChoice.ExactChoice(ingredients));
                shapelessRecipe.setCategory(craftingBookCategory);
                return shapelessRecipe;
        }
    }


    public Recipe create(Plugin plugin) {
        return create(new NamespacedKey(plugin, key));
    }




}
*/