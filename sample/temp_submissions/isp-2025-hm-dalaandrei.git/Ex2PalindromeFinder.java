package utcluj.aut.lab2.exercises;

import java.util.ArrayList;

/**
 * Class for finding palindromic numbers in a given range.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex2PalindromeFinder {

    /**
     * Checks if a number is palindromic (reads the same backward as forward).
     *
     * @param number the number to check
     * @return true if the number is palindromic, false otherwise
     */
    public boolean isPalindromic(int number) {
        // TODO: Implement this method
        // 1. Convert the number to a string
        String numar = Integer.toString(number);
        // 2. Check if the string reads the same forward and backward
        String reversed = new StringBuilder(numar).reverse().toString();
        if (numar.equals(reversed)) {
            return true;
        }
        else {
            return false;
        }
        // 3. Return the result
    }

    /**
     * Finds all palindromic numbers in the given range [a, b], inclusive.
     *
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return an array of all palindromic numbers in the range
     * @throws IllegalArgumentException if a > b
     */
    public int[] findPalindromes(int a, int b) {
        // TODO: Implement this method
        // 1. Validate that a <= b, throw IllegalArgumentException if not
        if (a > b) {
            throw new IllegalArgumentException("a must be greater than b");
        }
        // 2. Create an array to store palindromic numbers
        int[] palindromes = new int[(b - a + 1)/10];
        // 3. Iterate through each number in the range [a, b]
        int k = 0;
        for (int i = a; i <= b; i++) {
            if(isPalindromic(i)) {
                palindromes[k++] = i;
            }
        }
        // 4. Check if each number is palindromic, add to array if true
        // 5. Return the array
        return palindromes;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of PalindromeFinder
        Ex2PalindromeFinder ex2PalindromeFinder = new Ex2PalindromeFinder();

        // 2. Define a range of numbers to check for palindromes
        int a = 10;
        int b= 1000;
        // 3. Find palindromes in the defined range
        int[] palindromes = ex2PalindromeFinder.findPalindromes(a, b);
        // 4. Print the array of palindromes
        for (int i = 0; i < palindromes.length; i++) {
            System.out.println(palindromes[i]);

        }
    }
}
