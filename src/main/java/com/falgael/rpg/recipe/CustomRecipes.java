package com.falgael.rpg.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class CustomRecipes {
    // Note Loading these Recipes is placed in initializer


    private Plugin plugin;


    public CustomRecipes(Plugin plugin) {
        this.plugin = plugin;
        getRecipes().forEach(r -> {
            Bukkit.addRecipe(r);
            if (r instanceof Keyed k) Bukkit.getLogger().info("Registered Recipe with name: " + k.getKey());
        });
    }

    protected NamespacedKey namespacedKey(String key) {
        return new NamespacedKey(plugin, key);
    }

    protected abstract List<Recipe> getRecipes();

    @Deprecated
    public class RecipeBuilder {
        private ItemStack result;

        private ArrayList<ItemStack> ingredients = new ArrayList<>();

        private String key;

        private ArrayList<String> shape = new ArrayList<>();

        private HashMap<Character, List<Material>> mappedIngredients = new HashMap<>();

        private RecipeBuilder.RecipeType type;

        private CraftingBookCategory craftingBookCategory = CraftingBookCategory.MISC;

        public enum RecipeType {
            STONECUTTER,
            SHAPELESS,
            SHAPED,
            FURNACE
        }

        public RecipeBuilder(Material result, String key, RecipeBuilder.RecipeType type) {
            this(new ItemStack(result), key, type);
        }

        public RecipeBuilder(ItemStack result, String key, RecipeBuilder.RecipeType type) {
            this.result = result;
            this.key = key;
            this.type = type;
        }

        public RecipeBuilder addIngredient(Material ingredient) {
            return addIngredient(new ItemStack(ingredient));
        }

        public RecipeBuilder addIngredient(ItemStack ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public RecipeBuilder addIngredient(Character key, Material... ingredient) {
            mappedIngredients.put(key, Arrays.stream(ingredient).toList());
            return this;
        }
        /*
        public RecipeBuilder addIngredient(Character key, ItemStack... ingredient) {
            mappedIngredients.put(key, ingredient);
            return this;
        }
         */


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
                    return new StonecuttingRecipe(namespacedKey, result, new RecipeChoice.ExactChoice(ingredients));
                case SHAPED:
                    ShapedRecipe resultRecipe = new ShapedRecipe(namespacedKey, result);
                    resultRecipe.shape(shape.get(0), shape.get(1), shape.get(2));
                    for (Map.Entry<Character, List<Material>> tmp : mappedIngredients.entrySet()) {
                        //resultRecipe.setIngredient(tmp.getKey().charValue(), tmp.getValue().getType());
                        resultRecipe.setIngredient(tmp.getKey(), new RecipeChoice.MaterialChoice(tmp.getValue()));
                    }
                    resultRecipe.setCategory(craftingBookCategory);
                    return resultRecipe;
                case FURNACE:
                    FurnaceRecipe furnaceRecipe = new FurnaceRecipe(
                            namespacedKey,
                            result,
                            ingredients.get(0).getType(),
                            0.7f,
                            200
                    );
                    return furnaceRecipe;
                case SHAPELESS:
                default:
                    ShapelessRecipe shapelessRecipe = new ShapelessRecipe(namespacedKey, result).addIngredient(new RecipeChoice.ExactChoice(ingredients));
                    shapelessRecipe.setCategory(craftingBookCategory);
                    return shapelessRecipe;
            }
        }


        public Recipe create() {
            return create(new NamespacedKey(plugin, key));
        }


    }


}