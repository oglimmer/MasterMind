package de.oglimmer.mastermind;


public class Game {

    public static void main(String... args) {
        new Game().run();
    }

    private Board board = new Board();
    private Console console = new Console();
    private int round = 0;

    public void run() {
        CheckResult checkResult;
        do {
            round++;
            Guess guess = console.ask();
            checkResult = board.checkAndInform(guess);
        } while (!checkResult.hasWon() && round < 12);

        if (!checkResult.hasWon() || round == 12) {
            System.out.println("You lost. The right code was: " + board);
        } else {
            System.out.println("You won in " + round + " rounds!");
        }
    }

}
