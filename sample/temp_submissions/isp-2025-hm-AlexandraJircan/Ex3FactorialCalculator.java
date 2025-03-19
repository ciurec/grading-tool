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
            throw new IllegalArgumentException("n must be positive");
        long factorial;
        if(n==0||n==1)
            return 1;
        return n*recursiveFactorial(n-1);
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
        if(n<0)
            throw new IllegalArgumentException("n must be positive");
        if(n==0)
            return 1;
        long factorial=1;
        for (int i=1;i<=n;i++)
        {
            factorial=factorial*i;
        }
        return factorial;
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
        long[] executionTime=new long[2];
        long startRecursive=System.nanoTime();
        recursiveFactorial(n);
        long endRecursive=System.nanoTime();
        executionTime[0]=endRecursive-startRecursive;
        long startIterative=System.nanoTime();
        recursiveFactorial(n);
        long endIterative=System.nanoTime();
        executionTime[1]=endIterative-startIterative;
        return executionTime;
    }

     public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)
         Ex3FactorialCalculator ex3FactorialCalculator=new Ex3FactorialCalculator();
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter an integer: ");
         int n = scanner.nextInt();
         scanner.nextLine();
         System.out.println("You entered: " + n);
         long recursiveFactorial=ex3FactorialCalculator.recursiveFactorial(n);
         long iterativeFactorial=ex3FactorialCalculator.nonRecursiveFactorial(n);
         long[] executionTime= ex3FactorialCalculator.compareExecutionTime(n);
         System.out.print("Recursive factorial:"+recursiveFactorial);
         System.out.println(" execution time:"+executionTime[0]);
         System.out.print("Iterative factorial:"+iterativeFactorial);
         System.out.println(" execution time:"+executionTime[1]);
    }
}
