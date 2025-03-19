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
        // TODO: Implement this method using recursion
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        if ( n < 0 ) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }
        if (n == 0) return 1;
        // 2. Implement the recursive algorithm for factorial
        return n * recursiveFactorial(n-1);
        // 3. Remember the base case (0! = 1)

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
        if ( n < 0 ) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }
        // 2. Implement a loop-based algorithm for factorial
        if (n==0) return 1;
        long f=1;
        for ( int i=1; i<=n; i++){
            f=f*i;
        }
        // 3. Remember the base case (0! = 1)
        return f;
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
        long startRecursive = System.nanoTime();
        recursiveFactorial(n);
        long stopRecursive = System.nanoTime();
        long timpRecursive = stopRecursive - startRecursive;
        // 2. Measure the execution time of nonRecursiveFactorial
        long startNonRecursive = System.nanoTime();
        nonRecursiveFactorial(n);
        long stopNonRecursive = System.nanoTime();
        long timpNonRecursive = stopNonRecursive - startNonRecursive;
        // 3. Return both times in an array
        long[] timp = new long[2];
        timp[0]=timpRecursive;
        timp[1]=timpNonRecursive;
        return timp;
    }

     public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of FactorialCalculator
         Ex3FactorialCalculator calculator = new Ex3FactorialCalculator();
         Scanner scanner = new Scanner(System.in);
        // 2. Read an integer input from the user
         System.out.print("Enter a number: ");
         int n = scanner.nextInt();
         scanner.nextLine();
         System.out.print("You entered: " + n);
         System.out.println();
        // 3. Calculate the factorial using both recursive and non-recursive methods
         long[] timp = new long[2];
         timp=calculator.compareExecutionTime(n);
         System.out.println("Result for Recursive: " + calculator.recursiveFactorial(n) + "; Time for calculation: " + timp[0]);
         System.out.println();
         System.out.println("Result for NonRecursive: "+ calculator.nonRecursiveFactorial(n)+ "; Time for calculation: " + timp[1]);
        // 4. Compare the execution times of both methods
         System.out.println();
         if( timp[0]<timp[1]){
             System.out.println("Recursive was faster");

         }
         else {
             System.out.println("NonRecursive was faster");
         }
         // 5. Print the results (factorials and execution times)

    }
}
