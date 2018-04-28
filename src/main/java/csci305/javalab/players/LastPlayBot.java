package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

import java.util.Random;

/**
 * A class representing a player who simply plays their opponents last play
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class LastPlayBot extends Player {

    private Random rand;

    /**
     * Constructs a new InterativeBot with the given name
     *
     * @param name Name of the bot
     */
    public LastPlayBot(String name) {
        super(name);
        rand = new Random();
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        if (opponent.getLastPlayed() == null) {
            int selection = rand.nextInt(5) + 1;

            return lastPlayed = Moves.instance().get(selection);
        } else {
            return lastPlayed = opponent.getLastPlayed();
        }
    }
}