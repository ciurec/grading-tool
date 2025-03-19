package utcluj.aut.lab2.exercises;

import java.util.Random;

public class Ex1ArrayAnalyzer {

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {
        Random rand = new Random();

        // 1. Generate a random size between 25 and 150
        int arraySize = rand.nextInt(126) + 25; // Generates a number between 25 and 150

        // 2. Create an array of that size
        int[] array = new int[arraySize];

        // 3. Fill the array with random integers between -100 and 100
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(201) - 100; // Random number between -100 and 100
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
        // 1. Calculate the sum of all elements in the array
        if (array.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        // 2. Return the average (sum divided by length)
        return (double) sum / array.length;
    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        // 1. Count elements above the average
        // 2. Count elements below the average
        int countAbove = 0;
        int countBelow = 0;

        for (int i=0;i<array.length;i++) {
            if (array[i] > average) {
                countAbove++;
            } else if (array[i] < average) {
                countBelow++;
            }
        }

        // 3. Return both counts as an array [countAbove, countBelow]
        return new int[] { countAbove, countBelow };
    }

    public static void main(String[] args) {
        // 1. Create an instance of ArrayAnalyzer
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();

        // 2. Generate a random array
        int[] array = analyzer.generateArray();

        // 3. Calculate the average of the array
        double average = analyzer.calculateAverage(array);

        // 4. Count elements above and below the average
        int[] counts = analyzer.countAboveBelowAverage(array, average);
        int countAbove = counts[0];
        int countBelow = counts[1];

        // 5. Print the results
        System.out.println("Generated array size: " + array.length);
        System.out.println("Average value: " + average);
        System.out.println("Numbers above average: " + countAbove);
        System.out.println("Numbers below average: " + countBelow);
    }
}
