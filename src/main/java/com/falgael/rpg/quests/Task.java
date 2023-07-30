package com.falgael.rpg.quests;

import org.bukkit.entity.Player;

public interface Task {

    boolean satisfied(Player player);

}
