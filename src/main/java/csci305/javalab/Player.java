package csci305.javalab;

/**
 * The base player class
 */
public abstract class Player implements Comparable<Player> {

    /**
     * Player name
     */
    private String name;
    /**
     * The move last played by this player
     */
    protected Element lastPlayed;
    /**
     * This player's opponent
     */
    protected Player opponent;
    /**
     * This player's current score
     */
    private int score;

    /**
     * Constructs a new Player with the given name and an initial score of 0
     *
     * @param name Name of the new player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * @return The name of this player
     */
    public String getName() {
        return name;
    }

    /**
     * @return The move selected by this player to play
     */
    public abstract Element play();

    /**
     * The last move played by this player
     *
     * @return The last played element
     */
    public Element getLastPlayed() {
        return lastPlayed;
    }

    /**
     * Sets the opponent playing against this player
     *
     * @param opponent This player's opponent
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * @return The current score of this player
     */
    public int getScore() {
        return score;
    }

    /**
     * Simply increments and updates this player's score by 1
     */
    public void incrementScore() {
        score += 1;
    }

    /**
     * Compares this player to another based on their score
     *
     * @param o The other player
     * @return 1 if this player's score is greater than the other player's, 0 if they have the same score, and -1 if the other player's score is higher
     */
    @Override
    public int compareTo(Player o) {
        if (this.score == o.getScore())
            return 0;
        else if (this.score > o.getScore())
            return 1;
        else
            return -1;
    }
}
