package com.falgael.rpg.stats;

import com.falgael.rpg.proficiency.Proficiency;

import java.util.List;

public interface Stats {
    List<Proficiency> getProficiencies();

    long getExperienceAmount();




}
