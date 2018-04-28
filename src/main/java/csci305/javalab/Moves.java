package csci305.javalab;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import csci305.javalab.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A Singleton class containing the list of available valid moves a play may make.
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class Moves {

    /**
     * An Immutable Map of all possible moves that any single player may make
     */
    private Map<String, Element> moves;
    /**
     * List of move names
     */
    private List<String> names;
    /**
     * A mapping of a move name to the names of the moves that it defeats
     */
    private Map<String, List<String>> preceeds;
    /**
     * A mapping of a move name to the names of the moves which defeat it
     */
    private Map<String, List<String>> succeeds;

    /**
     * Static method used to retrieve the singleton instance of this class.
     *
     * @return The singleton instance
     */
    public static Moves instance() {
        return Holder.INSTANCE;
    }

    /**
     * Private constructor for Moves
     */
    private Moves() {
        moves = ImmutableMap.of("Rock", new Rock(),
                "Paper", new Paper(),
                "Lizard", new Lizard(),
                "Spock", new Spock(),
                "Scissors", new Scissors());

        names = Lists.newArrayList(moves.keySet());

        preceeds.put("Paper", ImmutableList.of("Spock", "Rock"));
        preceeds.put("Scissors", ImmutableList.of("Lizard", "Paper"));
        preceeds.put("Spock", ImmutableList.of("Scissors", "Rock"));
        preceeds.put("Lizard", ImmutableList.of("Spock", "Paper"));
        preceeds.put("Rock", ImmutableList.of("Lizard", "Scissors"));

        succeeds.put("Paper", ImmutableList.of("Scissors", "Lizard"));
        succeeds.put("Scissors", ImmutableList.of("Spock", "Rock"));
        succeeds.put("Spock", ImmutableList.of("Lizard", "Paper"));
        succeeds.put("Lizard", ImmutableList.of("Rock", "Scissors"));
        succeeds.put("Rock", ImmutableList.of("Paper", "Spock"));
    }

    /**
     * Class used as a Lazy Init holder for the Moves Instance
     */
    private static final class Holder {
        /**
         * The singleton instance of Moves
         */
        public static final Moves INSTANCE = new Moves();
    }

    /**
     * Retrieves the move with the given index from the list of known moves.
     *
     * @param index index of a move name
     * @return Element with the name at the given index mod names.size()
     * @throws IllegalArgumentException if the value of index is < 0.
     */
    public Element get(int index) {
        if (index >= 0)
            return moves.get(names.get(index % moves.size()));

        throw new IllegalArgumentException("get() - The value of index must be greater than or equal to 0.");
    }

    /**
     * Retrieves the move with the given name
     *
     * @param name Name of a move
     * @return Element with the given name, if the provided name is valid
     * @throws IllegalArgumentException If the provided name is not a valid name of a move
     */
    public Element get(String name) {
        if (moves.containsKey(name))
            return moves.get(name);

        throw new IllegalArgumentException("get() - The value must be a valid name of a move");
    }

    /**
     * @param name Name of the element
     * @return List of the names of the elements which are defeated by the named element
     * @throws IllegalArgumentException if the provided name is null, empty, or not a known element name.
     */
    public List<String> getPreceeds(String name) {
        if (name == null || name.isEmpty() || !preceeds.containsKey(name))
            throw new IllegalArgumentException("getPreceeds() argument must be a valid name of an element.");

        return preceeds.get(name);
    }

    /**
     * @param name Name of the element
     * @return A list of the names of elements which defeat the element with the name provided
     * @throws IllegalArgumentException if the provided name is null, empty, or not a known element name.
     */
    public List<String> getSuceeds(String name) {
        if (name == null || name.isEmpty() || !succeeds.containsKey(name))
            throw new IllegalArgumentException("getSucceeds() argument must be a valid name of an element.");

        return succeeds.get(name);
    }
}
