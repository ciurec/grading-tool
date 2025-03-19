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
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if(n<0)
            throw new IllegalArgumentException("n should be positive");
        else if(n<=1)
            return 1;
        return recursiveFactorial(n-1)*n;
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
        if(n<0) throw  new IllegalArgumentException("n should be positive");
        long result = 1;
        while(n>=1) {
            result *= n;
            n--;
        }
        return result;
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

        long startTime = System.nanoTime();
        long recursiveResult = recursiveFactorial(n);
        long recursiveTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long nonRecursiveResult = nonRecursiveFactorial(n);
        long nonRecursiveTime = System.nanoTime() - startTime;

        return new long[]{recursiveTime, nonRecursiveTime};
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)
        Ex3FactorialCalculator ex3FactorialCalculator = new Ex3FactorialCalculator();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long iterativeResult=ex3FactorialCalculator.nonRecursiveFactorial(n);
        long recursiveResult=ex3FactorialCalculator.recursiveFactorial(n);
        long []result=ex3FactorialCalculator.compareExecutionTime(n);
        if(result[0]<result[1])
            System.out.println("The recursive method is faster than the iterative method");
        else System.out.println("The iterative method is faster than the recursive method");
        System.out.println("Iterative result is: "+iterativeResult+" Duration time: "+result[1]);
        System.out.println("Recursive result is: "+recursiveResult+" Duration time: "+result[0]);
    }
}