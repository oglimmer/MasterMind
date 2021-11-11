package de.oglimmer.mastermind;

public class CheckResult {

    private int hit = 0;
    private int colorOnlyHit = 0;

    public int getHit() {
        return hit;
    }

    public int getColorOnlyHit() {
        return colorOnlyHit;
    }

    public void incHit() {
        hit++;
    }

    public void incColorOnlyHit() {
        colorOnlyHit++;
    }

    public boolean hasWon() {
        return getHit() == 4;
    }
}
