package utcluj.aut.lab2.exercises;

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
        String str = Integer.toString(number);
        // 2. Check if the string reads the same forward and backward
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        // 3. Return the result
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
        // 1. Validate that a <= b, throw IllegalArgumentException if not
        if (a > b) {
            throw new IllegalArgumentException("Invalid range: a must be less than or equal to b.");
        }

        // 2. Create an array to store palindromic numbers
        java.util.List<Integer> palindromeList = new java.util.ArrayList<>();

        // 3. Iterate through each number in the range [a, b]
        for (int i = a; i <= b; i++) {
            // 4. Check if each number is palindromic, add to array if true
            if (isPalindromic(i)) {
                palindromeList.add(i);
            }
        }

        // 5. Return the array
        return palindromeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // 1. Create an instance of PalindromeFinder
        Ex2PalindromeFinder finder = new Ex2PalindromeFinder();

        // 2. Define a range of numbers to check for palindromes
        int a = 10, b = 200;

        // 3. Find palindromes in the defined range
        int[] palindromes = finder.findPalindromes(a, b);

        // 4. Print the array of palindromes
        System.out.print("Palindromic numbers in range [" + a + ", " + b + "]: ");
        for (int num : palindromes) {
            System.out.print(num + " ");
        }
    }
}