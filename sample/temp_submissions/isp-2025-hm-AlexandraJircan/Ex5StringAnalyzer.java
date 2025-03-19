package utcluj.aut.lab2.exercises;

import utcluj.aut.lab2.demo.InstanceAttributeDemo;

import java.util.ArrayList;
import java.util.List;

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
        String[] fruits = input.split(";");
        return fruits;
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
        int maxLength=strings[0].length();
        for(int i=1;i< strings.length;i++)
        {
            if(strings[i].length()>maxLength)
                maxLength=strings[i].length();
        }
        List<String> longestStrings = new ArrayList<>();
        for (String str : strings)
        {
            if (str.length() == maxLength)
                longestStrings.add(str);
        }
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
        // TODO: Implement this method
        // 1. Find the minimum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings
        int minLength=strings[0].length();
        for(int i=1;i< strings.length;i++)
        {
            if(strings[i].length()<minLength)
                minLength=strings[i].length();
        }
        List<String> shortestStrings = new ArrayList<>();
        for (String str : strings)
        {
            if (str.length() == minLength)
                shortestStrings.add(str);
        }
        return shortestStrings.toArray(new String[0]);
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
        if(strings==null)
            return new int[0];
        int[] vowelCounts =new int[strings.length];
        String vowels="aeiouAEIOU";
        for(int i=0;i<strings.length;i++)
        {
            int count=0;
            for(char ch:strings[i].toCharArray())
            {
                if(vowels.indexOf(ch)!=-1)
                    count++;
            }
            vowelCounts[i]=count;
        }
        return vowelCounts;
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
        int[] vowelCounts = new int[strings.length];
        vowelCounts=countVowels(strings);
        int maxVowels=vowelCounts[0];
        for(int i=1;i<vowelCounts.length;i++)
        {
            if(vowelCounts[i]>maxVowels)
                maxVowels=vowelCounts[i];
        }
        List<String> mostVowels = new ArrayList<>();;
        for(int i=0;i<strings.length;i++)
        {
            if(vowelCounts[i]==maxVowels)
                mostVowels.add(strings[i]);
        }
        return mostVowels.toArray(new String[0]);
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
        int[] consonCounts = new int[strings.length];
        consonCounts=countConsonants(strings);
        int maxConsons=consonCounts[0];
        for(int i=1;i<consonCounts.length;i++)
        {
            if(consonCounts[i]>maxConsons)
                maxConsons=consonCounts[i];
        }
        List<String> mostConsons = new ArrayList<>();;
        for(int i=0;i<strings.length;i++)
        {
            if(consonCounts[i]==maxConsons)
                mostConsons.add(strings[i]);
        }
        return mostConsons.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants
        Ex5StringAnalyzer ex5StringAnalyzer=new Ex5StringAnalyzer();
        String input="mere;pere;apa;flori;oaie";
        String[] splitInput= ex5StringAnalyzer.parseInput(input);
        String[] longest= ex5StringAnalyzer.findLongest(splitInput);
        String[] shortest= ex5StringAnalyzer.findShortest(splitInput);
        System.out.println("longest:");
        for (String s : longest)
        {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("shortest:");
        for (String s : shortest)
        {
            System.out.print(s );
            System.out.print(" ");
        }
        System.out.println();
        int[] vowelCounts =new int[splitInput.length];
        vowelCounts= ex5StringAnalyzer.countVowels(splitInput);
        int[] consonsCounts =new int[splitInput.length];
        consonsCounts= ex5StringAnalyzer.countConsonants(splitInput);
        System.out.println("nr vocale din siruri:");
        for (int n : vowelCounts)
        {
            System.out.print(n );
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("nr consoane in siruri:");
        for (int n : consonsCounts)
        {
            System.out.print(n );
            System.out.print(" ");
        }
        System.out.println();
        String[] mostVowelsString= ex5StringAnalyzer.findMostVowels(splitInput);
        String[] mostConsonsString= ex5StringAnalyzer.findMostConsonants(splitInput);
        System.out.println("most voles:");
        for (String s : mostVowelsString)
        {
            System.out.print(s );
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("most consons:");
        for (String s : mostConsonsString)
        {
            System.out.print(s );
            System.out.print(" ");
        }
        System.out.println();
    }
}