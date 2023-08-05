package com.falgael.rpg.villager;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;

public class Villager {

    private final String name;

    private ArrayList<MerchantRecipe> recipes;

    private final org.bukkit.entity.Villager.Profession profession;


    private Villager(VillagerBuilder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.recipes = builder.recipes;
    }

    public void spawn(World world, Location location) {
        org.bukkit.entity.Villager entity = (org.bukkit.entity.Villager) world.spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
        entity.setCollidable(false);
        entity.setAI(false);
        entity.setCanPickupItems(false);
        entity.setInvulnerable(true);
        entity.setProfession(profession);
        entity.setRecipes(recipes);
        entity.setSilent(true);
    }

    public static class VillagerBuilder {
        private final String name;

        private ArrayList<MerchantRecipe> recipes = new ArrayList<>();

        private final org.bukkit.entity.Villager.Profession profession;

        public VillagerBuilder(String name, org.bukkit.entity.Villager.Profession profession) {
            this.name = name;
            this.profession = profession;
        }

        public VillagerBuilder addRecipe(MerchantRecipe recipe) {
            recipes.add(recipe);
            return this;
        }

        public Villager create() {
            return new Villager(this);
        }

    }



}
