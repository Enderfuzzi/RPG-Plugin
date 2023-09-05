package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;

import java.util.HashMap;

public enum CustomEntity {

    NONE(ProficiencyType.NONE, EntityType.AREA_EFFECT_CLOUD, 0),



    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    RABBIT(ProficiencyType.FARMING, EntityType.RABBIT, 4),
    SHEEP(ProficiencyType.FARMING, EntityType.SHEEP, 16),
    COW(ProficiencyType.FARMING, EntityType.COW, 8),
    PIG(ProficiencyType.FARMING, EntityType.PIG, 8),
    CHICKEN(ProficiencyType.FARMING, EntityType.CHICKEN, 4),
    GOAT(ProficiencyType.FARMING, EntityType.GOAT,4),
    MUSHROOM_COW(ProficiencyType.FARMING, EntityType.MUSHROOM_COW,8),
    COD(ProficiencyType.FARMING, EntityType.COD,2),
    SQUID(ProficiencyType.FARMING, EntityType.SQUID,4),
    GLOW_SQUID(ProficiencyType.FARMING, EntityType.GLOW_SQUID,6),
    PUFFERFISH(ProficiencyType.FARMING, EntityType.PUFFERFISH,2),
    SALMON(ProficiencyType.FARMING, EntityType.SALMON, 2),
    TROPICAL_FISH(ProficiencyType.FARMING, EntityType.TROPICAL_FISH, 2),
    HORSE(ProficiencyType.FARMING, EntityType.HORSE, 6),

    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    BAT(ProficiencyType.HUNTING, EntityType.BAT, 2),
    BLAZE(ProficiencyType.HUNTING, EntityType.BLAZE, 8),
    CAVE_SPIDER(ProficiencyType.HUNTING, EntityType.CAVE_SPIDER, 6),
    CREEPER(ProficiencyType.HUNTING, EntityType.CREEPER, 4),
    DROWNED(ProficiencyType.HUNTING, EntityType.DROWNED, 4),
    ELDER_GUARDIAN(ProficiencyType.HUNTING, EntityType.ELDER_GUARDIAN, 40),
    ENDER_DRAGON(ProficiencyType.HUNTING, EntityType.ENDER_DRAGON, 250),
    ENDERMITE(ProficiencyType.HUNTING, EntityType.ENDERMITE, 5),
    EVOKER(ProficiencyType.HUNTING, EntityType.EVOKER, 10),
    GHAST(ProficiencyType.HUNTING, EntityType.GHAST, 5),
    HOGLIN(ProficiencyType.HUNTING, EntityType.HOGLIN, 4),
    HUSK(ProficiencyType.HUNTING, EntityType.HUSK, 4),
    MAGMA_CUBE(ProficiencyType.HUNTING, EntityType.MAGMA_CUBE, 4),
    PHANTOM(ProficiencyType.HUNTING, EntityType.PHANTOM, 2),
    PIGLING_BRUTE(ProficiencyType.HUNTING, EntityType.PIGLIN_BRUTE, 8),
    PILLAGER(ProficiencyType.HUNTING, EntityType.PILLAGER, 6),
    RAVAGER(ProficiencyType.HUNTING, EntityType.RAVAGER, 15),
    SHULKER(ProficiencyType.HUNTING, EntityType.SHULKER, 10),
    SHULKER_BULLET(ProficiencyType.HUNTING, EntityType.SHULKER_BULLET, 4),
    SILVERFISH(ProficiencyType.HUNTING, EntityType.SILVERFISH, 4),
    SKELETON(ProficiencyType.HUNTING, EntityType.SKELETON, 4),
    SLIME(ProficiencyType.HUNTING, EntityType.SLIME, 2),
    SPIDER(ProficiencyType.HUNTING, EntityType.SPIDER, 4),
    STRAY(ProficiencyType.HUNTING, EntityType.STRAY, 6),
    STRIDER(ProficiencyType.HUNTING, EntityType.STRIDER, 4),
    VEX(ProficiencyType.HUNTING, EntityType.VEX, 4),
    VINDICATOR(ProficiencyType.HUNTING, EntityType.VINDICATOR, 8),
    WARDEN(ProficiencyType.HUNTING, EntityType.WARDEN, 350),
    WITCH(ProficiencyType.HUNTING, EntityType.WITCH, 15),
    WITHER(ProficiencyType.HUNTING, EntityType.WITHER, 150),
    WITHER_SKELETON(ProficiencyType.HUNTING, EntityType.WITHER_SKELETON, 10),
    ZOGLIN(ProficiencyType.HUNTING, EntityType.HOGLIN, 10),
    ZOMBIE(ProficiencyType.HUNTING, EntityType.ZOMBIE, 4),
    ZOMBIE_VILLAGER(ProficiencyType.HUNTING, EntityType.ZOMBIE_VILLAGER, 8),


    ;

    private final ProficiencyType proficiency;

    private final EntityType entity;

    private final long experienceAmount;


    private static final HashMap<EntityType, CustomEntity> LIST_OF_ENTITIES = new HashMap<>();

    static {
        for (CustomEntity entity : CustomEntity.values()) {
            LIST_OF_ENTITIES.put(entity.entity,entity);
        }
    }

    CustomEntity(ProficiencyType proficiency, EntityType entity, long experienceAmount) {
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

    public static CustomEntity getEntity(EntityType type) {
        return LIST_OF_ENTITIES.getOrDefault(type, NONE);
    }

}
