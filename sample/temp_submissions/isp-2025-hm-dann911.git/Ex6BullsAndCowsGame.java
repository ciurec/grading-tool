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
        // TODO: Implement this method
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string
        Random random = new Random();
        int c = random.nextInt(10);
        int number = 0;
        int[] frecv = new int[10];
        for(int i = 0; i < 10; i++) {
            frecv[i] = 0;
        }
        for(int i = 0; i < 4; i++) {
            if(frecv[c] == 0) {
                number = number * 10 + c;
                frecv[c] = 1;
            }
            else
            {
                i--;
            }
            c = random.nextInt(10);
        }

        String secretNumber = Integer.toString(number);

        return secretNumber;
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess, String secretNumber) {
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]
        // String secretNumber = "1234";
        int[] frecv = new int[10];
        int x;
        for(int i = 0; i < 10; i++) {
            frecv[i] = 0;
        }
        if(guess.length() != 4)
        {
            throw new IllegalArgumentException("The guess must have 4 digits");
        }
        for(int i = 0; i < guess.length(); i++)
        {
            char c = guess.charAt(i);
            if(Character.isLetter(c))
            {
                throw new IllegalArgumentException("Letters are not allowed");
            }
            x = Character.getNumericValue(c);
            if(frecv[x] == 1)
            {
                throw new IllegalArgumentException("Repeated digits are not allowed");
            }
            else
            {
                frecv[x] = 1;
            }
        }
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            char d = secretNumber.charAt(i);
            int a = Character.getNumericValue(c);
            int b  = Character.getNumericValue(d);
            if(a == b)
                bulls++;
        }
        for(int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            int a = Character.getNumericValue(c);
            for(int j = 0; j < guess.length(); j++) {
                char d = secretNumber.charAt(i);
                int b  = Character.getNumericValue(d);
                if( a == b && i != j)
                    cows++;
            }
        }
        int [] result = new int[2];
        result[0] = bulls;
        result[1] = cows;
        return result;
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
        String secretNumber = "1234";
        int count = 1;
        int[] result = new int[2];
        for(String guess : guesses) {
            result = evaluateGuess(guess, secretNumber);
            if(result[0] == 4)
                return count;
            count++;
        }

        return count;
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
        String secretNumber = generateSecretNumber();
        System.out.println("Secret number: " + secretNumber);
        System.out.println("Enter your guess: ");
        int attempts = 0;
        int[] result = new int[2];
        do{
            String guess = scanner.nextLine();
            attempts++;
            result = evaluateGuess(guess, secretNumber);
            if(result[0] == 4)
                System.out.println("Correct guess: " + guess + "\nAttempts: " + attempts);
            else
                System.out.println("Incorrect guess: " + guess + " Bulls: " + result[0] + " Cows: " + result[1] + "\nTry again: ");
        }while(result[0] != 4);
    }

    public static void main(String[] args) {
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();
        game.play();
    }
}


