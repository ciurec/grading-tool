package utcluj.aut.lab2.exercises;

import java.sql.SQLOutput;

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
        // TODO: Implement this method using recursion
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)

        if(n >= 1){
            return n * recursiveFactorial(n-1);
        }
        else if(n == 0){
            return 1;
        }
        else{
            throw new IllegalArgumentException("n is negative");
        }

    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {
        // TODO: Implement this method using a loop (not recursion)
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement a loop-based algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if(n < 0){
            throw new IllegalArgumentException("The number must be positive");
        }
        else if(n == 0){
            return 1;
        }
        else
        {
            long result = 1;
            for(int i = 1; i <= n; i++){
                result *= i;
            }
            return result;
        }
    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {
        // TODO: Implement this method
        // 1. Measure the execution time of recursiveFactorial
        // 2. Measure the execution time of nonRecursiveFactorial
        // 3. Return both times in an array
        long startTime, endTime;
        startTime = System.nanoTime();
        recursiveFactorial(n);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        startTime = System.nanoTime();
        nonRecursiveFactorial(n);
        endTime = System.nanoTime();
        long nonRecursiveTime = endTime - startTime;

        return new long[]{recursiveTime, nonRecursiveTime};

    }

     public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)
         Ex3FactorialCalculator calculator = new Ex3FactorialCalculator();
         java.util.Scanner scanner = new java.util.Scanner(System.in);

         System.out.print("Enter the number : ");
         int number = scanner.nextInt();

         long recursiveResult = calculator.recursiveFactorial(number);
         long nonRecursiveResult = calculator.nonRecursiveFactorial(number);
         long[] time = calculator.compareExecutionTime(number);

         System.out.println("Recursive factorial of " + number + " is " + recursiveResult);
         System.out.println("Non-recursive factorial of " + number + " is " + nonRecursiveResult);
         System.out.println("Recursive method execution time: " + time[0] + " ns");
         System.out.println("Non-recursive method execution time: " + time[1] + " ns");

         scanner.close();

    }
}
