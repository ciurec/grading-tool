package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.List;

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
        // 1. Convert the number to a string
        // 2. Check if the string reads the same forward and backward
        // 3. Return the result

        // Convertim numărul în string
        String palindromic = Integer.toString(number);
        StringBuilder invers = new StringBuilder();
        invers.append(palindromic);
        String reversed = invers.reverse().toString();
        if(reversed.equals(palindromic)) {
            return true;
        }
        return false;

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
        if(a>b)
            throw new IllegalArgumentException("A should be smaller or equal to b");
        // 2. Create an array to store palindromic numbers
        int[] result = new int[19];
        // 3. Iterate through each number in the range [a, b]
        int k=0;
        for(int i=a;i<=b;i++) {
            if(isPalindromic(i)) {
                result[k]=i;
                k++;
            }
        }
        // 4. Check if each number is palindromic, add to array if true
        // 5. Return the array
        return result;
    }

    public static void main(String[] args) {
        // 1. Create an instance of PalindromeFinder
        // 2. Define a range of numbers to check for palindromes
        // 3. Find palindromes in the defined range
        // 4. Print the array of palindromes

        Ex2PalindromeFinder finder = new Ex2PalindromeFinder();
        int[] result = finder.findPalindromes(10,200);

        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }
}
