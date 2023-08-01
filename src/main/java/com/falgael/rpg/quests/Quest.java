package com.falgael.rpg.quests;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Quest {

    private final String representation;

    private final String title;

    private TextComponent acceptMessage;

    private TextComponent fulfillMessage;

    private boolean completed;

    private boolean active;

    private boolean awarded;

    private Reward reward;

    private Task task;

    private ArrayList<Requirement> requirements;

    private Quest following;


    @Contract(pure = true)
    private Quest(@NotNull QuestBuilder questBuilder) {
        this.representation = questBuilder.representation;
        this.title = questBuilder.title;
        this.acceptMessage = questBuilder.text;
        this.task = questBuilder.task;
        this.requirements = questBuilder.requirements;
        this.following = questBuilder.following;
        this.reward = questBuilder.reward;

        completed = false;
        active = false;
        awarded = false;
    }

    public void addFollowingQuest(Quest quest) {
        if (quest == null) return;
        following = quest;
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

    public boolean setActive(Player player) {
        for (Requirement requirement : requirements) {
            if (!requirement.evaluate(player)) {
                player.sendMessage(requirement.getDenyMessage());
                return false;
            }
        }
        player.spigot().sendMessage(acceptMessage);
        // here the player has to accept
        active = true;
        // player accept message
        return true;
    }

    private void award(Player player) {
        if (!isAwarded() && isCompleted()) return;
        if (reward != null) reward.award(player);
        awarded = true;
    }

    public void evaluate(Player player) {
        if (!isActive() || isCompleted()) return;
        if (!task.satisfied(player)) return;
        completed = true;
        award(player);
        active = false;
    }


    public boolean isLeaf() {
        return following == null;
    }


    public static class QuestBuilder {
        //necessary
        private String representation;
        private String title;

        private TextComponent text;

        private Task task = null;

        private ArrayList<Requirement> requirements;

        private Quest following = null;

        private Reward reward = null;

        public QuestBuilder(String representation, String title) {
            this.representation = representation;
            this.title = title;
        }

        public QuestBuilder setText(TextComponent text) {
            this.text = text;
            return this;
        }

        public QuestBuilder addTask(Task task) {
            this.task = task;
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
            this.following = quest;
            return this;
        }

        public QuestBuilder addReward(Reward reward) {
            this.reward = reward;
            return this;
        }

        public Quest build() {
            return new Quest(this);
        }

    }

}
