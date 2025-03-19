package utcluj.aut.lab2.exercises;

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

        String[] split = input.split(";");
        return split;
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
        // 2. Collect all strings with that length
        // 3. Return the array of longest strings

        int maxLength = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
            }

        }

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == maxLength) {
                count++;
            }
        }

        String[] longest = new String[count];
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length() == maxLength) {
                longest[index] = strings[i];
                index++;
            }

        }
        return longest;
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
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings

        int minLength = 10000000;
        int count = 0;
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < minLength) {
                minLength = strings[i].length();
            }

        }

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == minLength) {
                count++;
            }
        }

        String[] shortest = new String[count];
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length() == minLength) {
                shortest[index] = strings[i];
                index++;
            }

        }
        return shortest;
    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return a map from string to vowel count
     */
    public int[] countVowels(String[] strings) {

        // 1. Create a map to store the counts
        // 2. For each string, count the vowels (a, e, i, o, u)
        // 3. Store the counts in the map
        // 4. Return the map

        int k = 0;
        int[] map = new int[strings.length];
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char perLitera : strings[i].toCharArray()) {
                if (vowels.indexOf(perLitera) != -1) { // Check if character is a vowel
                    count++;
                }
            }
            map[k] = count;
            k++;
        }

        return map;
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
        // 1. Create an array to store the counts
        // 2. For each string, count the consonants (non-vowels that are letters)
        // 3. Return the array

        int[] consonantCounts = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) {
                    count++;
                }
            }
            consonantCounts[i] = count;
        }
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
        // 2. Find the maximum vowel count
        // 3. Collect all strings with that count
        // 4. Return the array

        int maxLength = 0;
        int[] map = new int[strings.length];
        int numarare = 0;
        int index = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char perLitera : strings[i].toCharArray()) {
                if (vowels.indexOf(perLitera) != -1) { // Check if character is a vowel
                    count++;
                }
            }

            map[i] = count;
        }

        for (int i = 0; i < strings.length; i++) {
          if(map[i] > maxLength) {
              maxLength = map[i];
          }}

        for (int i = 0; i < strings.length; i++) {
            if (map[i] == maxLength) {
                numarare++;
            }
        }


            String[] longest = new String[numarare];
            for (int i = 0; i < strings.length; i++) {
                if(map[i] == maxLength) {
                    longest[index] = strings[i];
                    index++;
                }

            }

        return longest;
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

        int minLength = strings.length;
        int[] map = new int[strings.length];
        int numarare = 0;
        int index = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char perLitera : strings[i].toCharArray()) {
                if (vowels.indexOf(perLitera) != -1) { // Check if character is a vowel
                    count++;
                }
            }

            map[i] = count;
        }

        for (int i = 0; i < strings.length; i++) {
            if(map[i] < minLength) {
                minLength = map[i];
            }
        }

        for (int i = 0; i < strings.length; i++) {
            if (map[i] == minLength) {
                numarare++;
            }
        }


        String[] shortest = new String[numarare];
        for (int i = 0; i < strings.length; i++) {
            if(map[i] == minLength) {
                shortest[index] = strings[i];
                index++;
            }

        }

        return shortest;
    }

    public static void main(String[] args) {

        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants

        String input = "apple;banana;cherry";

        Ex5StringAnalyzer obj = new Ex5StringAnalyzer();
        String[] strings = obj.parseInput(input);
        System.out.println(Arrays.toString(obj.findLongest(strings)));
        System.out.println(Arrays.toString(obj.findShortest(strings)));
        System.out.println(Arrays.toString(obj.countVowels(strings)));
        System.out.println(Arrays.toString(obj.countConsonants(strings)));
        System.out.println(Arrays.toString(obj.findMostVowels(strings)));
        System.out.println(Arrays.toString(obj.findMostConsonants(strings)));
    }
}