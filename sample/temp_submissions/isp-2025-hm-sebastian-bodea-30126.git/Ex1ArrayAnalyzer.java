package utcluj.aut.lab2.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * Class for generating and analyzing arrays of random integers.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex1ArrayAnalyzer {

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {
        // TODO: Implement this method
        // 1. Generate a random size between 25 and 150
        // 2. Create an array of that size
        // 3. Fill the array with random integers between -100 and 100
        // 4. Return the array

        Random random = new Random();
        int randomNumber = random.nextInt(126) + 25; // Between 25 and 150
        int[] numbers = new int[randomNumber];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = random.nextInt(201) - 100;
        }
        return numbers;
    }

    /**
     * Calculates the average value of all elements in the given array.
     *
     * @param array the array to analyze
     * @return the average value of all elements
     */
    public double calculateAverage(int[] array) {
        // TODO: Implement this method
        // 1. Calculate the sum of all elements in the array
        // 2. Return the average (sum divided by length)
        // 3. Handle edge case of empty array
        if(array.length == 0)
        {
            return 0.0;
        }
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return (double)sum / array.length;
    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        // TODO: Implement this method
        // 1. Count elements above the average
        // 2. Count elements below the average
        // 3. Return both counts as an array [countAbove, countBelow]
        int[] countAboveBelowAverage = new int[2];
        int countAbove = 0;
        int countBelow = 0;
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] > average )
                countAbove++;
            if ( array[i] < average )
                countBelow++;
        }
        countAboveBelowAverage[0] = countAbove;
        countAboveBelowAverage[1] = countBelow;
        return countAboveBelowAverage;
        //return new int[] {countAbove, countBelow};
    }

    public static void main(String[] args)
    {
        // TODO: Implement the main method
        // 1. Create an instance of ArrayAnalyzer
        // 2. Generate a random array
        // 3. Calculate the average of the array
        // 4. Count elements above and below the average
        // 5. Print the results

        Ex1ArrayAnalyzer ex1ArrayAnalyzer = new Ex1ArrayAnalyzer();
        int[] ranArray = ex1ArrayAnalyzer.generateArray();
        double average = ex1ArrayAnalyzer.calculateAverage(ranArray);
        int[] countArray = ex1ArrayAnalyzer.countAboveBelowAverage(ranArray, average);
        System.out.println("Above average nr " + countArray[0] + " below average nr " + countArray[1]);
    }
}
