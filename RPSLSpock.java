package edu.cscc;
import java.util.Random;

/**
 * Class Creates all the instance variables for rock, paper, scissors, lizard, spock. Creates methods isValidPick, generatePick, and computerWins to be used in the game.
 * @author Dr. Ty Fogle
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());
    /**
     * ROCK - Instance variable used to pass through
      */
    public static final String ROCK = "rock";
    /**
     * PAPER - Instance variable for paper.
     */
    public static final String PAPER = "paper";
    /**
     * SCISSORS - Instance variable for scissors.
     */
    public static final String SCISSORS = "scissors";
    /**
     * LIZARD - Instance variable for lizard.
     */
    public static final String LIZARD = "lizard";
    /**
     * SPOCK - Instance variable for spock.
     */
    public static final String SPOCK = "spock";

    /**
     * Method isValidPick Takes String pick and checks to see if the string is a valid option. Also ignores case for the game options.
      * @param pick Pick is the variable created to pass both the computer's choice and the users to make sure that the it is a valid choice. Pick is set to null if it is not. If it is valid it is trimmed of white space and then set to ignore case.
     * @return Returns the input Pick and ignores the case.
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * Method GeneratePick Uses a random number generator from 0 to 4, then sets this integer to the instance variable associated with such number. This process creates the computers answer.
     * @return Returns the randomized choice as Pick to be compared to the user.
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * Method isComputerWin creates all the routes where the computer wins. Setting the computers option first and then shows the two options that the human would lose.
     * @param c_pick c_pick is the Computers choice.
     * @param h_pick h_pick is the users choice.
     * @return Returns all the scenarios where the computer will beat the user. For example; rock will beat scissors and lizard.
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}