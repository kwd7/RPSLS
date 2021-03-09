package edu.cscc;

import java.util.*;

//Keegan W. DeBevoise 3/08/21
//Objectives were to create documentation and a few more tests.
//Program runs the game rock, paper, scissors, lizard, spock.

/**
 *  Main Class for Rock, Paper, Scissors, Lizard, Spock
 *This class runs the game for rock, ect..
 * @author -Dr. Ty Fogle
 */
public class Main {

    private static Scanner input = new Scanner(System.in);

    /**
     * Main method for running Rock, Paper, Scissors, Lizard, Spock. The Main method takes the users input and passes it through the isValidPick method in RPSLSpock Class to verify if the input it valid.
     * Main then compares the answer from user to the randomly generated answer. Tells the winner and then asks if the user wants to play again.
     * @param args run-time arguments
     *
     */
    public static void main(String[] args) {
        String h_pick;
        String c_pick;
        String answer;
        boolean isValid;

        do {
            System.out.println("Let's play rock, paper, scissors, lizard, spock");
            do {
                System.out.print("Enter your choice: ");
                h_pick = input.nextLine();
                isValid = RPSLSpock.isValidPick(h_pick);
                if (!isValid) {
                    System.out.println(h_pick + " is not a valid choice");
                }
            } while (!isValid);

            c_pick = RPSLSpock.generatePick();
            System.out.print("Computer picked " + c_pick + "  ");

            if (c_pick.equalsIgnoreCase(h_pick)) {
                System.out.println("Tie!");
            } else if (RPSLSpock.isComputerWin(c_pick, h_pick)) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("You win!");
            }

            System.out.print("Play again ('y' or 'n'): ");
            answer = input.nextLine();
        } while ("Y".equalsIgnoreCase(answer));
        System.out.println("Live long and prosper!");
    }
}