package csci305.javalab;

/**
 * Base class for each move
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public abstract class Element {

    /**
     * Name of the move
     */
    protected String name;

    /**
     * Constructor
     *
     * @param name Name of the move
     */
    public Element(String name) {
        this.name = name;
    }

    /**
     * @return Name of this element
     */
    public String getName() {
        return name;
    }

    /**
     * Method to compare this element to another
     *
     * @param element Element to compare against
     * @return An Outcome object representing the outcome of a round of the game
     */
    public Outcome compareTo(Element element) {
        String otherName = element.getName();
        if (name.equals(otherName)) {
            return Outcome.tie(this, element);
        } else if (Moves.instance().getPreceeds(name).contains(otherName)) {
            return Outcome.win(this, element);
        } else {
            return Outcome.loss(this, element);
        }
    }
}
