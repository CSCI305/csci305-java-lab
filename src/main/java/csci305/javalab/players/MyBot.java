package csci305.javalab.players;

import csci305.javalab.Element;
import csci305.javalab.Moves;
import csci305.javalab.Player;

import java.util.Random;

/**
 * A class representing a player different from all others who plays one of the two possibilities which defeat the move last played by the opponent
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class MyBot extends Player {

    /**
     * Random number generator used during selection of the move
     */
    private Random rand;

    /**
     * Constructs a new InterativeBot with the given name
     *
     * @param name Name of the bot
     */
    public MyBot(String name) {
        super(name);
        rand = new Random();
    }

    /**
     * Selects and returns the move to be played by this bot
     *
     * @return Element representing the move to be played
     */
    public Element play() {
        Element oppLastPlayed = opponent.getLastPlayed();

        String move = Moves.instance().getSuceeds(oppLastPlayed.getName()).get(rand.nextInt(2));

        return lastPlayed = Moves.instance().get(move);
    }
}
