package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

/**
 * A class representing player who simply plays the same element each time
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class StupidBot extends Player {

    /**
     * Constructs a new StupidBot with the given name
     *
     * @param name Name of the bot
     */
    public StupidBot(String name) {
        super(name);
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        return lastPlayed = Moves.instance().get(1);
    }
}