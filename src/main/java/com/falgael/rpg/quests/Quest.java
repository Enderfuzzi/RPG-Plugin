package com.falgael.rpg.quests;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Quest {

    private final String representation;

    private final String title;

    private String text;

    private boolean completed;

    private boolean active;

    private boolean awarded;

    private ArrayList<Task> tasks;

    private ArrayList<Requirement> requirements;

    private ArrayList<Quest> following;


    private Quest(QuestBuilder questBuilder) {
        this.representation = questBuilder.representation;
        this.title = questBuilder.title;
        this.text = questBuilder.text;
        this.tasks = questBuilder.tasks;
        this.requirements = questBuilder.requirements;
        this.following = questBuilder.following;

        completed = false;
        active = false;
        awarded = false;
    }

    public void addFollowingQuest(Quest quest) {
        if (quest == null) return;
        following.add(quest);
    }

    public boolean isActive() {
        return active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public boolean evaluate(Player player) {
        if (!isActive() || isCompleted()) return false;
        for (Requirement requirement : requirements) {
            if (!requirement.evaluate(player)) return false;
        }
        completed = true;
        active = false;
        return true;
    }

    public void award(QuestInterface awardingInterface, Player player) {
        if (!isAwarded() && isCompleted()) return;
        awardingInterface.award(player);
        awarded = true;
    }


    public static class QuestBuilder {
        //necessary
        private String representation;
        private String title;

        private String text;

        private ArrayList<Task> tasks;

        private ArrayList<Requirement> requirements;

        private ArrayList<Quest> following;

        public QuestBuilder(String representation, String title) {
            this.representation = representation;
            this.title = title;
        }

        public QuestBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public QuestBuilder addTask(Task task) {
            this.tasks.add(task);
            return this;
        }

        public QuestBuilder addTasks(ArrayList<Task> tasks) {
            this.tasks.addAll(tasks);
            return this;
        }

        public QuestBuilder addRequirement(Requirement requirement) {
            this.requirements.add(requirement);
            return this;
        }

        public QuestBuilder addRequirements(ArrayList<Requirement> requirements) {
            this.requirements.addAll(requirements);
            return this;
        }

        public QuestBuilder addFollowingQuest(Quest quest) {
            this.following.add(quest);
            return this;
        }

        public QuestBuilder addFollowingQuests(ArrayList<Quest> quests) {
            this.following.addAll(quests);
            return this;
        }

        public Quest build() {
            return new Quest(this);
        }

    }

}
