package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

import java.util.Random;

/**
 * A class representing a player who randomly selects a play each time
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class RandomBot extends Player {

    /**
     * Random number generator used to select the element to play
     */
    private Random rand;

    /**
     * Constructs a new RandomBot with the given name
     *
     * @param name Name of the bot
     */
    public RandomBot(String name) {
        super(name);
        rand = new Random();
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        int selection = rand.nextInt(5);

        return lastPlayed = Moves.instance().get(selection);
    }
}
