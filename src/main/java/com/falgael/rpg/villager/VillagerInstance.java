package com.falgael.rpg.villager;


import com.falgael.rpg.items.set.NameBuilding;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;

public class VillagerInstance implements NameBuilding {

    private final String name;

    private final Proficiency proficiency;

    private final Rarity rarity;

    private final int levelRequirement;

    private ArrayList<MerchantRecipe> recipes;

    private final org.bukkit.entity.Villager.Profession profession;


    private VillagerInstance(VillagerBuilder builder) {
        this.name = builder.name;
        this.proficiency = builder.proficiency;
        this.rarity = builder.rarity;
        this.levelRequirement = builder.levelRequirement;
        this.profession = builder.profession;
        this.recipes = builder.recipes;
    }

    public void spawn(World world, Location location) {
        org.bukkit.entity.Villager entity = (org.bukkit.entity.Villager) world.spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomNameVisible(true);
        entity.setCustomName(rarity.getColor() + buildName(name));
        entity.setCollidable(false);
        entity.setAI(false);
        entity.setCanPickupItems(false);
        entity.setInvulnerable(true);
        entity.setProfession(profession);
        entity.setRecipes(recipes);
        entity.setSilent(true);
        entity.setVillagerLevel(5);
    }

    public boolean isSame(Villager villager) {
        if (!villager.isCustomNameVisible()) return false;
        if (!ChatColor.stripColor(villager.getCustomName()).toLowerCase().equals(buildName(name).toLowerCase())) return false;
        if (villager.getProfession() != profession) return false;
        if (villager.isCollidable()) return false;
        if (villager.hasAI()) return false;
        if (villager.getCanPickupItems()) return false;
        if (!villager.isInvulnerable()) return false;
        if (!villager.isSilent()) return false;
        return true;
    }


    public Proficiency getProficiency() {
        return proficiency;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getKey() {
        return name.toLowerCase().replace(" ", "_");
    }

    public static class VillagerBuilder {
        private final String name;

        private ArrayList<MerchantRecipe> recipes = new ArrayList<>();

        private final org.bukkit.entity.Villager.Profession profession;

        private Proficiency proficiency = Proficiency.NONE;

        private Rarity rarity = Rarity.NONE;

        private int levelRequirement = 0;


        public VillagerBuilder(String name, Villager.Profession profession) {
            this.name = name;
            this.profession = profession;
        }

        public VillagerBuilder level(int levelRequirement) {
            this.levelRequirement = levelRequirement;
            return this;
        }

        public VillagerBuilder proficiency(Proficiency proficiency) {
            this.proficiency = proficiency;
            return this;
        }
        public VillagerBuilder rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public VillagerBuilder add(MerchantRecipe recipe) {
            this.recipes.add(recipe);
            return this;
        }

        public VillagerInstance create() {
            return new VillagerInstance(this);
        }

    }



}
