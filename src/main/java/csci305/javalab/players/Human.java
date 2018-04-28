package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

import java.util.Scanner;

/**
 * A class representing a Human player
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class Human extends Player {

    /**
     * Constructs a new Human player with the given name
     *
     * @param name Name of the bot
     */
    public Human(String name) {
        super(name);
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("(1) : Rock");
        System.out.println("(2) : Paper");
        System.out.println("(3) : Scissors");
        System.out.println("(4) : Lizard");
        System.out.println("(5) : Spock");

        do {
            System.out.print("Enter your move: ");

            input = scanner.nextInt();

            if (!isValid(input))
                System.out.println("Invalid move. Please try again.");
        } while (!isValid(input));

        return lastPlayed = Moves.instance().get(input - 1);
    }

    /**
     * Simple input validation function which checks that the user provided valid input for the move to select.
     *
     * @param input number from the user
     * @return true if the number was between 1 and 5, false otherwise
     */
    private boolean isValid(int input) {
        return input >= 1 && input <= 5;
    }
}