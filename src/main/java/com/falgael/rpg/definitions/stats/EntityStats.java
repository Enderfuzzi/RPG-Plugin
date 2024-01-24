package com.falgael.rpg.definitions.stats;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;

public enum EntityStats implements Stats {

    NONE(Proficiency.NONE, EntityType.AREA_EFFECT_CLOUD, 0),



    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    RABBIT(Proficiency.FARMING, EntityType.RABBIT, 4),
    SHEEP(Proficiency.FARMING, EntityType.SHEEP, 16),
    COW(Proficiency.FARMING, EntityType.COW, 8),
    PIG(Proficiency.FARMING, EntityType.PIG, 8),
    CHICKEN(Proficiency.FARMING, EntityType.CHICKEN, 4),
    GOAT(Proficiency.FARMING, EntityType.GOAT,4),
    MUSHROOM_COW(Proficiency.FARMING, EntityType.MUSHROOM_COW,8),
    COD(Proficiency.FARMING, EntityType.COD,2),
    SQUID(Proficiency.FARMING, EntityType.SQUID,4),
    GLOW_SQUID(Proficiency.FARMING, EntityType.GLOW_SQUID,6),
    PUFFERFISH(Proficiency.FARMING, EntityType.PUFFERFISH,2),
    SALMON(Proficiency.FARMING, EntityType.SALMON, 2),
    TROPICAL_FISH(Proficiency.FARMING, EntityType.TROPICAL_FISH, 2),
    HORSE(Proficiency.FARMING, EntityType.HORSE, 6),

    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    BAT(Proficiency.HUNTING, EntityType.BAT, 2),
    BLAZE(Proficiency.HUNTING, EntityType.BLAZE, 8),
    CAVE_SPIDER(Proficiency.HUNTING, EntityType.CAVE_SPIDER, 6),
    CREEPER(Proficiency.HUNTING, EntityType.CREEPER, 4),
    DROWNED(Proficiency.HUNTING, EntityType.DROWNED, 4),
    ELDER_GUARDIAN(Proficiency.HUNTING, EntityType.ELDER_GUARDIAN, 40),
    ENDER_DRAGON(Proficiency.HUNTING, EntityType.ENDER_DRAGON, 250),
    ENDERMAN(Proficiency.HUNTING, EntityType.ENDERMAN, 10),
    ENDERMITE(Proficiency.HUNTING, EntityType.ENDERMITE, 5),
    EVOKER(Proficiency.HUNTING, EntityType.EVOKER, 10),
    GHAST(Proficiency.HUNTING, EntityType.GHAST, 5),
    HOGLIN(Proficiency.HUNTING, EntityType.HOGLIN, 4),
    HUSK(Proficiency.HUNTING, EntityType.HUSK, 4),
    MAGMA_CUBE(Proficiency.HUNTING, EntityType.MAGMA_CUBE, 4),
    PHANTOM(Proficiency.HUNTING, EntityType.PHANTOM, 2),
    PIGLING_BRUTE(Proficiency.HUNTING, EntityType.PIGLIN_BRUTE, 8),
    PILLAGER(Proficiency.HUNTING, EntityType.PILLAGER, 6),
    RAVAGER(Proficiency.HUNTING, EntityType.RAVAGER, 15),
    SHULKER(Proficiency.HUNTING, EntityType.SHULKER, 10),
    SHULKER_BULLET(Proficiency.HUNTING, EntityType.SHULKER_BULLET, 4),
    SILVERFISH(Proficiency.HUNTING, EntityType.SILVERFISH, 4),
    SKELETON(Proficiency.HUNTING, EntityType.SKELETON, 4),
    SLIME(Proficiency.HUNTING, EntityType.SLIME, 2),
    SPIDER(Proficiency.HUNTING, EntityType.SPIDER, 4),
    STRAY(Proficiency.HUNTING, EntityType.STRAY, 6),
    STRIDER(Proficiency.HUNTING, EntityType.STRIDER, 4),
    VEX(Proficiency.HUNTING, EntityType.VEX, 4),
    VINDICATOR(Proficiency.HUNTING, EntityType.VINDICATOR, 8),
    WARDEN(Proficiency.HUNTING, EntityType.WARDEN, 350),
    WITCH(Proficiency.HUNTING, EntityType.WITCH, 15),
    WITHER(Proficiency.HUNTING, EntityType.WITHER, 150),
    WITHER_SKELETON(Proficiency.HUNTING, EntityType.WITHER_SKELETON, 10),
    ZOGLIN(Proficiency.HUNTING, EntityType.HOGLIN, 10),
    ZOMBIE(Proficiency.HUNTING, EntityType.ZOMBIE, 4),
    ZOMBIE_VILLAGER(Proficiency.HUNTING, EntityType.ZOMBIE_VILLAGER, 8),


    ;

    private final List<Proficiency> proficiencies;

    private final EntityType entity;

    private final long experienceAmount;


    private static final HashMap<EntityType, EntityStats> LIST_OF_ENTITIES = new HashMap<>();

    static {
        for (EntityStats entity : EntityStats.values()) {
            LIST_OF_ENTITIES.put(entity.entity,entity);
        }
    }

    EntityStats(Proficiency proficiency, EntityType entity, long experienceAmount) {
        this(List.of(proficiency), entity, experienceAmount);
    }

    EntityStats(List<Proficiency> proficiencies, EntityType entity, long experienceAmount) {
        this.proficiencies = proficiencies;
        this.entity = entity;
        this.experienceAmount = experienceAmount;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }
    public long getExperienceAmount() {
        return experienceAmount;
    }



    public boolean isNone() {
        return this == NONE;
    }

    public static EntityStats getEntity(EntityType type) {
        return LIST_OF_ENTITIES.getOrDefault(type, NONE);
    }

    public static EntityStats getEntity(Entity entity) {
        return getEntity(entity.getType());
    }

}
