package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

/**
 * Player which simply iterates through all possible moves
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class IterativeBot extends Player {

    /**
     * Counter indicating the previous move played
     */
    int previous = 1;

    /**
     * Constructs a new InterativeBot with the given name
     *
     * @param name Name of the bot
     */
    public IterativeBot(String name) {
        super(name);
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        return lastPlayed = Moves.instance().get(previous++);
    }
}