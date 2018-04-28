package csci305.javalab;

import csci305.javalab.players.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Scanner;

/**
 * The Main class which provides a singleton entry point to the game.
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class Main {

    /**
     * My Name
     */
    private static final String NAME = "Isaac Griffith";

    /**
     * The main method entry point
     *
     * @param args Command line arguments (ignored here)
     */
    public static void main(String args[]) {
        Main.instance().game();
    }

    /**
     * Private default constructor
     */
    private Main() {
    }

    /**
     * Singleton instance accessor method
     *
     * @return The singleton instance of Main
     */
    public static Main instance() {
        return MainHolder.INSTANCE;
    }

    /**
     * Private holder class which contains the Singleton Instance
     */
    private static final class MainHolder {
        /**
         * The Singleton Instance
         */
        public static final Main INSTANCE = new Main();
    }

    /**
     * Main game loop method
     */
    public void game() {
        System.out.printf("Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by %s\n\n", NAME);

        Pair<Player, Player> players = getPlayers();

        System.out.printf("\n%s vs %s. Go!\n", players.getLeft().getName(), players.getRight().getName());

        for (int i = 1; i < 5; i++) {
            play(players);
        }

        displayOutcome(players);
    }

    /**
     * Method to ask the player for which types of players they wish for the game
     *
     * @return A pair of players for the game
     */
    private Pair<Player, Player> getPlayers() {
        System.out.println("Please choose two players:");
        System.out.println("   (1) Human");
        System.out.println("   (2) StupidBot");
        System.out.println("   (3) RandomBot");
        System.out.println("   (4) IterativeBot");
        System.out.println("   (5) LastPlayBot");
        System.out.println("   (6) MyBot");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select Player 1: ");
        Player p1 = selectPlayer(scanner.nextInt());
        System.out.print("Select Player 2: ");
        Player p2 = selectPlayer(scanner.nextInt());

        p1.setOpponent(p2);
        p2.setOpponent(p1);

        return Pair.of(p1, p2);
    }

    /**
     * Method to select the player
     *
     * @param index index provided by the user
     * @return A player object
     */
    private Player selectPlayer(int index) {
        switch (index) {
            case 1:
                return new Human("Human");
            case 2:
                return new StupidBot("StupidBot");
            case 3:
                return new RandomBot("RandomBot");
            case 4:
                return new IterativeBot("IterativeBot");
            case 5:
                return new LastPlayBot("LastPlayBot");
            default:
                return new MyBot("MyBot");
        }
    }

    /**
     * Method which actually plays the game.
     *
     * @param players Pair of players to pit against each other
     */
    private void play(Pair<Player, Player> players) {
        Element p1Move = players.getLeft().play();
        Element p2Move = players.getRight().play();
        System.out.println("Round " + 1 + ":");
        System.out.println("   Player 1 chose " + p1Move.getName());
        System.out.println("   Player 2 chose " + p2Move.getName());
        Outcome out = p1Move.compareTo(p2Move);

        System.out.println("   " + out.getOutcome());
        switch (out.getRoundResults()) {
            case Outcome.WIN:
                System.out.println("   Player 1 won the round");
                players.getLeft().incrementScore();
                break;
            case Outcome.LOSE:
                System.out.println("   Player 2 won the round");
                players.getRight().incrementScore();
                break;
            default:
                System.out.println("   Round was a tie");
                break;
        }
    }

    /**
     * Displays the outcome of the rounds played
     *
     * @param players Pair of players who played the game
     */
    private void displayOutcome(Pair<Player, Player> players) {
        System.out.printf("The score is %d to %d\n", players.getLeft().getScore(), players.getRight().getScore());

        int result = players.getLeft().compareTo(players.getRight());
        if (result > 0)
            System.out.println("Player 1 won the Game");
        else if (result < 0)
            System.out.println("Player 2 won the Game");
        else
            System.out.println("Game was a draw");
    }
}
