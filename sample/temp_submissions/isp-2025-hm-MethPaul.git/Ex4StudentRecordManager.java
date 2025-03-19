package utcluj.aut.lab2.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Application that manages student records using only Strings and arrays.
 * The program allows users to input student records, filter them by grade,
 * and sort them by different criteria.
 * Students should implement all methods to complete the exercise.
 */
public class Ex4StudentRecordManager {

    /**
     * Main method that runs the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> studentRecords = new ArrayList<>();

        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        System.out.println("Enter student records (format: name,age,grade). Type 'done' to finish:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            // 3. Read and store the records until the user indicates they're done
            String[] record = parseStudentRecord(input);
            if (record != null) {
                studentRecords.add(record);
            } else {
                System.out.println("Invalid format! Please use 'name,age,grade'.");
            }
        }

        // Convert list to array
        String[][] recordsArray = studentRecords.toArray(new String[0][]);

        // 4. Allow the user to filter records by minimum grade
        String[] options = getFilterAndSortOptions();
        if (options == null) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        String minGrade = options[0];
        String sortBy = options[1];
        boolean ascending = Boolean.parseBoolean(options[2]);

        String[][] filteredRecords = filterByGrade(recordsArray, minGrade);

        // 5. Allow the user to sort the filtered records
        String[][] sortedRecords = sortRecords(filteredRecords, sortBy, ascending);

        // 6. Display the filtered and sorted records
        displayRecords(sortedRecords);
    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        // 1. Split the record by commas
        String[] parts = record.split(",");

        // 2. Validate that there are exactly 3 parts
        if (parts.length != 3) {
            return null;
        }

        // 3. Return a string array with [name, age, grade]
        String name = parts[0].trim();
        String age = parts[1].trim();
        String grade = parts[2].trim();

        if (name.isEmpty() || !isInteger(age) || !isInteger(grade)) {
            return null;
        }

        return new String[]{name, age, grade};
    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        // 1. Parse the minimum grade threshold to an integer
        int minGradeValue = Integer.parseInt(minGrade);
        ArrayList<String[]> filteredList = new ArrayList<>();

        // 2. Count how many records meet the criteria
        for (String[] record : records) {
            int studentGrade = Integer.parseInt(record[2]);

            // 4. Add records with grade >= minGrade to the new array
            if (studentGrade >= minGradeValue) {
                filteredList.add(record);
            }
        }

        // 5. Return the filtered records
        return filteredList.toArray(new String[0][]);
    }

    /**
     * Sorts student records by the given criteria.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param sortBy the sorting criteria ("name", "age", or "grade")
     * @param ascending true for ascending order, false for descending
     * @return a new array with sorted student records
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        // 1. Create a copy of the records array to avoid modifying the original
        String[][] sortedRecords = Arrays.copyOf(records, records.length);

        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        int sortIndex;
        switch (sortBy) {
            case "age":
                sortIndex = 1;
                break;
            case "grade":
                sortIndex = 2;
                break;
            case "name":
            default:
                sortIndex = 0;
                break;
        }

        // 3. Implement a sorting algorithm (using Java built-in sort with comparator)
        Arrays.sort(sortedRecords, Comparator.comparing(record -> record[sortIndex]));

        // 4. If ascending is false, reverse the sorting logic
        if (!ascending) {
            for (int i = 0; i < sortedRecords.length / 2; i++) {
                String[] temp = sortedRecords[i];
                sortedRecords[i] = sortedRecords[sortedRecords.length - 1 - i];
                sortedRecords[sortedRecords.length - 1 - i] = temp;
            }
        }

        // 5. Return the sorted array
        return sortedRecords;
    }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // 1. Check if there are any records to display
        if (records.length == 0) {
            System.out.println("No records to display.");
            return;
        }

        // 2. Display a header for the output
        System.out.println("Student Records:");
        System.out.println("-----------------------------");

        // 3. Iterate through each record and format it for display
        for (String[] record : records) {
            System.out.printf("Name: %s, Age: %s, Grade: %s%n", record[0], record[1], record[2]);
        }

        // 4. Display each record on a separate line
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        Scanner scanner = new Scanner(System.in);

        // 2. Prompt the user for minimum grade threshold
        System.out.print("Enter the minimum grade threshold: ");
        String minGrade = scanner.nextLine();

        if (!isInteger(minGrade)) {
            return null;
        }

        // 3. Prompt the user for sorting criteria (name, age, or grade)
        System.out.print("Enter sorting criteria (name, age, grade): ");
        String sortBy = scanner.nextLine().toLowerCase();

        if (!sortBy.equals("name") && !sortBy.equals("age") && !sortBy.equals("grade")) {
            return null;
        }

        // 4. Prompt the user for sorting order (ascending or descending)
        System.out.print("Sort in ascending order? (true/false): ");
        String order = scanner.nextLine();
        boolean ascending = Boolean.parseBoolean(order);

        // 5. Return the options as a string array
        return new String[]{minGrade, sortBy, String.valueOf(ascending)};
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}