package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.Arrays;

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
        // 1. Split the input by semicolons
        // 2. Return the resulting array of strings
        return input.split(";");
    }

    /**
     * Finds the longest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the longest strings
     */
    public String[] findLongest(String[] strings) {
        // 1. Find the maximum string length in the array
        int maxLength = 0;
        for (String str : strings) {
            maxLength = Math.max(maxLength, str.length());
        }

        // 2. Collect all strings with that length
        ArrayList<String> longestStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() == maxLength) {
                longestStrings.add(str);
            }
        }

        // 3. Return the array of longest strings
        return longestStrings.toArray(new String[0]);
    }

    /**
     * Finds the shortest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the shortest strings
     */
    public String[] findShortest(String[] strings) {
        // 1. Find the minimum string length in the array
        int minLength = Integer.MAX_VALUE;
        for (String str : strings) {
            minLength = Math.min(minLength, str.length());
        }

        // 2. Collect all strings with that length
        ArrayList<String> shortestStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() == minLength) {
                shortestStrings.add(str);
            }
        }

        // 3. Return the array of shortest strings
        return shortestStrings.toArray(new String[0]);
    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the vowel count for each string
     */
    public int[] countVowels(String[] strings) {
        // 1. Create an array to store the counts
        int[] vowelCounts = new int[strings.length];

        // 2. For each string, count the vowels (a, e, i, o, u)
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    count++;
                }
            }
            vowelCounts[i] = count;
        }

        // 3. Return the array
        return vowelCounts;
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
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
        // 1. Count vowels in each string
        int[] vowelCounts = countVowels(strings);

        // 2. Find the maximum vowel count
        int maxVowelCount = 0;
        for (int count : vowelCounts) {
            maxVowelCount = Math.max(maxVowelCount, count);
        }

        // 3. Collect all strings with that count
        ArrayList<String> mostVowelStrings = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (vowelCounts[i] == maxVowelCount) {
                mostVowelStrings.add(strings[i]);
            }
        }

        // 4. Return the array
        return mostVowelStrings.toArray(new String[0]);
    }

    /**
     * Finds the string(s) with the most consonants.
     * If multiple strings have the same number of consonants, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most consonants
     */
    public String[] findMostConsonants(String[] strings) {
        // 1. Count consonants in each string
        int[] consonantCounts = countConsonants(strings);

        // 2. Find the maximum consonant count
        int maxConsonantCount = 0;
        for (int count : consonantCounts) {
            maxConsonantCount = Math.max(maxConsonantCount, count);
        }

        // 3. Collect all strings with that count
        ArrayList<String> mostConsonantStrings = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (consonantCounts[i] == maxConsonantCount) {
                mostConsonantStrings.add(strings[i]);
            }
        }

        // 4. Return the array
        return mostConsonantStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // 1. Create an instance of StringAnalyzer
        Ex5StringAnalyzer analyzer = new Ex5StringAnalyzer();

        // 2. Parse the input string into an array of strings
        String input = "apple;banana;cherry;kiwi;blueberry;grape";
        String[] parsedStrings = analyzer.parseInput(input);

        // 3. Find and print the longest and shortest strings
        System.out.println("Longest strings: " + Arrays.toString(analyzer.findLongest(parsedStrings)));
        System.out.println("Shortest strings: " + Arrays.toString(analyzer.findShortest(parsedStrings)));

        // 4. Count and print the number of vowels and consonants in each string
        System.out.println("Vowel counts: " + Arrays.toString(analyzer.countVowels(parsedStrings)));
        System.out.println("Consonant counts: " + Arrays.toString(analyzer.countConsonants(parsedStrings)));

        // 5. Find and print the strings with the most vowels and consonants
        System.out.println("Strings with most vowels: " + Arrays.toString(analyzer.findMostVowels(parsedStrings)));
        System.out.println("Strings with most consonants: " + Arrays.toString(analyzer.findMostConsonants(parsedStrings)));
    }
}