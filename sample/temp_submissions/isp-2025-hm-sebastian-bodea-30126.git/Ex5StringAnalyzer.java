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
        // TODO: Implement this method
        // 1. Find the maximum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of longest strings

        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < strings.length; i++) {
            length = strings[i].length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        int nrOfStrings = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == maxLength) {
                nrOfStrings++;
            }
        }

        String[] longest = new String[nrOfStrings];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == maxLength) {
                longest[k++] = strings[i];
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
        // TODO: Implement this method
        // 1. Find the minimum string length in the array
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings

        int length = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            length = strings[i].length();
            if (length < minLength) {
                minLength = length;
            }
        }
        int nrOfStrings = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == minLength) {
                nrOfStrings++;
            }
        }

        String[] shortest = new String[nrOfStrings];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == minLength) {
                shortest[k++] = strings[i];
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
        // TODO: Implement this method
        // 1. Create a map to store the counts
        // 2. For each string, count the vowels (a, e, i, o, u)
        // 3. Store the counts in the map
        // 4. Return the map

        int[] countVowels = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            int count = 0;

            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) >= 0) {
                    count++;
                }
            }

            countVowels[i] = count;
        }

        return countVowels;
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {

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
        // TODO: Implement this method
        // 1. Count vowels in each string
        // 2. Find the maximum vowel count
        // 3. Collect all strings with that count
        // 4. Return the array

        int maxVow = 0;
        for (int i = 0; i < strings.length; i++) {
            int[] countVowels = countVowels(strings);
            if (countVowels[i] > maxVow)
                maxVow = countVowels[i];
        }
        int nrOfStrings = 0;
        for (int i = 0; i < strings.length; i++) {
            if (countVowels(strings)[i] == maxVow)
                nrOfStrings++;
        }
        String[] mostVowels = new String[nrOfStrings];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            if (countVowels(strings)[i] == maxVow) {
                mostVowels[k] = strings[i];
                k++;
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
        // TODO: Implement this method
        // 1. Count consonants in each string
        // 2. Find the maximum consonant count
        // 3. Collect all strings with that count
        // 4. Return the array

        int maxConsonant = 0;
        for (int i = 0; i < strings.length; i++) {
            int[] countConsonant = countConsonants(strings);
            if (countConsonant[i] > maxConsonant)
                maxConsonant = countConsonant[i];
        }
        int nrOfStrings = 0;
        for (int i = 0; i < strings.length; i++) {
            if (countConsonants(strings)[i] == maxConsonant)
                nrOfStrings++;
        }
        String[] mostConsonants = new String[nrOfStrings];
        int k = 0;
        for (int i = 0; i < strings.length; i++) {
            if (countConsonants(strings)[i] == maxConsonant) {
                mostConsonants[k] = strings[i];
                k++;
            }
        }
        return mostConsonants;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants

        Ex5StringAnalyzer analyzer = new Ex5StringAnalyzer();
        String[] string = analyzer.parseInput("apple;banana;cherry");
        String[] longestSting = analyzer.findLongest(string);
        String[] shortestString = analyzer.findShortest(string);

        for (int i = 0; i < longestSting.length; i++) {
            System.out.println("Longest strings are: " + longestSting[i]);
        }

        for (int i = 0; i < shortestString.length; i++) {
            System.out.println("Shortest strings are: " + shortestString[i]);
        }

        for(int i = 0;i < string.length;i++) {
            int [] countVowels = analyzer.countVowels(string);
            int [] countConsonants = analyzer.countConsonants(string);
            System.out.println("Word "+ string[i] + " | Vowels: " + countVowels[i] + " Consonants: " + countConsonants[i]);
        }


        String[] maxVowels = analyzer.findMostVowels(string);
        String[] maxConsonants = analyzer.findMostConsonants(string);
        for (int i = 0; i < maxVowels.length; i++) {
            System.out.println("String with most vowels are: " + maxVowels[i]);
        }
        for (int i = 0; i < maxConsonants.length; i++) {
            System.out.println("String with most consonants are: " + maxConsonants[i]);
        }

    }
}