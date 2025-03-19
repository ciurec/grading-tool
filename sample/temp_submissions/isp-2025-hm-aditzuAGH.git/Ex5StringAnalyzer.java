package utcluj.aut.lab2.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        String [] splitInput = input.split(";");

        return splitInput;
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

        String longest = strings[0];
        int index = 0;
        for (String string : strings) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }

        int size = 0;
        for(String string : strings) {
            if (string.length() == longest.length()) {
                size++;
            }
        }

        String[] longestArray = new String[size];
        for(String string : strings) {
            if (string.length() == longest.length()) {
                longestArray[index++] = string;
            }
        }


        return longestArray;
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
        String shortest = strings[0];
        int index = 0;
        for (String string : strings) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
        }

        int size = 0;
        for(String string : strings) {
            if (string.length() == shortest.length()) {
                size++;
            }
        }

        String[] shortestArray = new String[size];
        for(String string : strings) {
            if (string.length() == shortest.length()) {
                shortestArray[index++] = string;
            }
        }


        return shortestArray;
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

        int [] vowelsCount = new int [strings.length];

        for(int i = 0; i < strings.length; i++) {
            int count = 0;
            for(char c : strings[i].toCharArray()) {
                if(Character.isLetter(c) && "aeiouAEIOU".indexOf(c) > -1){
                    count++;
                }
            }
            vowelsCount[i] = count;
        }
        // Testul nu va functiona deoarece in test se considera ca "cherry" are doua vocale
        return vowelsCount;
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
        // 2. Find the maximum vowel count
        // 3. Collect all strings with that count
        // 4. Return the array
        int max = 0;
        int [] nrVowels = countVowels(strings);
        for (int i = 0; i < strings.length; i++) {
            if(nrVowels[i] > max) {
                max = nrVowels[i];
            }
        }

        int size = 0;

        for (int i = 0; i < strings.length; i++) {
            if(nrVowels[i] == max) {
                size++;
            }
        }

        String [] mostVowels = new String[size];
        int index = 0;

        for (int i = 0; i < strings.length; i++) {
            if(nrVowels[i] == max) {
                mostVowels[index++] = strings[i];
            }
        }
        return mostVowels;
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
        // 2. Find the maximum consonant count
        // 3. Collect all strings with that count
        // 4. Return the array

        int max = 0;
        int [] nrCons = countConsonants(strings);
        for (int i = 0; i < strings.length; i++) {
            if(nrCons[i] > max) {
                max = nrCons[i];
            }
        }

        int size = 0;

        for (int i = 0; i < strings.length; i++) {
            if(nrCons[i] == max) {
                size++;
            }
        }

        String [] mostCons = new String[size];
        int index = 0;

        for (int i = 0; i < strings.length; i++) {
            if(nrCons[i] == max) {
                mostCons[index++] = strings[i];
            }
        }
        return mostCons;
    }

    public static void main(String[] args) {
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants

        Ex5StringAnalyzer analyzer = new Ex5StringAnalyzer();

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        String [] parsedString = analyzer.parseInput(string);

        String [] longest = analyzer.findLongest(parsedString);
        for (int i = 0; i < longest.length; i++) {
            System.out.println(longest[i]);
        }
        String [] shortest = analyzer.findShortest(parsedString);
        for (int i = 0; i < shortest.length; i++) {
            System.out.println(shortest[i]);
        }

        int [] countVowels = analyzer.countVowels(parsedString);
        for(int i = 0; i < countVowels.length; i++) {
            System.out.println(countVowels[i]);
        }
        int [] countConsonants = analyzer.countConsonants(parsedString);
        for(int i = 0; i < countConsonants.length; i++) {
            System.out.println(countConsonants[i]);
        }

        String [] mostVowels = analyzer.findMostVowels(parsedString);
        for(int i = 0; i < mostVowels.length; i++) {
            System.out.println(mostVowels[i]);
        }
        String [] mostCons = analyzer.findMostConsonants(parsedString);
        for(int i = 0; i < mostCons.length; i++) {
            System.out.println(mostCons[i]);
        }
    }
}