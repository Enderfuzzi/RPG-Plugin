package com.falgael.rpg.proficiencies.templates;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.items.ItemConfiguration;
import com.falgael.rpg.utility.Pair;
import com.falgael.rpg.villager.Villager;
import com.falgael.rpg.villager.VillagerManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.Recipe;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides the framework for proficiencies.
 * @author falgael
 * @version 0.0.1
 */
public abstract class ProficiencyFramework implements Serializable {
    @Serial
    private static final long serialVersionUID = 4139975922284126208L;

    /** Current amount of Experience*/
    protected int currentExperience = 0;
    /** The current Level */
    protected int currentLVL = 0;
    /** The Experience to Reach the next level */
    protected int currentExperienceBorder = 10;
    /** The maximum level a player can reach in this skill */
    protected int lvlBorder = 100;

    /**
     * Increases the current {@link ProficiencyFramework#currentExperience} by the specified {@code int}.
     * Returns always {@code false} if {@link ProficiencyFramework#lvlBorder} is reached or the given amount is zero or less.
     * Calls {@link ProficiencyFramework#increaseLVL()} when {@link ProficiencyFramework#currentExperienceBorder} is reached.
     * @param amount the proficiencies to add
     * @return {@code true} if the increase is successful
     */
    public boolean increaseExperience(int amount) {
        if (amount <= 0 || currentLVL == lvlBorder) return false;
        currentExperience += amount;
        while (getCurrentExperienceBorder() <= currentExperience) {
            currentExperience -= getCurrentExperienceBorder();
            increaseLVL();
        }
        return true;
    }

    /**
     * Increases the Level by one and calls {@link ProficiencyFramework#generateNextBorder()}
     */
    protected void increaseLVL() {
        currentLVL++;
        generateNextBorder();
    }

    /**
     * @return the current proficiencies border
     */
    public int getCurrentExperienceBorder() {
        return currentExperienceBorder;
    }
    /** @return the current amount of proficiencies */
    public int getCurrentExperience() {
        return currentExperience;
    }
    /** @return the current level of the proficiency*/
    public int getCurrentLVL() {
        return currentLVL;
    }
    /**
     * Generates the next border for the next level up
     */
    protected abstract void generateNextBorder();

    /** @return The String representation of this proficiency */
    public abstract String getProficiencyRepresentation();

    //--------------------------------------------------------------------------------------------
    // Block breaking
    //--------------------------------------------------------------------------------------------

    /** Contains a list of a Material that gives Experience on destruction with the amount of Experience */
    protected HashMap<Material,Integer> blockBreakingExperience = fillBlockBreakingExperience();

    /** Fills {@link ProficiencyFramework#blockBreakingExperience} with {@code Material} which gives Experience when Breaking with specific amount */
    protected abstract HashMap<Material,Integer> fillBlockBreakingExperience();

    /**
     * @param b The {@code Block} to check for
     * @return {@code true} when the material is in list
     */
    public boolean givesBlockBreakingExperience(Block b) {
        if (b == null) return false;
        return blockBreakingExperience.containsKey(b.getType());
    }

    /**
     * Gives the number of proficiencies a block gives when broken
     * @param b The {@code Block} to get the proficiencies amount
     * @return the amount of proficiencies assigned to the specified {@code Material}
     */
    public int amountBlockBreakingExperience(Block b) {
        if (givesBlockBreakingExperience(b)) {
            return blockBreakingExperience.get(b.getType());
        }
        return 0;
    }

    //--------------------------------------------------------------------------------------------
    // Block Crafting
    //--------------------------------------------------------------------------------------------

    /**
     *  Contains a list of a Material that gives Experience on crafting with the amount of Experience
     */
    protected HashMap<Material,Integer> blockCraftingExperience = fillBlockCraftingExperience();

    /** Fills {@link ProficiencyFramework#blockCraftingExperience} with {@code Material} which gives Experience when Crafting with specific amount */
    protected abstract HashMap<Material,Integer> fillBlockCraftingExperience();

    /**
     * Checks if a crafting recipe gives proficiencies on crafting. Override this function for other functionality
     * @param m The {@code Material} to check
     * @param craftingInventory can be null, when given only crafting table is allowed
     * @return {@code true} when the material is in list
     */
    public  boolean givesBlockCraftingExperience(Material m, CraftingInventory craftingInventory) {
        if (craftingInventory != null && craftingInventory.getType() != InventoryType.WORKBENCH) return false;
        return  blockCraftingExperience.containsKey(m);
    }

    /**
     * Gives the number of proficiencies a block gives when crafted
     * @param m The {@code Material} to get the proficiencies amount
     * @return the amount of proficiencies assigned to the specified {@code Material}
     */
    public int amountBlockCraftingExperience(Material m) {
        if (givesBlockCraftingExperience(m,null)) {
            return blockCraftingExperience.get(m);
        }
        return 0;
    }

    //--------------------------------------------------------------------------------------------
    // Forbidden recipes for this Proficiency
    //--------------------------------------------------------------------------------------------

    /**
     * Contains a list with {@code Material} which is forbidden to craft currently
     */
    protected ArrayList<Material> forbiddenCraftingRecipes = fillForbiddenCraftingRecipes();
    /** Fills {@link ProficiencyFramework#forbiddenCraftingRecipes with {@code Material}*/
    protected abstract ArrayList<Material> fillForbiddenCraftingRecipes();

    /**
     * Checks if a given Material is forbidden to craft.
     * @param m The resulting {@code Material} to check
     * @return {@code true} if the given {@code Material} is in the list
     */
    public boolean isForbiddenToCraft(Material m) {
        return forbiddenCraftingRecipes.contains(m);
    }


    //--------------------------------------------------------------------------------------------
    // Generally Forbidden recipe of this Proficiency gets stored in extra list
    //--------------------------------------------------------------------------------------------

    /**
     * Method to register a general forbidden crafting result
     * @param material The result to forbid
     */
    protected static void registerGenerallyForbiddenCraftingResult(Material material) {
        ProficiencyDataHolder.addGeneralForbiddenCraftingResult(material);
    }

    //--------------------------------------------------------------------------------------------
    // Items added by this Proficiency
    //--------------------------------------------------------------------------------------------

    /**
     * register the items of a proficiency to {@link ProficiencyDataHolder}
     * @param key The representation of the proficiency
     * @param list The list of items to add
     */
    protected static void registerItemOfThisProficiency(String key, HashMap<ItemStack, ItemConfiguration> list) {
        ProficiencyDataHolder.addItemsToAllProficiencies(key, list);
    }


    /**
     * Needed for initialization of items and forbidden crafting results of a proficiency.
     * implement this with usage of {@link ProficiencyFramework#registerGenerallyForbiddenCraftingResult(Material)} and
     * {@link ProficiencyFramework#registerItemOfThisProficiency(String, HashMap)}.
     */
    public abstract void initialize();


    /** Refills the lists after loading the class */
    public void internalInitialize() {
        blockBreakingExperience = fillBlockBreakingExperience();
        blockCraftingExperience = fillBlockCraftingExperience();
    }


    protected static void registerVillager(String key, Villager villager) {
        VillagerManager.registerVillager(key, villager);
        Bukkit.getLogger().info("Registered Villager with key: " + key);
    }



    protected void registerRecipes(HashMap<Recipe,Integer> recipes) {
        for (Map.Entry<Recipe,Integer> entry : recipes.entrySet()) {
            ProficiencyDataHolder.registerRecipe(entry.getKey(), new Pair<>(getProficiencyRepresentation(),entry.getValue()));
        }
    }


}
