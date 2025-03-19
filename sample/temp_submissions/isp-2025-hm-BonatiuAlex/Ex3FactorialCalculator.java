package utcluj.aut.lab2.exercises;

import java.util.Date;
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

        if(n < 0) {
            throw new IllegalArgumentException("N shouldn't be negative");
        }
        else if(n == 0 || n == 1) {
            return 1;
        }

        return n*recursiveFactorial(n - 1);
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

        if(n < 0) {
            throw new IllegalArgumentException("N shouldn't be negative");
        }
        else if(n == 0 || n == 1) {
            return 1;
        }
        long fact = 1;
        for(int i=2;i<=n;i++) {
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
        long[] gh = new long[2];
        long startTime = System.nanoTime();
        long result1 = recursiveFactorial(n);
        long endTime = System.nanoTime();

        gh[0] = startTime - endTime;

        long startTime2 = System.nanoTime();
        long result2 = nonRecursiveFactorial(n);
        long endTime2 = System.nanoTime();

        gh[1] = startTime2 - endTime2;

        return gh;
    }

     public static void main(String[] args) {

        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)
         Ex3FactorialCalculator factor = new Ex3FactorialCalculator();

         Scanner scanner = new Scanner(System.in);

         System.out.print("Enter an integer: ");
         int num = scanner.nextInt();
         scanner.nextLine(); // Consume newline left-over after the number itself
         System.out.println("You entered: " + num);

         long primaValoare;
         long aDouaValoare;
         primaValoare = factor.recursiveFactorial(num);
         aDouaValoare = factor.nonRecursiveFactorial(num);


         long[] comparare = factor.compareExecutionTime(num);

         System.out.println(primaValoare);
         System.out.println(aDouaValoare);
         System.out.println(comparare[0]);
         System.out.println(comparare[1]);


    }
}
