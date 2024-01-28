package com.falgael.rpg.proficiency.experience;


public enum Level {
    ZERO(0,0) {
        @Override
        public boolean hasPrevious() {
            return false;
        }
    },
    ONE(1, 15),
    TWO(2, 25),
    THREE(3, 40),
    FOUR(4, 55),
    FIVE(5, 75),
    SIX(6, 90),
    SEVEN(7, 105),
    EIGHT(8,125),
    NINE(9, 145),
    TEN(10, 175),
    ELEVEN(11, 200),
    TWELVE(12, 225),
    THIRTEEN(13, 250),
    FOURTEEN(14, 275),
    FIFTEEN(15, 300),
    SIXTEEN(16, 350),
    SEVENTEEN(17, 400),
    EIGHTEEN(18, 450),
    NINETEEN(19, 500),
    TWENTY(20, 600),
    TWENTY_ONE(21, 700),

    HUNDRED(100,0) {
        @Override
        public boolean hasNext() {
            return false;
        }
    }


    ;

    static {
        Level[] tmp = Level.values();
        for (int i = 0; i < tmp.length;i++) {
            if (tmp[i].hasPrevious()) {
                tmp[i].previous = tmp[i - 1];
            }
            if (tmp[i].hasNext()) {
                tmp[i].next = tmp[i + 1];
            }
        }
    }


    private final int representation;

    private final long experienceNeeded;


    private Level previous;
    private Level next;


    Level(int representation, long experienceNeeded) {
        this.representation = representation;
        this.experienceNeeded = experienceNeeded;
    }

    public int getRepresentation() {
        return representation;
    }

    public long getExperienceNeeded() {
        return experienceNeeded;
    }

    public boolean hasNext() {
        return true;
    }

    public boolean hasPrevious() {
        return true;
    }

    public Level getNextLevel() {
        return next;
    }

    public Level getPrevious() {
        return previous;
    }

    public void levelUpAction() {}


}
