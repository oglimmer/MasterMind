package de.oglimmer.mastermind;

import java.util.Arrays;

public enum Color {

    RED('r'),
    BLUE('b'),
    GREEN('g'),
    YELLOW('y'),
    ORANGE('o'),
    WHITE('w');

    Color(char key) {
        this.key = key;
    }

    private char key;

    public static Color getRandom() {
        int rnd = (int) (Math.random() * 6);
        return Color.values()[rnd];
    }

    public static boolean isValid(char c) {
        return Arrays.stream(values()).anyMatch(e -> e.key == c);
    }

    public static Color get(Character character) {
        return Arrays.stream(Color.values()).filter(e -> e.key == character).findAny().get();
    }

    public String toString() {
        return Character.toString(key);
    }
}
