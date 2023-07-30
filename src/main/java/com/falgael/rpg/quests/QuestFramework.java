package com.falgael.rpg.quests;

import java.util.ArrayList;
import java.util.Map;

public class QuestFramework {

    private final String representation;

    private final String title;

    private String text;

    private boolean completed;

    private boolean active;

    private ArrayList<Task> tasks;

    private Map<RequirementType,RequirementValue> requirements;

    private ArrayList<QuestFramework> following;

    public QuestFramework(String representation, String title) {
        this.representation = representation;
        this.title = title;
    }

}
