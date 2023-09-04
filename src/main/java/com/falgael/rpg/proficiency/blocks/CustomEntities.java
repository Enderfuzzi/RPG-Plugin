package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;

public enum CustomEntities {

    NONE(ProficiencyType.NONE, EntityType.AREA_EFFECT_CLOUD, 0),



    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    SHEEP(ProficiencyType.FARMING, EntityType.SHEEP, 16),


    ;

    private final ProficiencyType proficiency;

    private final EntityType entity;

    private final long experienceAmount;


    private static final HashMap<EntityType, CustomEntities> LIST_OF_ENTITIES = new HashMap<>();

    static {
        for (CustomEntities entity : CustomEntities.values()) {
            LIST_OF_ENTITIES.put(entity.entity,entity);
        }
    }

    CustomEntities(ProficiencyType proficiency, EntityType entity, long experienceAmount) {
        this.proficiency = proficiency;
        this.entity = entity;
        this.experienceAmount = experienceAmount;
    }

    public ProficiencyType getProficiency() {
        return proficiency;
    }
    public long getExperienceAmount() {
        return experienceAmount;
    }



    public boolean isNone() {
        return this != NONE;
    }

    public static CustomEntities getEntity(EntityType type) {
        return LIST_OF_ENTITIES.getOrDefault(type, NONE);
    }

}
