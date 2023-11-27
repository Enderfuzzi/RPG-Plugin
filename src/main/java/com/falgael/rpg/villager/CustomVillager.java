package com.falgael.rpg.villager;

import com.falgael.rpg.items.ItemStackManipulation;
import com.falgael.rpg.items.set.NameBuilding;

public enum CustomVillager implements ItemStackManipulation, NameBuilding {

    /*
    NONE(Rarity.NONE, Proficiency.NONE,Villager.Profession.NONE),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------

    LIGHTING(Rarity.COMMON, Proficiency.MISC, Villager.Profession.CARTOGRAPHER,
            new MerchantRecipeBuilder(new ItemStack(Material.GLOWSTONE, 4)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.OCHRE_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.PEARLESCENT_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_LAMP, 4)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SOUL_LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SEA_LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SHROOMLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.VERDANT_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),


    /*
    MISC_TIER_I(Proficiency.MISC.getName() + "_TIER_I", Proficiency.MISC,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + Proficiency.MISC.getRepresentation(), Villager.Profession.CARTOGRAPHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.GLOWSTONE, 4)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OCHRE_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.PEARLESCENT_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_LAMP, 4)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SOUL_LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SEA_LANTERN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SHROOMLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.VERDANT_FROGLIGHT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .create(), 0),
    */

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    /*
    CARPENTER_1(Rarity.SIMPLE, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 1,
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BAMBOO,32)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BIRCH_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.CHERRY_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.CRIMSON_STEM,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.JUNGLE_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.MANGROVE_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.OAK_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.SPRUCE_LOG,16)).create(),
            new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.WARPED_STEM,16)).create()
    ),
    /*
    WOODWORK_TIER_I(Proficiency.WOODWORK.getName() + "_TIER_I", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BAMBOO,32)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BIRCH_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.CHERRY_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.CRIMSON_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.JUNGLE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.MANGROVE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.OAK_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.SPRUCE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.WARPED_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_COMMON_AXE.getItem()).addIngredients(CustomTool.WOODWORK_BASIC_SIMPLE_AXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(),4)).create())
                    .create(),1),

     */
    /*
    CARPENTER_2(Rarity.COMMON, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 5,
            new MerchantRecipeBuilder(new ItemStack(Material.BONE_MEAL,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_PROPAGULE,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.OAK_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.WARPED_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.WARPED_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),
    /*
    WOODWORK_TIER_II(Proficiency.WOODWORK.getName() + "_TIER_II", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.COMMON.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BONE_MEAL,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_PROPAGULE,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_ADVANCED_AXE.getItem()).addIngredients(CustomTool.WOODWORK_COMMON_AXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(),32)).create())
                    .create(), 5),


     */
    /*
    CARPENTER_3(Rarity.ADVANCED, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 10,
            new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO_BLOCK,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.OAK_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.WARPED_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),
    /*
    WOODWORK_TIER_III(Proficiency.WOODWORK.getName() + "_TIER_III", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ADVANCED.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO_BLOCK,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_SHEARS.getItem()).addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(), 24)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_ELITE_AXE.getItem()).addIngredients(CustomTool.WOODWORK_ADVANCED_AXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(),8)).create())
            .create(), 10),


     */
/*
    CARPENTER_4(Rarity.ELITE, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 20,
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_ACACIA_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BAMBOO_BLOCK,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BIRCH_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CHERRY_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CRIMSON_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_JUNGLE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_MANGROVE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_OAK_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_SPRUCE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_WARPED_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),
    /*
    WOODWORK_TIER_IV(Proficiency.WOODWORK.getName() + "_TIER_IV", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ELITE.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), CustomVillager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_ACACIA_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BAMBOO_BLOCK,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_BIRCH_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CHERRY_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_CRIMSON_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_JUNGLE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_MANGROVE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_OAK_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_SPRUCE_LOG,16)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.STRIPPED_WARPED_STEM,16)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_EPIC_AXE.getItem()).addIngredients(CustomTool.WOODWORK_ELITE_AXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(),32)).create())
                    .create(), 20),


     */
    /*
    CARPENTER_5(Rarity.EPIC, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 40,
            new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.NETHER_WART_BLOCK,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.OAK_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create(),
            new MerchantRecipeBuilder(new ItemStack(Material.WARPED_WART_BLOCK,64)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),
    /*
    WOODWORK_TIER_V(Proficiency.WOODWORK.getName() + "_TIER_V", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.EPIC.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), CustomVillager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BIRCH_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.NETHER_WART_BLOCK,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_LEAVES,64)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_WART_BLOCK,64)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.WOODWORK_LEGENDARY_AXE.getItem()).addIngredients(CustomTool.WOODWORK_EPIC_AXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(),64)).create())
                    .create(), 40),


     */
    /*
    CARPENTER_6(Rarity.LEGENDARY, Proficiency.WOODWORK, Villager.Profession.BUTCHER, 50
            ),
    /*
    WOODWORK_TIER_VI(Proficiency.WOODWORK.getName() + "_TIER_VI", Proficiency.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.LEGENDARY.getRepresentation() + Proficiency.WOODWORK.getRepresentation(), CustomVillager.Profession.BUTCHER)


                    .create(), 60),


     */

    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
/*
    MASON_1(Rarity.SIMPLE, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 1,
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COBBLED_DEEPSLATE, 16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COBBLESTONE, 32)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.DEEPSLATE, 16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.STONE, 32)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.SAND, 64)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.RED_SAND, 64)).create()
    ),

    MASON_2(Rarity.COMMON, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 5,
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.IRON_INGOT, 8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COPPER_INGOT, 8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.GOLD_INGOT, 4)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.LAPIS_LAZULI, 16)).create()
    ),


/*
    STONEWORK_TIER_II(Proficiency.STONEWORK.getName() + "_TIER_II", Proficiency.STONEWORK,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.COMMON, Proficiency.STONEWORK), CustomVillager.Profession.TOOLSMITH)
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.IRON_INGOT, 8)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COPPER_INGOT, 8)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.GOLD_INGOT, 4)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.LAPIS_LAZULI, 16)).create())


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.STONEWORK_ADVANCED_PICKAXE.getItem()).addIngredients(CustomTool.STONEWORK_COMMON_PICKAXE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(),32)).create())

                    .create(), 5),


 */
    /*
    MASON_3(Rarity.ADVANCED, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 10,

                    new MerchantRecipeBuilder(new ItemStack(Material.COAL,32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.IRON_INGOT,8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COPPER_INGOT,8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.GOLD_INGOT,4)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.LAPIS_LAZULI,16)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.QUARTZ_BLOCK,16)).addIngredients(Items.SILVER_COIN.getItem()).create()
    ),

    MASON_4(Rarity.ELITE, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 20,
                    new MerchantRecipeBuilder(new ItemStack(Material.WHITE_CONCRETE,1)).addIngredients(new ItemStack(Material.WHITE_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.ORANGE_CONCRETE,1)).addIngredients(new ItemStack(Material.ORANGE_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.MAGENTA_CONCRETE,1)).addIngredients(new ItemStack(Material.MAGENTA_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.LIGHT_BLUE_CONCRETE,1)).addIngredients(new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.YELLOW_CONCRETE,1)).addIngredients(new ItemStack(Material.YELLOW_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.LIME_CONCRETE,1)).addIngredients(new ItemStack(Material.LIME_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.PINK_CONCRETE,1)).addIngredients(new ItemStack(Material.PINK_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.GRAY_CONCRETE,1)).addIngredients(new ItemStack(Material.GRAY_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.LIGHT_GRAY_CONCRETE,1)).addIngredients(new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.CYAN_CONCRETE,1)).addIngredients(new ItemStack(Material.CYAN_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.PURPLE_CONCRETE,1)).addIngredients(new ItemStack(Material.PURPLE_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.BLUE_CONCRETE,1)).addIngredients(new ItemStack(Material.BLUE_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.BROWN_CONCRETE,1)).addIngredients(new ItemStack(Material.BROWN_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.GREEN_CONCRETE,1)).addIngredients(new ItemStack(Material.GREEN_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.RED_CONCRETE,1)).addIngredients(new ItemStack(Material.RED_CONCRETE_POWDER)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.BLACK_CONCRETE,1)).addIngredients(new ItemStack(Material.BLACK_CONCRETE_POWDER)).create()
    ),

    MASON_5(Rarity.EPIC, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 40

    ),

    MASON_6(Rarity.LEGENDARY, Proficiency.STONEWORK, Villager.Profession.TOOLSMITH, 60

    ),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMER_1(Rarity.SIMPLE, Proficiency.FARMING, Villager.Profession.FARMER, 0,
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.WHEAT,16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.CARROT,32)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.POTATO,32)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BEETROOT,16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.NETHER_WART,16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.MELON,16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.PUMPKIN,16)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.HONEY_BLOCK,4)).create(),

                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_BEEF,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_CHICKEN,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_PORKCHOP,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_MUTTON,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_RABBIT,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_SALMON,8)).create(),
                    new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.COOKED_COD,8)).create()
    ),

    FARMER_2(Rarity.COMMON, Proficiency.FARMING, Villager.Profession.FARMER, 5,
                    new MerchantRecipeBuilder(new ItemStack(Material.WHEAT_SEEDS, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.BEETROOT_SEEDS, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.MELON_SEEDS, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.PUMPKIN_SEEDS, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.CARROT, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.POTATO, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.NETHER_WART, 32)).addIngredients(Items.SILVER_COIN.getItem()).create(),

                    new MerchantRecipeBuilder(new ItemStack(Material.BEE_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COW_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.PIG_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.CHICKEN_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.RABBIT_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.SALMON_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COD_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.TROPICAL_FISH_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 16)).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.PUFFERFISH_SPAWN_EGG)).addIngredients(ItemStackManipulation.modifyItemAmount(Items.SILVER_COIN.getItem(), 16)).create()
    ),

    FARMER_3(Rarity.ADVANCED, Proficiency.FARMING, Villager.Profession.FARMER, 10,
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_BEEF, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_CHICKEN, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_PORKCHOP, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_MUTTON, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_RABBIT, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_COD, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),
                    new MerchantRecipeBuilder(new ItemStack(Material.COOKED_SALMON, 8)).addIngredients(Items.SILVER_COIN.getItem()).create(),

                    new MerchantRecipeBuilder(Items.GOLD_COIN.getItem()).addIngredients(new ItemStack(Material.NETHER_WART_BLOCK,16)).create()
            ),
    /*
    FARMER_4(Rarity.ELITE, Proficiency.FARMING.getName() + "_TIER_IV", Proficiency.FARMING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.ELITE, Proficiency.FARMING), CustomVillager.Profession.FARMER)

                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.FLOWER_POT, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.DANDELION, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.POPPY, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BLUE_ORCHID, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.AZURE_BLUET, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.DANDELION, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ORANGE_TULIP, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.PINK_TULIP, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.RED_TULIP, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WHITE_TULIP, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OXEYE_DAISY, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CORNFLOWER, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.LILY_OF_THE_VALLEY, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.TORCHFLOWER, 32)).addIngredients(Items.SILVER_COIN.getItem()).create())


                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WITHER_ROSE, 16)).addIngredients(Items.SILVER_COIN.getItem()).create())

                    .create(), 20),

    FARMING_TIER_V(Proficiency.FARMING.getName() + "_TIER_V", Proficiency.FARMING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.EPIC, Proficiency.FARMING), CustomVillager.Profession.FARMER)



                    .addRecipe(new MerchantRecipeBuilder(CustomTool.FARMING_LEGENDARY_HOE.getItem()).addIngredients(CustomTool.FARMING_EPIC_HOE.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 64)).create())
                    .create(), 40),

    FARMING_TIER_VI(Proficiency.FARMING.getName() + "_TIER_VI", Proficiency.FARMING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.LEGENDARY, Proficiency.FARMING), CustomVillager.Profession.FARMER)




                    .create(), 60),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    HUNTING_TIER_I(Proficiency.HUNTING.getName() + "_TIER_I", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.SIMPLE, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)

                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.ROTTEN_FLESH,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.GUNPOWDER,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.STRING,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.BONE,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.SPIDER_EYE,8)).create())

                    .addRecipe(new MerchantRecipeBuilder(Items.SILVER_COIN.getItem()).addIngredients(new ItemStack(Material.ENDER_PEARL,4)).create())

                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_COMMON_SWORD.getItem()).addIngredients(CustomTool.HUNTING_SIMPLE_SWORD.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(), 4)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_COMMON_BOW.getItem()).addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(), 8)).create())
                    .create(),1),
    HUNTING_TIER_II(Proficiency.HUNTING.getName() + "_TIER_II", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.COMMON, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_ADVANCED_SWORD.getItem()).addIngredients(CustomTool.HUNTING_COMMON_SWORD.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.SILVER_COIN.getItem(), 32)).create())
                    .create(),5),
    HUNTING_TIER_III(Proficiency.HUNTING.getName() + "_TIER_III", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.ADVANCED, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_ELITE_SWORD.getItem()).addIngredients(CustomTool.HUNTING_ADVANCED_SWORD.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 8)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_ELITE_BOW.getItem()).addIngredients(CustomTool.HUNTING_COMMON_BOW.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 16)).create())
                    .create(),10),
    HUNTING_TIER_IV(Proficiency.HUNTING.getName() + "_TIER_IV", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.ELITE, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_EPIC_SWORD.getItem()).addIngredients(CustomTool.HUNTING_ELITE_SWORD.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 32)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_EPIC_BOW.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 64)).create())
                    .create(),20),
    HUNTING_TIER_V(Proficiency.HUNTING.getName() + "_TIER_V", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.EPIC, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)


                    .addRecipe(new MerchantRecipeBuilder(CustomTool.HUNTING_LEGENDARY_SWORD.getItem()).addIngredients(CustomTool.HUNTING_EPIC_SWORD.getItem())
                            .addIngredients(Utils.modifyItemAmount(Items.MISC_GOLD_NUGGET.getItem(), 64)).create())
                    .create(),40),
    HUNTING_TIER_VI(Proficiency.HUNTING.getName() + "_TIER_VI", Proficiency.HUNTING,
            new VillagerInstance.VillagerBuilder(buildName(Rarity.LEGENDARY, Proficiency.HUNTING), CustomVillager.Profession.WEAPONSMITH)


                    .create(),60),



     */
    ;

    /*
    private final Proficiency proficiency;

    private final int levelRequirement;

    private final VillagerInstance villagerInstance;

    private static final HashMap<String, CustomVillager> villagers = new HashMap<>();

    static {
        for (CustomVillager customVillager : CustomVillager.values()) {
            villagers.put(customVillager.name(),customVillager);
        }


    }

    CustomVillager(Rarity rarity, Proficiency proficiency, Villager.Profession profession, MerchantRecipe... recipes) {
        this(rarity, proficiency, profession, 0,recipes);
    }

    CustomVillager(Rarity rarity, Proficiency proficiency, Villager.Profession profession,  int levelRequirement, MerchantRecipe... recipes) {
        this.proficiency = proficiency;
        VillagerInstance.VillagerBuilder tmp = new VillagerInstance.VillagerBuilder(rarity.getColor() + buildName(this.name()), profession);
        for (MerchantRecipe recipe : recipes) {
            tmp.add(recipe);
        }
        this.villagerInstance = tmp.create();
        this.levelRequirement = levelRequirement;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public VillagerInstance getVillager() {
        return villagerInstance;
    }

    public boolean isNone() {
        return this == this;
    }

    public static boolean getVillager(String key) {
        //return villagers.getOrDefault(key, NONE);
        return true;
    }

    public static CustomVillager getVillager(org.bukkit.entity.Villager villager) {
        for (CustomVillager customVillager : CustomVillager.values()) {
            if (customVillager.villagerInstance.isSame(villager)) return customVillager;
        }
        return NONE;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Contract(pure = true)
    public static @NotNull DefaultItemSet<String> getVillagerKeys() {
        return villagers.keySet();
    }

    private static String buildName(Rarity rarity, Proficiency proficiency) {
        return rarity.getRepresentation() + proficiency.getRepresentation();
    }


     */

}
