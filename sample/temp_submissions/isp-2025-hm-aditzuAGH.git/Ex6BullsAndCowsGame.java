package utcluj.aut.lab2.exercises;

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
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string

        Random rand = new Random();
        String secretNumber = "";

        boolean[] isValid = new boolean[10];
        for(int i = 0; i < 10; i++) {
            isValid[i] = true;
        }
        int digit = rand.nextInt(10);
        for(int i = 0; i < 4; i++){
            while(!isValid[digit]){
                digit = rand.nextInt(10);
            }
            isValid[digit] = false;
            secretNumber += digit;
        }

        return secretNumber;
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
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]

        if(guess.length() < 4) {
            throw new IllegalArgumentException("Guess must be at least 4 characters");
        }
        if(guess.length() > 4) {
            throw new IllegalArgumentException("Guess must be at most 4 characters");
        }

        for(int i = 0; i < guess.length(); i++) {
            if(Character.isLetter(guess.charAt(i))) {
                throw new IllegalArgumentException("Invalid guess (non-numeric)");
            }
        }

        int [] validGuess = new int[10];
        for(int i = 0; i < 10; i++) {
            validGuess[i] = 0;
        }
        for(int i = 0; i < guess.length(); i++) {
            validGuess[guess.charAt(i) - '0']++;

        }

        for(int i = 0; i < guess.length(); i++) {
            if(validGuess[guess.charAt(i) - '0'] > 1) {
                throw new IllegalArgumentException("Invalid guess (repeated digit)");

            }
        }

        int bulls = 0;
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) - '0' == secretNumber.charAt(i) - '0') {
                bulls++;
            }
        }

        int cows = 0;
        for(int i = 0; i < guess.length(); i++) {
            for(int j = 0; j < guess.length(); j++) {
                if(guess.charAt(i) - '0' == secretNumber.charAt(j) - '0' && i != j) {
                    cows++;
                }
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
        // 1. Iterate through each guess
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses
        int count = 0;
        for(String guess : guesses) {
            count++;
            int[] guessResult = evaluateGuess(guess);
            if(guessResult[0] == 4) {
                return count;
            }
        }

        return guesses.length;
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
        while(true) {
            attempts++;
            String guess = scanner.nextLine();
            int[] guessResult = evaluateGuess(guess);
            if(guessResult[0] == 4) {
                System.out.println("Congratulations! You win!");
                break;
            }
            System.out.println("You got: " + guessResult[0] + " Bulls, " + guessResult[1] + " Cows");
            System.out.println("Try again: ");

        }

        System.out.println("You guessed in " + attempts + " attempts");

    }

    public static void main(String[] args) {
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();
        game.play();
    }
}
