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
        String []items = input.split(";");
        return items;
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
        int maxLength = 0,count=0;
        for(String item : strings) {
            if(maxLength < item.length()) {
                maxLength = item.length();
            }
        }
        for(String item : strings) {
            if(item.length() == maxLength) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(String item : strings) {
            if(item.length() == maxLength) {
                result[index++] = item;
            }
        }
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
        // 2. Collect all strings with that length
        // 3. Return the array of shortest strings
        int  minLength = strings[0].length(),count=0;
        for(String item : strings) {
            if(minLength > item.length()) {
                minLength = item.length();
            }
        }
        for(String item : strings) {
            if(item.length() == minLength) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(String item : strings) {
            if(item.length() == minLength) {
                result[index++] = item;
            }
        }
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
        // 2. For each string, count the vowels (a, e, i, o, u)
        // 3. Store the counts in the map
        // 4. Return the map
        int [] vowels = new int [strings.length]; int index=0;
        for(String item : strings) {
            int count = 0;
            for(char c : item.toCharArray()) {
                if(Character.isLetter(c)&& "aeiouAEIOU".indexOf(c)>=0) {
                    count++;
                }
            }
            vowels[index++]=count;
        }
        return vowels;
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
        int []countedVowels=countVowels(strings);
        int maxCount=countedVowels[0];
        for(int i=1;i<countedVowels.length;i++) {
            if(countedVowels[i]>maxCount) {
                maxCount=countedVowels[i];
            }
        }
        int index=0;
        for(String item : strings) {
            int count = 0;
            for(char c : item.toCharArray()) {
                if(Character.isLetter(c)&& "aeiouAEIOU".indexOf(c)>=0) {
                    count++;
                }
            }
           if(count==maxCount) {
               index++;
           }
        }
        String[] result = new String[index];
        index=0;
        for(String item : strings) {
            int count = 0;
            for(char c : item.toCharArray()) {
                if(Character.isLetter(c)&& "aeiouAEIOU".indexOf(c)>=0) {
                    count++;
                }
            }
            if(count==maxCount) {
                result[index++]=item;
            }
        }
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
        // 2. Find the maximum consonant count
        // 3. Collect all strings with that count
        // 4. Return the array
        int []countedConsonants=countConsonants(strings);
        int maxCount=countedConsonants[0];
        for(int i=1;i<countedConsonants.length;i++) {
            if(countedConsonants[i]>maxCount) {
                maxCount=countedConsonants[i];
            }
        }
        int index=0;
        for(String item : strings) {
            int count = 0;
            for(char c : item.toCharArray()) {
                if(Character.isLetter(c)&& "aeiouAEIOU".indexOf(c)==-1) {
                    count++;
                }
            }
            if(count==maxCount) {
                index++;
            }
        }
        String[] result = new String[index];
        index=0;
        for(String item : strings) {
            int count = 0;
            for(char c : item.toCharArray()) {
                if(Character.isLetter(c)&& "aeiouAEIOU".indexOf(c)==-1) {
                    count++;
                }
            }
            if(count==maxCount) {
                result[index++]=item;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of StringAnalyzer
        // 2. Parse the input string into an array of strings
        // 3. Find and print the longest and shortest strings
        // 4. Count and print the number of vowels and consonants in each string
        // 5. Find and print the strings with the most vowels and consonants
        Ex5StringAnalyzer ex5StringAnalyzer = new Ex5StringAnalyzer();
        String input="apple;banana;cherry";
        String[] strings = ex5StringAnalyzer.parseInput(input);
        String[] longestStrings=ex5StringAnalyzer.findLongest(strings);
        System.out.println("Longest strings: ");
        for(int i=0;i<longestStrings.length;i++) {
            System.out.print(longestStrings[i]+" ");
        }
        String[] shortestStrings=ex5StringAnalyzer.findShortest(strings);
        System.out.println();
        System.out.println("Shortest strings: ");
        for(int i=0;i<shortestStrings.length;i++) {
            System.out.print(shortestStrings[i]+" ");
        }
        System.out.println();
        int[] countVowels=ex5StringAnalyzer.countVowels(strings);
        int[] countConsonants=ex5StringAnalyzer.countConsonants(strings);
        System.out.println("Vowels for each string: ");
        for(int i=0;i<countVowels.length;i++) {
            System.out.println("String "+i+": "+countVowels[i]);
        }
        System.out.println("Consonants for each string: ");
        for(int i=0;i<countConsonants.length;i++) {
            System.out.println("String "+i+": "+countConsonants[i]);
        }
        System.out.println();
        String[] mostVowels= ex5StringAnalyzer.findMostVowels(strings);
        String[] mostConsonants= ex5StringAnalyzer.findMostConsonants(strings);
        System.out.println("Most Vowels:");
        for(int i=0;i<mostVowels.length;i++) {
            System.out.print(mostVowels[i]+" ");
        }
        System.out.println();
        System.out.println("Most Consonants:");
        for(int i=0;i<mostConsonants.length;i++) {
            System.out.print(mostConsonants[i]+" ");
        }
    }
}