package utcluj.aut.lab2.exercises;

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
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)
        return (n == 0) ? 1 : n * recursiveFactorial(n - 1);
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
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        // 2. Implement a loop-based algorithm for factorial
        // 3. Remember the base case (0! = 1)
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
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
        // 1. Measure the execution time of recursiveFactorial
        long startRecursive = System.nanoTime();
        recursiveFactorial(n);
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive - startRecursive;

        // 2. Measure the execution time of nonRecursiveFactorial
        long startNonRecursive = System.nanoTime();
        nonRecursiveFactorial(n);
        long endNonRecursive = System.nanoTime();
        long nonRecursiveTime = endNonRecursive - startNonRecursive;

        // 3. Return both times in an array
        return new long[]{recursiveTime, nonRecursiveTime};
    }

    public static void main(String[] args) {
        // 1. Create an instance of FactorialCalculator
        Ex3FactorialCalculator calculator = new Ex3FactorialCalculator();

        // 2. Define an integer input
        int n = 10;

        // 3. Calculate the factorial using both recursive and non-recursive methods
        long recursiveResult = calculator.recursiveFactorial(n);
        long nonRecursiveResult = calculator.nonRecursiveFactorial(n);

        // 4. Compare the execution times of both methods
        long[] times = calculator.compareExecutionTime(n);

        // 5. Print the results (factorials and execution times)
        System.out.println("Factorial of " + n + " (Recursive): " + recursiveResult);
        System.out.println("Factorial of " + n + " (Non-Recursive): " + nonRecursiveResult);
        System.out.println("Execution time (Recursive): " + times[0] + " ns");
        System.out.println("Execution time (Non-Recursive): " + times[1] + " ns");
    }
}