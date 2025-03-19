package utcluj.aut.lab2.exercises;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Class implementing the Bulls and Cows number guessing game.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex6BullsAndCowsGame {
    private String secretNumber;

    /**
     * Creates a new game with a random secret number.
     */
    public Ex6BullsAndCowsGame() {
        this.secretNumber = generateSecretNumber();
    }

    /**
     * Creates a new game with the specified secret number (for testing).
     *
     * @param secretNumber the secret number to use
     */
    public Ex6BullsAndCowsGame(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    /**
     * Generates a random 4-digit number with no repeated digits.
     *
     * @return a string representing the 4-digit number
     */
    public static String generateSecretNumber() {
        // TODO: Implement this method
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string

        Random rand = new Random();
        HashSet<Integer> uniqueDigits = new HashSet<>();

        while (uniqueDigits.size() < 4) {
            int random = rand.nextInt(10);
            uniqueDigits.add(random);
        }
        StringBuilder secretNumber = new StringBuilder();
        for (int num : uniqueDigits) {
            secretNumber.append(num);
        }
        return secretNumber.toString();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]

        if(guess.length() != 4)
            throw new IllegalArgumentException("Guess length must be 4");

        for (int i = 0; i < 4; ++i)
            for (int j = i + 1; j < 4; ++j)
                if(guess.charAt(i) == guess.charAt(j) || Character.isLetter(guess.charAt(i)) || Character.isLetter(guess.charAt(j)))
                    throw new IllegalArgumentException("Guess contains other characters besides digits");

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(Character.toString(guess.charAt(i)))) {
                cows++;
            }
        }
        return new int[]{bulls, cows};
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        // TODO: Implement this method
        // 1. Iterate through each guess
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses

        for (int i = 0; i < guesses.length; i++) {
            int[] result = evaluateGuess(guesses[i]);
            if (result[0] == 4) {
                return i + 1;// all bulls returning nr of attempts
            }
        }
        return guesses.length;//returning nr of guesses

    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // TODO: Implement this method
        // 1. Create a scanner for user input
        // 2. Loop until the user guesses correctly
        // 3. Validate and evaluate each guess
        // 4. Display the number of bulls and cows
        // 5. Track the number of attempts
        // 6. Display the final result

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("Try to guess the 4-digit number with unique digits.");

        while (true) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            attempts++;
            int[] result = evaluateGuess(guess);

            System.out.println("Bulls: " + result[0] + " Cows: " + result[1]);

            if (result[0] == 4) {
                System.out.println("You guessed the number in " + attempts + " attempts.");
                break;
            }
        }
        scanner.close();
    }
}
