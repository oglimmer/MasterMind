package de.oglimmer.mastermind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void success__1111() {
        Board board = new Board(new Secret(Color.RED, Color.WHITE, Color.YELLOW, Color.GREEN));
        Guess guess = new Guess();
        guess.fake(Color.RED, Color.WHITE, Color.YELLOW, Color.GREEN);
        Assertions.assertEquals(4, board.check(guess).getHit());
    }

    @Test
    public void success__211() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.GREEN, Color.BLUE));
        Guess guess = new Guess();
        guess.fake(Color.RED, Color.RED, Color.GREEN, Color.BLUE);
        Assertions.assertEquals(4, board.check(guess).getHit());
    }

    @Test
    public void success__31() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.RED, Color.GREEN));
        Guess guess = new Guess();
        guess.fake(Color.RED, Color.RED, Color.RED, Color.GREEN);
        Assertions.assertEquals(4, board.check(guess).getHit());
    }

    @Test
    public void success__4() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.RED, Color.RED));
        Guess guess = new Guess();
        guess.fake(Color.RED, Color.RED, Color.RED, Color.RED);
        Assertions.assertEquals(4, board.check(guess).getHit());
    }

    @Test
    public void test_4_colors() {
        Board board = new Board(new Secret(Color.RED, Color.WHITE, Color.YELLOW, Color.GREEN));
        Guess guess = new Guess();
        guess.fake(Color.WHITE, Color.RED, Color.GREEN, Color.YELLOW);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(4, check.getColorOnlyHit());
    }

    @Test
    public void test_22_colors() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.YELLOW, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.YELLOW, Color.YELLOW, Color.RED, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(4, check.getColorOnlyHit());
    }

    @Test
    public void test_31_colors() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.RED, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(2, check.getColorOnlyHit());
    }

    @Test
    public void test_31_1_colors() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.RED, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.GREEN, Color.GREEN, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(1, check.getColorOnlyHit());
    }

    @Test
    public void test_121_3_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.RED, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.YELLOW, Color.YELLOW, Color.GREEN, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(3, check.getColorOnlyHit());
    }

    @Test
    public void test_1111_4_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(4, check.getColorOnlyHit());
    }

    @Test
    public void mixed_1111_22_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(2, check.getHit());
        Assertions.assertEquals(2, check.getColorOnlyHit());
    }

    @Test
    public void mixed_1111_30_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.RED, Color.BLUE, Color.WHITE);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(3, check.getHit());
        Assertions.assertEquals(0, check.getColorOnlyHit());
    }

    @Test
    public void mixed_1111_300_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.RED, Color.BLUE, Color.BLUE);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(3, check.getHit());
        Assertions.assertEquals(0, check.getColorOnlyHit());
    }

    @Test
    public void mixed_1111_13_colors() {
        Board board = new Board(new Secret(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(1, check.getHit());
        Assertions.assertEquals(3, check.getColorOnlyHit());
    }

    @Test
    public void no_hit() {
        Board board = new Board(new Secret(Color.RED, Color.RED, Color.RED, Color.RED));
        Guess guess = new Guess();
        guess.fake(Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE);
        CheckResult check = board.check(guess);
        Assertions.assertEquals(0, check.getHit());
        Assertions.assertEquals(0, check.getColorOnlyHit());
    }


}
