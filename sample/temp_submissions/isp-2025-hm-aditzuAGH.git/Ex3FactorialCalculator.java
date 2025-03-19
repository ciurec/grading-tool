package utcluj.aut.lab2.exercises;

import java.util.Scanner;

/**
 * Class for calculating factorials using recursive and non-recursive approaches.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex3FactorialCalculator {

    /**
     * Calculates the factorial of n using recursion.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long recursiveFactorial(int n) {

        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)

        if (n < 0){
            throw new IllegalArgumentException("n is zero");
        }

        if(n == 0 || n == 1){
            return 1;
        }

        return n * recursiveFactorial((n-1));
    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement a loop-based algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if (n < 0){
            throw new IllegalArgumentException("n is zero");
        }

        if(n == 0 || n == 1){
            return 1;
        }

        long fact = 1;
        for(int i = 2; i <= n; i++){
            fact *= i;
        }

        return fact;
    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {
        // 1. Measure the execution time of recursiveFactorial
        // 2. Measure the execution time of nonRecursiveFactorial
        // 3. Return both times in an array

        long startTimeRecursive = System.nanoTime();
        recursiveFactorial(n);
        long endTimeRecursive = System.nanoTime();

        long startTimeNonRecursive = System.nanoTime();
        nonRecursiveFactorial(n);
        long endTimeNonRecursive = System.nanoTime();

        return new long[] {(endTimeNonRecursive - startTimeRecursive) / 1000000, (endTimeRecursive - startTimeNonRecursive) / 1000000};

    }

     public static void main(String[] args) {

        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)

         Ex3FactorialCalculator calculator = new Ex3FactorialCalculator();
         Scanner scanner = new Scanner(System.in);

         int n = scanner.nextInt();
         long factRecursive = calculator.recursiveFactorial(n);
         long factNonRecursive = calculator.nonRecursiveFactorial(n);

         long [] array = calculator.compareExecutionTime(n);

         System.out.println(factRecursive + " executed in: " + array[0] + " ms");
         System.out.println(factNonRecursive + " executed in: " + array[1] + " ms");
    }
}
