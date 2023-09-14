package com.falgael.rpg.proficiency.items;


import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.items.ItemModifier;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.effects.CropPlant;
import com.falgael.rpg.proficiency.items.effects.FurnaceBurn;
import com.falgael.rpg.proficiency.items.effects.WeatherChange;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

/**
 * Provides the definition for CustomItems.
 * A CustomItem contains a Proficiency and an ItemStack. Optionally a configuration can be added.
 * @author falgael
 * @version 0.0.1
 */
public enum CustomItem {
    /**
     * Value for a non defined Tool. Returned if an Item is not found on search.
     */
    NONE(ProficiencyType.NONE, new ItemStack(Material.AIR)),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------
    MISC_IRON_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.IRON_NUGGET).setName("Silver Coin").setCurrency().setRarity(Rarity.NONE).create()),
    MISC_GOLD_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.GOLD_NUGGET).setName("Gold Coin").setCurrency().setRarity(Rarity.NONE).create()),

    MISC_STAT_O_METER(ProficiencyType.MISC, new ItemBuilder(Material.AMETHYST_SHARD).setName("Stat-O-Meter").visibleEnchanted().setRarity(Rarity.LEGENDARY).create()),

    MISC_ADVANCED_WEATHER_CLEAR(ProficiencyType.MISC, new ItemBuilder(Material.GOAT_HORN).setName("Weather clearer").visibleEnchanted().setRarity(Rarity.ADVANCED).setMusicInstrument(MusicInstrument.SING).create(),
     new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> WeatherChange.weatherClear(e,6000)).create()),

    MISC_EPIC_WEATHER_CLEAR(ProficiencyType.MISC, new ItemBuilder(Material.GOAT_HORN).setName("Sunshine Creator").visibleEnchanted().setRarity(Rarity.EPIC).setMusicInstrument(MusicInstrument.PONDER).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> WeatherChange.weatherClear(e,12000)).create()),
    MISC_EPIC_WEATHER_RAIN(ProficiencyType.MISC, new ItemBuilder(Material.GOAT_HORN).setName("Rain Creator").visibleEnchanted().setRarity(Rarity.EPIC).setMusicInstrument(MusicInstrument.SEEK).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> WeatherChange.weatherRain(e,6000)).create()),

    MISC_EPIC_WEATHER_THUNDER(ProficiencyType.MISC, new ItemBuilder(Material.GOAT_HORN).setName("Thunder Creator").visibleEnchanted().setRarity(Rarity.EPIC).setMusicInstrument(MusicInstrument.FEEL).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> WeatherChange.weatherStorm(e,6000)).create()),

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    WOODWORK_COMPRESSED_OAK(ProficiencyType.WOODWORK, new ItemBuilder(Material.OAK_WOOD).addProficiency(ProficiencyType.WOODWORK).setCompressed().create()),



    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
    STONEWORK_COMPRESSED_STONE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE).addProficiency(ProficiencyType.STONEWORK).setCompressed().create()),


    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ADVANCED).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "10").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.1))
            .create()),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, new ItemBuilder(Material.CHARCOAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ELITE).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "50").addLore("Burning until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.5))
            .create()),

    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL_BLOCK).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.EPIC).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "75").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.75))
            .create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_COMPRESSED_WHEAT(ProficiencyType.FARMING, new ItemBuilder(Material.HAY_BLOCK).addProficiency(ProficiencyType.FARMING).setCompressed().create()),

    FARMING_SEED_PLANTER(ProficiencyType.FARMING, new ItemBuilder(Material.ECHO_SHARD).addProficiency(ProficiencyType.FARMING).visibleEnchanted().setRarity(Rarity.ADVANCED).setName("Planter").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> CropPlant.effect(e, 5, Material.WHEAT, Material.FARMLAND))
                    .create()),

    ;

    /**
     * Configuration of the Item. This can be {@code null} if the Item has no configuration.
     */
    private final ItemConfiguration configuration;

    /**
     * @return the ItemStack of the CustomTool
     */
    private final ItemStack itemStack;

    /**
     * @return Proficiency Type of the CustomTool
     */
    private final ProficiencyType type;

    CustomItem(ProficiencyType type, ItemStack itemStack) {
        this(type, itemStack, null);
    }

    CustomItem(ProficiencyType type, ItemStack itemStack, ItemConfiguration itemConfiguration) {
        this.type = type;
        this.itemStack = itemStack;
        this.configuration = itemConfiguration;
    }
    /**
     * @return the ItemStack of the CustomTool
     */
    public ItemStack getItem() {
        return itemStack;
    }
    /**
     * @return Proficiency Type of the CustomTool
     */
    public ProficiencyType getType() {
        return type;
    }

    /**
     * Checks if the current CustomTool is equals to {@link CustomItem#NONE}
     * @return {@code true} if CustomTool equals {@link CustomItem#NONE}
     */
    public boolean isNone() {
        return NONE == this;
    }

    /**
     * @return {@code true} if
     */
    public boolean hasConfiguration() {
        return configuration != null;
    }

    /**
     * @return Configuration of this Tool
     */
    public ItemConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Specific Check for a Stat-Meter. Compares the given ItemStack with each defined CustomItem. <br>
     * Compares the following arguments: <br>
     * <p>- 1. The {@link Material} </p>
     * <p>- 2. The {@link ItemMeta} </p>
     * <p>- 3. The {@link ItemMeta#getDisplayName()} with color </p>
     * <p>- 4. The {@link ItemMeta#isUnbreakable()} </p>
     *
     * Returns {@code false} if the given ItemStack is {@code null}
     * @param heldItem the item to check
     * @return {@code true} if the given Item is a Stat-Meter
     */
    public static boolean isStatOMeter(ItemStack heldItem) {
        if (heldItem == null) return false;
        if (MISC_STAT_O_METER.getItem().getType() != heldItem.getType()) return false;
        ItemMeta heldItemMeta = heldItem.getItemMeta();
        ItemMeta statItemMeta = MISC_STAT_O_METER.itemStack.getItemMeta();
        if (statItemMeta == null || heldItemMeta == null) return false;
        if (!statItemMeta.getDisplayName().equals(heldItemMeta.getDisplayName())) return false;
        if (!statItemMeta.isUnbreakable() || !heldItemMeta.isUnbreakable()) return false;
        return true;
    }

    /**
     * Searches for a matching CustomItem to an ItemStack. Compares the given ItemStack with each ItemStack of the defined CustomItem.
     * Compares the following arguments: <br>
     * <p>- 1. The {@link Material} </p>
     * <p>- 2. The {@link ItemMeta} </p>
     * <p>- 3. The {@link ItemMeta#getDisplayName()} without color </p>
     * <p>- 4. The {@link ItemMeta#getLore()} of the item with content comparison </p>
     * <p>- 5. The {@link ItemMeta#getAttributeModifiers()} without content comparison </p>
     * <br>
     *
     * Returns {@link CustomItem#NONE} if the given ItemStack is {@code null}
     *
     * @param key The ItemStack to search for
     * @return the belonging CustomTool or {@link CustomItem#NONE} if the ItemStack does not match any CustomTool
     */
    public static CustomItem getItem(ItemStack key) {
        if (key == null) return NONE;
        for (CustomItem customItem : CustomItem.values()) {
            if (key.getType() != customItem.itemStack.getType()) continue;

            ItemMeta keyMeta = key.getItemMeta();
            if (keyMeta == null) continue;
            ItemMeta toolMeta = customItem.getItem().getItemMeta();
            if (toolMeta == null) continue;
            Bukkit.getLogger().info("Before Music");
            if (keyMeta instanceof MusicInstrumentMeta ^ toolMeta instanceof MusicInstrumentMeta) continue;
            if (keyMeta instanceof MusicInstrumentMeta keyMusicMeta && toolMeta instanceof MusicInstrumentMeta toolMusicMeta) {
                if (keyMusicMeta.getInstrument() != toolMusicMeta.getInstrument()) continue;
            }
            Bukkit.getLogger().info("After Music");

            if (!keyMeta.hasDisplayName()) continue;
            if (!ChatColor.stripColor(keyMeta.getDisplayName()).equals(ChatColor.stripColor(toolMeta.getDisplayName()))) continue;

            if (keyMeta.hasLore() ^ toolMeta.hasLore()) continue;
            if (!keyMeta.hasLore() && !keyMeta.getLore().equals(toolMeta.getLore())) continue;

            if (keyMeta.hasAttributeModifiers() ^ toolMeta.hasAttributeModifiers()) continue;
            return customItem;
        }
        return NONE;
    }



}
