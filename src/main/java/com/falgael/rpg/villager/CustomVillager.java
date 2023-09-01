package com.falgael.rpg.villager;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomItem;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.recipe.MerchantRecipeBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


import java.util.HashMap;
import java.util.Set;

public enum CustomVillager {

    NONE("NONE", ProficiencyType.NONE, new VillagerInstance.VillagerBuilder("", org.bukkit.entity.Villager.Profession.NONE).create(),0),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------

    MISC_TIER_I(ProficiencyType.MISC.getName() + "_TIER_I", ProficiencyType.MISC,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + ProficiencyType.MISC.getRepresentation(), Villager.Profession.CARTOGRAPHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.GLOWSTONE, 4)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.LANTERN, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OCHRE_FROGLIGHT, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.PEARLESCENT_FROGLIGHT, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_LAMP, 4)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SOUL_LANTERN, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SEA_LANTERN, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SHROOMLIGHT, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.VERDANT_FROGLIGHT, 8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .create(), 0),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    WOODWORK_TIER_I(ProficiencyType.WOODWORK.getName() + "_TIER_I", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), org.bukkit.entity.Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.BAMBOO,32)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.BIRCH_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.CHERRY_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.CRIMSON_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.JUNGLE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.MANGROVE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.OAK_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.SPRUCE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.WARPED_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_COMMON_AXE.getItem()).addIngredients(CustomTool.WOODWORK_SIMPLE_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(),4)).create())
                    .create(),1),
    WOODWORK_TIER_II(ProficiencyType.WOODWORK.getName() + "_TIER_II", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.COMMON.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BONE_MEAL,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_SAPLING,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_SAPLING,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_FUNGUS,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_NYLIUM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_SAPLING,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_PROPAGULE,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_SAPLING,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_SAPLING,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_FUNGUS,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_NYLIUM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_ADVANCED_AXE.getItem()).addIngredients(CustomTool.WOODWORK_COMMON_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(),32)).create())
                    .create(), 5),

    WOODWORK_TIER_III(ProficiencyType.WOODWORK.getName() + "_TIER_III", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ADVANCED.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO_BLOCK,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_STEM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_STEM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_SHEARS.getItem()).addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(), 24)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_ELITE_AXE.getItem()).addIngredients(CustomTool.WOODWORK_ADVANCED_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),8)).create())
            .create(), 10),

    WOODWORK_TIER_IV(ProficiencyType.WOODWORK.getName() + "_TIER_IV", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ELITE.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_ACACIA_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BAMBOO_BLOCK,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BIRCH_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CHERRY_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CRIMSON_STEM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_JUNGLE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_MANGROVE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_OAK_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_SPRUCE_LOG,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_WARPED_STEM,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_EPIC_AXE.getItem()).addIngredients(CustomTool.WOODWORK_ELITE_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),32)).create())
                    .create(), 20),

    WOODWORK_TIER_V(ProficiencyType.WOODWORK.getName() + "_TIER_V", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.EPIC.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.NETHER_WART_BLOCK,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LEAVES,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_WART_BLOCK,64)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_LEGENDARY_AXE.getItem()).addIngredients(CustomTool.WOODWORK_EPIC_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),64)).create())
                    .create(), 40),

    WOODWORK_TIER_VI(ProficiencyType.WOODWORK.getName() + "_TIER_VI", ProficiencyType.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.LEGENDARY.getRepresentation() + ProficiencyType.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)


                    .create(), 60),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_TIER_I(ProficiencyType.STONEWORK.getName() + "_TIER_I", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.SIMPLE, ProficiencyType.STONEWORK),Villager.Profession.TOOLSMITH)
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.COBBLED_DEEPSLATE, 16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.COBBLESTONE, 32)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.DEEPSLATE, 16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.STONE, 32)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.SAND, 64)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.RED_SAND, 64)).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_COMMON_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_SIMPLE_PICKAXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(),4)).create())

                    .create(), 1),

    STONEWORK_TIER_II(ProficiencyType.STONEWORK.getName() + "_TIER_II", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.COMMON, ProficiencyType.STONEWORK), Villager.Profession.TOOLSMITH)
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.IRON_INGOT, 8)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.COPPER_INGOT, 8)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.GOLD_INGOT, 4)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomItem.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.LAPIS_LAZULI, 16)).create())


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_ADVANCED_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_COMMON_PICKAXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(),32)).create())

                    .create(), 5),

    STONEWORK_TIER_III(ProficiencyType.STONEWORK.getName() + "_TIER_III", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.ADVANCED, ProficiencyType.STONEWORK), Villager.Profession.TOOLSMITH)

                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.COAL,32)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.IRON_INGOT,8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.COPPER_INGOT,8)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.GOLD_INGOT,4)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.LAPIS_LAZULI,16)).addIngredients(CustomItem.MISC_IRON_NUGGET.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_ELITE_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_ADVANCED_PICKAXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),8)).create())
                    .create(), 10),

    STONEWORK_TIER_IV(ProficiencyType.STONEWORK.getName() + "_TIER_IV", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.ELITE, ProficiencyType.STONEWORK), Villager.Profession.TOOLSMITH)
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_EPIC_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_ELITE_PICKAXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),32)).create())
                    .create(), 20),

    STONEWORK_TIER_V(ProficiencyType.STONEWORK.getName() + "_TIER_V", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.EPIC, ProficiencyType.STONEWORK), Villager.Profession.TOOLSMITH)
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_LEGENDARY_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_EPIC_PICKAXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_GOLD_NUGGET.getItem(),64)).create())
                    .create(), 40),

    STONEWORK_TIER_VI(ProficiencyType.STONEWORK.getName() + "_TIER_VI", ProficiencyType.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.LEGENDARY, ProficiencyType.STONEWORK), Villager.Profession.TOOLSMITH)


                    .create(), 60),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_TIER_I(ProficiencyType.FARMING.getName() + "_TIER_I", ProficiencyType.FARMING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.SIMPLE, ProficiencyType.FARMING), Villager.Profession.FARMER)
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.FARMING_COMMON_HOE.getItem()).addIngredients(CustomTool.FARMING_SIMPLE_HOE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomItem.MISC_IRON_NUGGET.getItem(), 4)).create())

                    .create(), 1),

    ;
    private final String key;

    private final ProficiencyType proficiency;

    private final int levelRequirement;

    private final VillagerInstance villagerInstance;

    private static final HashMap<String, CustomVillager> villagers = new HashMap<>();

    static {
        for (CustomVillager customVillager : CustomVillager.values()) {
            if (villagers.containsKey(customVillager.key)) {
                Bukkit.getLogger().warning("[" + CustomVillager.class.getSimpleName() + "]: Double registered Key: " + customVillager.key);
                continue;
            }
            villagers.put(customVillager.key,customVillager);
        }


    }

    CustomVillager(String key, ProficiencyType proficiency , VillagerInstance villagerInstance, int levelRequirement) {
        this.key = key;
        this.proficiency = proficiency;
        this.villagerInstance = villagerInstance;
        this.levelRequirement = levelRequirement;
    }

    public ProficiencyType getProficiency() {
        return proficiency;
    }

    public VillagerInstance getVillager() {
        return villagerInstance;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static CustomVillager getVillager(String key) {
        return villagers.getOrDefault(key, NONE);
    }

    public static CustomVillager getVillager(Villager villager) {
        for (CustomVillager customVillager : CustomVillager.values()) {
            if (customVillager.villagerInstance.isSame(villager)) return customVillager;
        }
        return NONE;
    }


    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Contract(pure = true)
    public static @NotNull Set<String> getVillagerKeys() {
        return villagers.keySet();
    }

    private static String buildName(Rarity rarity, ProficiencyType proficiencyType) {
        return rarity.getRepresentation() + proficiencyType.getRepresentation();
    }


}
