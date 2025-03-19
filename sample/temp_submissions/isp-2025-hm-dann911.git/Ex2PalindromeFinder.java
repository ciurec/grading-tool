package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.Arrays;
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
        // TODO: Implement this method
        // 1. Convert the number to a string
        // 2. Check if the string reads the same forward and backward
        // 3. Return the result

        String str = Integer.toString(number);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        }
        return true;
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
        // 2. Create an array to store palindromic numbers
        // 3. Iterate through each number in the range [a, b]
        // 4. Check if each number is palindromic, add to array if true
        // 5. Return the array

        if(a > b)
        {
            throw new IllegalArgumentException("a > b");
        }

        int count = 0;
        for(int  i = a; i <= b; i++)
        {
            if(isPalindromic(i))
            {
                count++;
            }
        }
        int[] palindromes = new int[count];
        int index = 0;
        for(int i = a; i <= b; i++)
        {
            if(isPalindromic(i))
            {
                palindromes[index++] = i;
            }
        }
        return palindromes;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of PalindromeFinder
        // 2. Define a range of numbers to check for palindromes
        // 3. Find palindromes in the defined range
        // 4. Print the array of palindromes
        Ex2PalindromeFinder finder = new Ex2PalindromeFinder();
        int a =10;
        int b = 200;
        int[] palindromes = finder.findPalindromes(a,b);

        System.out.println("palindromes between " + a + " and " + b + " are: ");
        for(int palindrome: palindromes)
        {
            System.out.println(palindrome + " ");
        }
    }
}
