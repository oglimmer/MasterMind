package de.oglimmer.mastermind;

import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public Guess ask() {
        Guess guess = new Guess();
        while (guess.incomplete()) {
            System.out.print("Enter the order for the 4 colors with spaces (r,g,b,y,o,w): ");
            String s = scanner.nextLine();
            guess.parse(s);
        }
        return guess;
    }
}
