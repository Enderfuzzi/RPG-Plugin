package com.falgael.rpg.items.set;

public interface NameBuilding {

    default String buildName(String input) {
        String[] tmp = input.split("_");
        String result = "";
        for (int i = 0;i< tmp.length;i++) {
            if (tmp[i].matches("\\d+")) {
                tmp[i] = RomanNumbers.getRepresentation(Integer.parseInt(tmp[i]));
            } else {
                tmp[i].substring(1).toLowerCase();
            }

            if (i != 0) result.concat(" " + tmp[i]);
            else result.concat(tmp[i]);
        }
        return result;
    }

    enum RomanNumbers {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

        private final int value;

        RomanNumbers(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static String getRepresentation(int value) {
            if (value < 1 || value > 10) return "";
            for (RomanNumbers number : RomanNumbers.values()) {
                if (number.getValue() == value) return number.name();
            }
            return "";
        }
    }
}
