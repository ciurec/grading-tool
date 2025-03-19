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
        String[] result = input.split(";");
        return result;
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
        int maxLength = 0;
        int k = 0;
        for(String s : strings) {
            if(s.length() > maxLength) {
                k = 1;
                maxLength = s.length();
            }
            if(s.length() == maxLength) {
                k++;
            }
        }
        String[] maxLentgsString = new String[k-1];
        int count = 0;
        for(String s: strings) {
            if(s.length() == maxLength) {
                maxLentgsString[count++] = String.copyValueOf(s.toCharArray());
            }
        }
        return maxLentgsString;
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
        int minLength = strings[0].length();
        int k = 0;
        for(String s : strings) {
            if(s.length() < minLength) {
                k = 1;
                minLength = s.length();
            }
            if(s.length() == minLength) {
                k++;
            }
        }
        String[] minLengthsString = new String[k-1];
        int count = 0;
        for(String s: strings) {
            if(s.length() == minLength) {
                minLengthsString[count++] = String.copyValueOf(s.toCharArray());
            }
        }
        return minLengthsString;
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
        int[] vowelsCounts = new int[strings.length];
        // 2. For each string, count the vowels (a, e, i, o, u)
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) != -1) {
                    count++;
                }
            }
            vowelsCounts[i] = count;
        }
        // 3. Store the counts in the map ???????
        // 4. Return the map ???????
        return vowelsCounts;
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
        int[] maxVowels = countVowels(strings);
        int max = -1;
        int count = 0;
        for (int i = 0; i < maxVowels.length; i++) {
            if (maxVowels[i] > max) {
                max = maxVowels[i];
                count = 1;
            } else if (maxVowels[i] == max) {
                count++;
            }
        }
        String[] mostVowelsString = new String[count];
        count = 0;
        for (int i = 0; i < maxVowels.length; i++) {
            if (maxVowels[i] == max) {
                mostVowelsString[count++] = strings[i];
            }
        }
        return mostVowelsString;
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
        int[] maxConsonants = countConsonants(strings);
        int max = -1;
        int count = 0;
        for (int i = 0; i < maxConsonants.length; i++) {
            if (maxConsonants[i] > max) {
                max = maxConsonants[i];
                count = 1;
            } else if (maxConsonants[i] == max) {
                count++;
            }
        }
        String[] mostConsonantsString = new String[count];
        count = 0;
        for (int i = 0; i < maxConsonants.length; i++) {
            if (maxConsonants[i] == max) {
                mostConsonantsString[count++] = strings[i];
            }
        }
        return mostConsonantsString;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants
        Ex5StringAnalyzer ex5StringAnalyzer = new Ex5StringAnalyzer();
        String input = "apple;banana;cherry;lemon;lime;mango;orange;pear;pineapple";
        String[] strings = ex5StringAnalyzer.parseInput(input);

        String[] arraylongest = ex5StringAnalyzer.findLongest(strings);
        System.out.println("Longest length: ");
        for(String s: arraylongest) {
            System.out.println(s.toString() + " ");
        }
        String[] arrayshortest = ex5StringAnalyzer.findShortest(strings);
        System.out.println("Shortest length: ");
        for(String s: arrayshortest) {
            System.out.println(s.toString() + " ");
        }

        System.out.println("Array of Strings: ");
        int[] arrayvowelscount = ex5StringAnalyzer.countVowels(strings);
        int[] arrayconsonantcount = ex5StringAnalyzer.countConsonants(strings);
        int count = 0;
        for(String s: strings) {
            System.out.println(s.toString() + " Nr Vowels: " + arrayvowelscount[count] + " Nr Consonants: " + arrayconsonantcount[count]);
            count++;
        }

        String[] arrayvowels = ex5StringAnalyzer.findMostVowels(strings);
        System.out.println("Most Vowels: ");
        for(String s: arrayvowels) {
            System.out.println(s.toString() + " ");
        }
        String[] arrayconsonants = ex5StringAnalyzer.findMostConsonants(strings);
        System.out.println("Most Consonants: ");
        for(String s: arrayconsonants) {
            System.out.println(s.toString() + " ");
        }

    }
}