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
        int firstRandomDigit = random.nextInt(10);
        String secretNumber=firstRandomDigit + "";
        while(secretNumber.length()<4){
            int randomDigit = random.nextInt(10);
            boolean ok=true;
            for(int i=0;i<secretNumber.length();i++){
                if(secretNumber.charAt(i)==(char) (randomDigit + '0')){
                    ok=false;
                }
            }
            if(ok)
                secretNumber=secretNumber+randomDigit+"";
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
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]
        int bulls = 0; int  cows = 0;
        if(guess.length()!=secretNumber.length()){
            throw new IllegalArgumentException("guess length not equal to secret length");
        }
        for(char c :guess.toCharArray()){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("guess contains non-digit character");
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            for(int j = i+1; j < guess.length(); j++) {
                if (guess.charAt(i) == guess.charAt(j)) {
                    throw new IllegalArgumentException("guess contains the same character");
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
            }
        }
        for (int i = 0; i < secretNumber.length(); i++) {
            for(int  j = 0; j < guess.length(); j++) {
                if(i!=j&&secretNumber.charAt(i) == guess.charAt(j)) {
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
        // TODO: Implement this method
        // 1. Iterate through each guess
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses
        int count=1;
        for(String guess : guesses){
            int []bullsAndCows=evaluateGuess(guess);
            if(bullsAndCows[0]==4){
              return count;
            }
            count++;
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
        Scanner scan = new Scanner(System.in);
        String guess= scan.nextLine(); int attempts=1;
        int []bullsAndCows=evaluateGuess(guess);
        while(bullsAndCows[0]!=4){
            guess=scan.nextLine();
            bullsAndCows=evaluateGuess(guess);
            System.out.println("Bulls: "+bullsAndCows[0]);
            System.out.println("Cows: "+bullsAndCows[1]);
            attempts++;
        }
        System.out.println("secret number :"+guess+"\nAttempts: "+attempts);
    }
}
