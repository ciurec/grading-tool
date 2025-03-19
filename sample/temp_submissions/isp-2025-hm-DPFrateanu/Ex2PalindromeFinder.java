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
    public static boolean isPalindromic(int number) {
        // TODO: Implement this method
        // 1. Convert the number to a string
        String numberString = String.valueOf(number);
        // 2. Check if the string reads the same forward and backward
        for (int i = 0; i < numberString.length() / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) { return false; }
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
        // TODO: Implement this method
        // 1. Validate that a <= b, throw IllegalArgumentException if not
        // 2. Create an array to store palindromic numbers
        // 3. Iterate through each number in the range [a, b]
        // 4. Check if each number is palindromic, add to array if true
        // 5. Return the array
        if (a > b) {
            throw new IllegalArgumentException("a cannot be greater than b");
        }
        int size=0;
        int [] array = new int [b-a+1];
        for (int i=a;i<=b;i++) {
            if(isPalindromic(i))
            {
                array[size++]=i;
            }
        }
        int count=0;
        for(int j=0;j<array.length;j++)
        {
            if(array[j]!=0)
                count++;
        }
        int []palindromesArray = new int[count];
        for(int j=0;j<count;j++)
            palindromesArray[j]=array[j];
        return palindromesArray;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of PalindromeFinder
        // 2. Define a range of numbers to check for palindromes
        // 3. Find palindromes in the defined range
        // 4. Print the array of palindromes
        Ex2PalindromeFinder finder = new Ex2PalindromeFinder();
        int a = 10;
        int b = 200;
        int []array=finder.findPalindromes(a, b);
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }

    }
}
