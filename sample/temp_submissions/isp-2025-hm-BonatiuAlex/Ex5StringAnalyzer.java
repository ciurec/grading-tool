package utcluj.aut.lab2.exercises;

/**
 * Class for analyzing strings.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex5StringAnalyzer {

    /**
     * Parses the input string into an array of strings, splitting by semicolons.
     *
     * @param input the input string to parse
     * @return an array of strings
     */
    public String[] parseInput(String input) {
        // TODO: Implement this method
        // 1. Split the input by semicolons
        // 2. Return the resulting array of strings
        return null;
    }

    /**
     * Finds the longest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the longest strings
     */
    public String[] findLongest(String[] strings) {
        // TODO: Implement this method
        // 1. Find the maximum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of longest strings
        return null;
    }

    /**
     * Finds the shortest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the shortest strings
     */
    public String[] findShortest(String[] strings) {
        // TODO: Implement this method
        // 1. Find the minimum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings
        return null;
    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return a map from string to vowel count
     */
    public int[] countVowels(String[] strings) {
        // TODO: Implement this method
        // 1. Create a map to store the counts
        // 2. For each string, count the vowels (a, e, i, o, u)
        // 3. Store the counts in the map
        // 4. Return the map
        return new int[0];
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
        // TODO: Implement this method
        // 1. Create an array to store the counts
        int[] consonantCounts = new int[strings.length];
        // 2. For each string, count the consonants (non-vowels that are letters)
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) {
                    count++;
                }
            }
            consonantCounts[i] = count;
        }
        // 3. Return the array
        return consonantCounts;
    }

    /**
     * Finds the string(s) with the most vowels.
     * If multiple strings have the same number of vowels, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most vowels
     */
    public String[] findMostVowels(String[] strings) {
        // TODO: Implement this method
        // 1. Count vowels in each string
        // 2. Find the maximum vowel count
        // 3. Collect all strings with that count
        // 4. Return the array
        return null;
    }

    /**
     * Finds the string(s) with the most consonants.
     * If multiple strings have the same number of consonants, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most consonants
     */
    public String[] findMostConsonants(String[] strings) {
        // TODO: Implement this method
        // 1. Count consonants in each string
        // 2. Find the maximum consonant count
        // 3. Collect all strings with that count
        // 4. Return the array
        return null;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants
    }
}