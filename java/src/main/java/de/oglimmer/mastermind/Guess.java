package de.oglimmer.mastermind;

import java.util.*;
import java.util.stream.Collectors;

public class Guess {

    private List<Color> list = Collections.EMPTY_LIST;

    public Color get(int i) {
        return list.get(i);
    }

    public void fake(Color c1, Color c2, Color c3, Color c4) {
        list = Arrays.asList(c1, c2, c3, c4);
    }

    public boolean incomplete() {
        return list.size() != 4;
    }

    public void parse(String s) {
        String[] data = s.split(" ");
        list = Arrays.stream(data).map(e -> Character.valueOf(e.charAt(0))).filter(e -> Color.isValid(e)).map(e -> Color.get(e)).collect(Collectors.toList());
    }
}
