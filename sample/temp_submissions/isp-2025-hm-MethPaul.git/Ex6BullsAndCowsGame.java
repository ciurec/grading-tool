package utcluj.aut.lab2.exercises;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
        // 1. Generate 4 unique random digits (no repeats)
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();

        while (digits.size() < 4) {
            digits.add(random.nextInt(10)); // 0-9 digits
        }

        // 2. Concatenate them into a string
        StringBuilder secret = new StringBuilder();
        for (int digit : digits) {
            secret.append(digit);
        }

        // 3. Return the string
        return secret.toString();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {
        // 1. Validate the guess (4 digits, no repeats)
        if (guess.length() != 4 || !guess.matches("\\d{4}") || hasDuplicateDigits(guess)) {
            throw new IllegalArgumentException("Invalid guess! Must be a 4-digit number with unique digits.");
        }

        int bulls = 0;
        int cows = 0;

        // 2. Count bulls (correct digit in correct position)
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                // 3. Count cows (correct digit in wrong position)
                cows++;
            }
        }

        // 4. Return both counts as an array [bulls, cows]
        return new int[]{bulls, cows};
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        // 1. Iterate through each guess
        for (int attempt = 0; attempt < guesses.length; attempt++) {
            int[] result = evaluateGuess(guesses[attempt]);

            // 2. Evaluate the guess
            if (result[0] == 4) {
                // 3. If all bulls, return the number of attempts
                return attempt + 1;
            }
        }

        // 4. If no correct guess, return the number of guesses
        return guesses.length;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // 1. Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("Try to guess the 4-digit secret number with unique digits.");

        while (true) {
            // 2. Loop until the user guesses correctly
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            try {
                // 3. Validate and evaluate each guess
                int[] result = evaluateGuess(guess);
                attempts++;

                // 4. Display the number of bulls and cows
                System.out.println("Bulls: " + result[0] + ", Cows: " + result[1]);

                // 5. Track the number of attempts
                if (result[0] == 4) {
                    // 6. Display the final result
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * Helper method to check if a string has duplicate digits.
     *
     * @param str the string to check
     * @return true if the string has duplicate digits, false otherwise
     */
    private boolean hasDuplicateDigits(String str) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!uniqueDigits.add(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Uncomment the next line to play the interactive game
        // new Ex6BullsAndCowsGame().play();

        // Testing the game with a predefined secret number
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame("1234");
        String[] testGuesses = {"5678", "4321", "1243", "1234"};

        int attempts = game.playTestGame(testGuesses);
        System.out.println("Game completed in " + attempts + " attempts.");
    }
}