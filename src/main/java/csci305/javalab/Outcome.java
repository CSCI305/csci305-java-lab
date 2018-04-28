package csci305.javalab;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * A simple object to hold the results of a round of the game
 *
 * @author Isaac Griffith
 * @version 1.0
 */
public class Outcome {

	// The possible messages
	private static final String SCP  = "Scissors cut Paper";
	private static final String PCR  = "Paper covers Rock";
	private static final String RCL  = "Rock crushes Lizard";
	private static final String LPS  = "Lizard poisons Spock";
	private static final String SSS  = "Spock smashes Scissors";
	private static final String SDL  = "Scissors decapitate Lizard";
	private static final String LEP  = "Lizard eats Paper";
	private static final String PDS  = "Paper disproves Spock";
	private static final String SVR  = "Spock vaporizes Rock";
	private static final String RCS  = "Rock crushes Scissors";

	private static Table<String, String, String> messages;

	/**
	 * Static initializer to complete the table for message lookup
	 */
	static {
		messages = HashBasedTable.create();
		messages.put("Scissors", "Paper", SCP);
		messages.put("Paper", "Scissors", SCP);
		messages.put("Paper", "Rock", PCR);
		messages.put("Rock", "Paper", PCR);
		messages.put("Rock", "Lizard", RCL);
		messages.put("Lizard", "Rock", RCL);
		messages.put("Lizard", "Spock", LPS);
		messages.put("Spock", "Lizard", LPS);
		messages.put("Spock", "Scissors", SSS);
		messages.put("Scissors", "Spock", SSS);
		messages.put("Scissors", "Lizard", SDL);
		messages.put("Lizard", "Scissors", SDL);
		messages.put("Lizard", "Paper", LEP);
		messages.put("Paper", "Lizard", LEP);
		messages.put("Paper", "Spock", PDS);
		messages.put("Spock", "Paper", PDS);
		messages.put("Spock", "Rock", SVR);
		messages.put("Rock", "Spock", SVR);
		messages.put("Rock", "Scissors", RCS);
		messages.put("Scissors", "Rock", RCS);
	}

	// The possible round outcomes
	public static final String WIN  = "Win";
	public static final String LOSE = "Lose";
	public static final String TIE  = "Tie";

	/**
	 * The display message
	 */
	private String outcome;
	/**
	 * The Round result
	 */
	private String roundResult;

	/**
	 * Private constructor used to create a new Outcome with the provided message and round result
	 * @param outcome message
	 * @param roundResult result
 	 */
	private Outcome(String outcome, String roundResult) {
		this.outcome = outcome;
		this.roundResult = roundResult;
	}

	/**
	 * Factory Method to construct a Win Outcome
	 * @param first First element
	 * @param second Second element
	 * @return a new outcome with a message based on the provided elements and the knowledge that this is a WIN
	 */
	public static Outcome win(Element first, Element second) {
		return new Outcome(selectMessage(first, second), WIN);
	}

	/**
	 * Factory Method to construct a Tie Outcome
	 * @param first First element
	 * @param second Second element
	 * @return a new outcome with a Tie message based on the provided elements
	 */
	public static Outcome tie(Element first, Element second) {
		return new Outcome(String.format("%s equals %s", first.getName(), second.getName()), TIE);
	}

	/**
	 * Factory Method to construct a Loss Outcome
	 * @param first First Element
	 * @param second Second Element
	 * @return a new outcome with a Loss message based on the provided elements and knowledge that this is a LOSE
	 */
	public static Outcome loss(Element first, Element second) {
		return new Outcome(selectMessage(first, second), LOSE);
	}

	/**
	 * Table lookup for the message to be displayed
	 * @param first First Element
	 * @param second Second Element
	 * @return looks up the message for the display based on the provided element names.
	 */
	private static String selectMessage(Element first, Element second) {
		return messages.get(first.getName(), second.getName());
	}

	/**
	 * @return The message associated with this outcome
	 */
	public String getOutcome() {
		return outcome;
	}

	/**
	 * @return The results of the round encoded in this outcome
	 */
	public String getRoundResults() {
		return roundResult;
	}

	/**
	 * @return A string representation of the outcome
	 */
	public String toString() {
		return outcome + " -- " + roundResult;
	}
}
