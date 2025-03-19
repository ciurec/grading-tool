package utcluj.aut.lab2.exercises;

import java.util.Random;

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
        Random rand = new Random();
        int size = rand.nextInt(126) + 25;
        // 2. Create an array of that size
        int[] array = new int[size];
        // 3. Fill the array with random integers between -100 and 100
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(201) - 100;
        }
        // 4. Return the array
        return array;
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
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (array.length == 0) return 0.0;
        else return sum / array.length;

        // 2. Return the average (sum divided by length)
        // 3. Handle edge case of empty array

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
        int[] counts = new int[2];
        int aboveCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                aboveCount++;
            }
        }
        // 2. Count elements below the average
        int belowCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                belowCount++;
            }
        }
        // 3. Return both counts as an array [countAbove, countBelow]
        counts[0] = aboveCount;
        counts[1] = belowCount;
        return counts;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of ArrayAnalyzer
        Ex1ArrayAnalyzer ex1ArrayAnalyzer = new Ex1ArrayAnalyzer();
        // 2. Generate a random array
        int[] array = ex1ArrayAnalyzer.generateArray();
        // 3. Calculate the average of the array
        double average = ex1ArrayAnalyzer.calculateAverage(array);
        // 4. Count elements above and below the average
        int[] count = ex1ArrayAnalyzer.countAboveBelowAverage(array, average);
        // 5. Print the results
        System.out.println(
                "Above average: " + count[0] + ", below average: " + count[1]
        );
    }
}
