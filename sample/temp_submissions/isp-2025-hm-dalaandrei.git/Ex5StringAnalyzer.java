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
        String[] split = input.split(";");
        // 2. Return the resulting array of strings
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
        // TODO: Implement this method
        // 1. Find the maximum string length in the array
        long max = strings[0].length();
        int i=0;
        for (String string : strings) {
            if (string.length() > max) {
                max = string.length();
                i=1;
            }
            else if (string.length() == max) {
                i++;
            }
        }
        // 2. Collect all strings with that length
        String[] result = new String[i];
        i=0;
        for (String string : strings) {
            if (string.length() == max) {
                result[i++] = String.copyValueOf(string.toCharArray());
            }
        }
        // 3. Return the array of longest strings
        return result;
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
        long min = strings[0].length();
        int i=0;
        for (String string : strings) {
            if (string.length() < min) {
                min = string.length();
                i=1;
            }
            else if (string.length() == min) {
                i++;
            }
        }
        // 2. Collect all strings with that length
        String[] result = new String[i];
        i=0;
        for (String string : strings) {
            if (string.length() == min) {
                result[i++] = String.copyValueOf(string.toCharArray());
            }
        }
        // 3. Return the array of shortest strings
        return result;
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
        int[] countVowels = new int[strings.length];
        // 2. For each string, count the vowels (a, e, i, o, u), in test se verifica si pentru Y ca vocala
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouyAEIOUY".indexOf(c) != -1) {
                    count++;
                }
            }
            // 3. Store the counts in the map
            countVowels[i] = count;
        }
        // 4. Return the map
        return countVowels;
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
                if (Character.isLetter(c) && "aeiouyAEIOUY".indexOf(c) == -1) {
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
        int max = 0;
        int j=0;
        int[] count = countVowels(strings);
        // 2. Find the maximum vowel count
        for (int i=0;i<count.length;i++) {
            if (count[i] > max) {
                max = count[i];
                j = 1;
            } else if (count[i] == max) {
                j++;
            }
        }
        // 3. Collect all strings with that count
        String[] result = new String[j];
        j=0;
        for (int i=0;i<count.length;i++) {
            if(count[i] == max) result[j++] = String.copyValueOf(strings[i].toCharArray());
        }
        // 4. Return the array
        return result;
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
        int max = 0;
        int j=0;
        int[] count = countConsonants(strings);
        // 2. Find the maximum consonant count
        for (int i=0;i<count.length;i++) {
            if (count[i] > max) {
                max = count[i];
                j = 1;
            } else if (count[i] == max) {
                j++;
            }
        }
        // 3. Collect all strings with that count
        String[] result = new String[j];
        j=0;
        for (int i=0;i<count.length;i++) {
            if(count[i] == max) result[j++] = String.copyValueOf(strings[i].toCharArray());
        }
        // 4. Return the array
        return result;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        Ex5StringAnalyzer ex5 = new Ex5StringAnalyzer();
        // 2. Parse the input string into an array of strings
        String input = "apple;banana;cherry;lemon;lime;mango;orange;pear;pineapple";
        String[] strings = ex5.parseInput(input);
        // 3. Find and print the longest and shortest strings
        String[] longest = ex5.findLongest(strings);
        String[] shortest = ex5.findShortest(strings);
        System.out.println("Found longest: ");
        for (int i = 0; i < longest.length; i++) {
            System.out.println(longest[i].toString());
        }
        System.out.println();
        System.out.println("Found shortest: ");
        for (int i = 0; i < shortest.length; i++) {
            System.out.println(shortest[i].toString());
        }
        // 4. Count and print the number of vowels and consonants in each string
        int[] vowels = ex5.countVowels(strings);
        int[] consonants = ex5.countConsonants(strings);
        int i=0;
        for (String string : strings) {
            System.out.println("For string: " + string);
            System.out.println("Vowels: " + vowels[i] + "; Consonants: " + consonants[i]);
            i++;
        }
        // 5. Find and print the strings with the most vowels and consonants
        System.out.println();
        String[] mostVowels = ex5.findMostVowels(strings);
        String[] mostConsonants = ex5.findMostConsonants(strings);
        System.out.println("Found most vowels: ");
        for (i=0;i<mostVowels.length;i++) {
            System.out.println(mostVowels[i].toString());
        }
        System.out.println("Found most consonants: ");
        for (i=0;i<mostConsonants.length;i++) {
            System.out.println(mostConsonants[i].toString());
        }
    }
}