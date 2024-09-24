package card;

import java.util.Random;
import java.util.Scanner;

/**
 * CardTrick program simulates a magic hand with random cards
 * and checks if the user’s selected card is part of the magic hand.
 * 
 * <p><strong>Student Name:</strong> [RuchitRadadiya]</p>
 * <p><strong>Student Number:</strong> [991701868]</p>
 * 
 * @author [RuchitRadadiya]
 * @version 1.0
 */
public class CardTrick {

    public static void main(String[] args) {
        // Available card suits and values
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};  // 1-13 represent Ace to King

        // Create an array to store 7 randomly generated cards (the "magic hand")
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            magicHand[i] = new Card();
            magicHand[i].setValue(values[random.nextInt(values.length)]);
            magicHand[i].setSuit(suits[random.nextInt(suits.length)]);
            System.out.println(magicHand[i].getSuit() + " " + magicHand[i].getValue());
        }

        // Ask user for a card value and suit
        Scanner scanner = new Scanner(System.in);
        
        // Get and validate card value (1-13)
        int userValue = 0;
        while (userValue < 1 || userValue > 13) {
            System.out.print("Enter a card value (1-13): ");
            if (scanner.hasNextInt()) {
                userValue = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 13.");
                scanner.next(); // Clear invalid input
            }
        }

        // Get and validate suit (0-3 corresponds to Hearts, Diamonds, Clubs, Spades)
        int suitIndex = -1;
        while (suitIndex < 0 || suitIndex > 3) {
            System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
            if (scanner.hasNextInt()) {
                suitIndex = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 3.");
                scanner.next(); // Clear invalid input
            }
        }
        String userSuit = suits[suitIndex];

        // Check if the user-selected card is in the magic hand
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                cardFound = true;
                break;
            }
        }

        // Display the result
        if (cardFound) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Close scanner
        scanner.close();
    }
}

/**
 * Card class represents a single card with a suit and value.
 */
class Card {
    private int value;  // Value of the card (1-13)
    private String suit;  // Suit of the card (Hearts, Diamonds, Clubs, Spades)

    // Getter for card value
    public int getValue() {
        return value;
    }

    // Setter for card value
    public void setValue(int value) {
        this.value = value;
    }

    // Getter for card suit
    public String getSuit() {
        return suit;
    }

    // Setter for card suit
    public void setSuit(String suit) {
        this.suit = suit;
    }
}
