package de.oglimmer.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Secret {

    private List<Color> secret = new ArrayList<>();

    public Secret() {
        for (int i = 0; i < 4; i++) {
            secret.add(Color.getRandom());
        }
//        System.out.println("Code: " + secret);
    }

    public Secret(Color c1, Color c2, Color c3, Color c4) {
        secret.add(c1);
        secret.add(c2);
        secret.add(c3);
        secret.add(c4);
    }

    public Color get(int pos) {
        return secret.get(pos);
    }

    public String toString() {
        return secret.stream().map(e -> e.toString()).collect(Collectors.joining(":"));
    }

}
