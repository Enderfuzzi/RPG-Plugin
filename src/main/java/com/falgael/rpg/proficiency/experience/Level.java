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
    TWENTY_TWO(22, 800),
    TWENTY_THREE(23,900),
    TWENTY_FOUR(24,1000),
    TWENTY_FIVE(25, 1200),
    TWENTY_SIX(26, 1400),
    TWENTY_SEVEN(27, 1600),
    TWENTY_EIGHT(28, 1800),
    TWENTY_NINE(29, 2000),
    THIRTY(30, 2250),
    THIRTY_ONE(31, 2500),
    THIRTY_TWO(32, 2750),
    THIRTY_THREE(33, 3000),
    THIRTY_FOUR(34, 3250),
    THIRTY_FIVE(35, 3500),
    THIRTY_SIX(36, 3750),
    THIRTY_SEVEN(37, 4000),
    THIRTY_EIGHT(38, 4250),
    THIRTY_NINE(39, 4500),
    FORTY(40,5000),
    FORTY_ONE(41, 5500),
    FORTY_TWO(42, 6000),
    FORTY_THREE(43, 6500),
    FORTY_FOUR(44, 7000),
    FORTY_FIVE(45, 7500),
    FORTY_SIX(46, 8000),
    FORTY_SEVEN(47, 8500),
    FORTY_EIGHT(48, 9000),
    FORTY_NINE(49, 9500),
    FIFTY(50, 10000),
    FIFTY_ONE(51, 10500),
    FIFTY_TWO(52, 11000),
    FIFTY_THREE(53, 11500),
    FIFTY_FOUR(54, 12000),
    FIFTY_FIVE(55, 12500),
    FIFTY_SIX(56, 15000),
    FIFTY_SEVEN(57, 17500),
    FIFTY_EIGHT(58, 20000),
    FIFTY_NINE(59, 22500),
    SIXTY(60, 25000),
    SIXTY_ONE(61, 27500),
    SIXTY_TWO(62, 30000),
    SIXTY_THREE(63, 32500),
    SIXTY_FOUR(64, 35000),
    SIXTY_FIVE(65, 37500),
    SIXTY_SIX(66, 40000),
    SIXTY_SEVEN(67, 42500),
    SIXTY_EIGHT(68, 45000),
    SIXTY_NINE(69, 47500),
    SEVENTY(70, 50000),
    SEVENTY_ONE(71, 52500),
    SEVENTY_TWO(72, 55000),
    SEVENTY_THREE(73, 57500),
    SEVENTY_FOUR(74, 60000),
    SEVENTY_FIVE(75, 62500),
    SEVENTY_SIX(76, 70000),
    SEVENTY_SEVEN(77, 77500),
    SEVENTY_EIGHT(78, 85000),
    SEVENTY_NINE(79, 92500),
    EIGHTY(80, 100000),
    EIGHTY_ONE(81,110000),
    EIGHTY_TWO(82, 120000),
    EIGHTY_THREE(83,130000),
    EIGHTY_FOUR(84, 140000),
    EIGHTY_FIVE(85, 150000),
    EIGHTY_SIX(86, 200000),
    EIGHTY_SEVEN(87, 250000),
    EIGHTY_EIGHT(88, 300000),
    EIGHTY_NINE(89, 350000),
    NINETY(90, 400000),
    NINETY_ONE(91, 500000),
    NINETY_TWO(92,600000),
    NINETY_THREE(93, 700000),
    NINETY_FOUR(94, 800000),
    NINETY_FIVE(95, 900000),
    NINETY_SIX(96, 1000000),
    NINETY_SEVEN(97, 2000000),
    NINETY_EIGHT(98, 3000000),
    NINETY_NINE(99, 4000000),
    ONE_HUNDRED(100,10000000) {
        @Override
        public boolean hasNext() {
            return false;
        }
    },
    MAX_LEVEL(100, 0) {
        @Override
        public boolean hasPrevious() { return false;}

        @Override
        public boolean hasNext() {
            return false;
        }
    };

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


}
