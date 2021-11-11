package de.oglimmer.mastermind;

import java.util.BitSet;

public class Board {

    private Secret secret;

    public Board() {
        secret = new Secret();
    }

    public Board(Secret secret) {
        this.secret = secret;
    }

    public CheckResult check(Guess guess) {
        CheckResult checkResult = new CheckResult();
        BitSet bitSet = new BitSet(4);
        for (int i = 0; i < 4; i++) {
            if (guess.get(i) == secret.get(i)) {
                checkResult.incHit();
            } else {
                for (int j = 0; j < 4; j++) {
                    if (secret.get(j) == guess.get(i) &&
                            secret.get(j) != guess.get(j) &&
                            !bitSet.get(j)) {
                        checkResult.incColorOnlyHit();
                        bitSet.set(j);
                        break;
                    }
                }
            }
        }
        return checkResult;
    }

    public CheckResult checkAndInform(Guess guess) {
        CheckResult checkResult = check(guess);
        if (!checkResult.hasWon()) {
            System.out.println("You guessed " + checkResult.getHit() + " pins correctly and found " + checkResult.getColorOnlyHit() + " matching colors elsewhere.");
        }
        return checkResult;
    }

    public String toString() {
        return secret.toString();
    }

}
