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
        // TODO: Implement this method
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string
        Random random = new Random();
        Set<Integer> uniqueDigits = new HashSet<>();
        while (uniqueDigits.size() < 4)
        {
            int digit = random.nextInt(10);
            uniqueDigits.add(digit);
        }
        StringBuilder number = new StringBuilder();
        for (int digit : uniqueDigits)
            number.append(digit);

        return number.toString();
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
        // 1. Verificăm că ghicitul conține exact 4 cifre unice
        if (guess.length() != 4)
            throw new IllegalArgumentException("Ghicitul trebuie să conțină exact 4 cifre!");
        for (int i = 0; i < 4; i++)
        {
            if (!Character.isDigit(guess.charAt(i)))
                throw new IllegalArgumentException("Ghicitul trebuie să conțină doar cifre!");
        }
        Set<Character> uniqueDigits = new HashSet<>();
        for (int i = 0; i < 4; i++)
            uniqueDigits.add(guess.charAt(i));
        if (uniqueDigits.size() != 4)
            throw new IllegalArgumentException("Ghicitul trebuie să conțină doar cifre unice!");
        int bulls = 0, cows = 0;
        char[] secretChars = secretNumber.toCharArray();
        char[] guessChars = guess.toCharArray();
        Set<Character> secretDigits = new HashSet<>();
        for (char c : secretChars)
            secretDigits.add(c);
        for (int i = 0; i < 4; i++)
        {
            if (guessChars[i] == secretChars[i])
                bulls++;
            else if (secretDigits.contains(guessChars[i]))
                cows++;

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
        for (int i = 0; i < guesses.length; i++)
        {
            int[] result = evaluateGuess(guesses[i]);
            if (result[0] == 4)
                return i + 1;
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
        System.out.println("Bine ai venit la jocul Bulls and Cows!");
        System.out.println("Ghiceste numărul secret format din 4 cifre unice.");
        while (true)
        {
            System.out.print("Introdu ghicirea ta: ");
            String guess = scanner.nextLine();
            try
            {
                attempts++;
                int[] result = evaluateGuess(guess);
                System.out.println("Bulls: " + result[0] + ", Cows: " + result[1]);
                if (result[0] == 4)
                {
                    System.out.println("Felicitări! Ai ghicit numărul în " + attempts + " încercări.");
                    break;
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Eroare: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Ex6BullsAndCowsGame ex6BullsAndCowsGame=new Ex6BullsAndCowsGame();
        ex6BullsAndCowsGame.play();
    }
}
