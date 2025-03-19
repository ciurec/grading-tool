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
        StringBuilder secretNumber = new StringBuilder();
        Random random = new Random();
        int[] frec = new int[10];
        for (int i = 0; i < frec.length; i++) {
            frec[i] = 0;
        }
        int cifra,i;
        i=0;
        int numere=0;
        while (secretNumber.length() < 4) {
            cifra = random.nextInt(10);
            if(frec[cifra] == 0) {
                secretNumber.append(Integer.toString(cifra));
                frec[cifra]=1;
                numere++;
            }
        }
        // 2. Concatenate them into a string
        // 3. Return the string
        return secretNumber.toString();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess, String secretNumber) { //, String secretNumber
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        if (guess.length() != 4) {
            throw new IllegalArgumentException("The given guess is not a 4 digit number");
        }
        int[] frec = new int[10];
        int x,y;
        for (int i = 0; i < frec.length; i++) {
            frec[i] = 0;
        }
        for (int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);
                if (Character.isLetter(c)) {
                    throw new IllegalArgumentException("Guess may only contain digits");
                }
                x=Character.getNumericValue(c);
                if(frec[x] != 0) {
                    throw new IllegalArgumentException("Guess contains different characters");
                }
                frec[x]=1;

        }
        // 2. Count bulls (correct digit in correct position)
        int bulls = 0;
       // String secretNumber = "1234";
        //String secretNumber = generateSecretNumber();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            x=Character.getNumericValue(c);
            char d = secretNumber.charAt(i);
            y=Character.getNumericValue(d);
            if(x == y){
                bulls++;
            }
        }
        // 3. Count cows (correct digit in wrong position)
        int cows=0;
        for(int i=0; i<guess.length(); i++) {
            char d = secretNumber.charAt(i);
            y = Character.getNumericValue(d);
            for (int j = 0; j < guess.length(); j++) {
                if (i != j) {
                    char c = guess.charAt(j);
                    x = Character.getNumericValue(c);
                    if (x == y)
                        cows++;
                }
            }
        }
        // 4. Return both counts as an array [bulls, cows]
        int[] result = new int[2];
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
        String secretNumber = "1234";
        // 1. Iterate through each guess
        int[] result = new int[2];
        int attempts=0;
        for (String guess : guesses) {
            attempts++;
            result = evaluateGuess(guess, secretNumber);
            if (result[0] == 4) return attempts;
        }
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses
        return attempts;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // TODO: Implement this method
        // 1. Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        // 2. Loop until the user guesses correctly
        String secretNumber = new String();
        secretNumber = generateSecretNumber();
        System.out.println("Secret number: " + secretNumber); // test
        System.out.println("Type your guess: ");
        int attempts = 0;
        // 3. Validate and evaluate each guess
        int[] result = new int[2];
        do {
            String guess = scanner.nextLine();
            attempts++;
            result = evaluateGuess(guess, secretNumber); //, secretNumber
            if (result[0]==4) System.out.println("Correct guess: " + guess + "; Total attempts: " + attempts);
            else System.out.println("Incorrect guess: " + guess + "; Bulls: " + result[0] + "; Cows: " + result[1] + "\nTry again: ");
        }while (result[0]!=4);
        // 4. Display the number of bulls and cows
        // 5. Track the number of attempts
        // 6. Display the final result
    }

    public static void main(String[] args) {
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();
        game.play();
    }
}
