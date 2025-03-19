package utcluj.aut.lab2.exercises;

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
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        // 3. Read and store the records until the user indicates they're done
        // 4. Allow the user to filter records by minimum grade
        // 5. Allow the user to sort the filtered records
        // 6. Display the filtered and sorted records
        Scanner sc = new Scanner(System.in);
        String[][] studentRecords = new String[100][3];
        int recordCount = 0;
        System.out.println("Enter student records (name,age,grade). Type 'done' to finish:");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parsedRecord = parseStudentRecord(input);
            if (parsedRecord != null) {
                studentRecords[recordCount++] = parsedRecord;
            } else {
                System.out.println("Invalid input. Please enter in format: name,age,grade");
            }
        }
        String[][] records = new String[recordCount][3];
        System.arraycopy(studentRecords, 0, records, 0, recordCount);
        String[] options = getFilterAndSortOptions();
        if (options == null) {
            System.out.println("Invalid options. Exiting.");
            sc.close();
            return;
        }
        String[][] filteredRecords = filterByGrade(records, options[0]);
        boolean ascending = options[2].equalsIgnoreCase("ascending");
        String[][] sortedRecords = sortRecords(filteredRecords, options[1], ascending);
        displayRecords(sortedRecords);
        sc.close();
    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        // TODO: Implement this method
        // 1. Split the record by commas
        // 2. Validate that there are exactly 3 parts
        // 3. Return a string array with [name, age, grade]
        // 4. Return null or handle invalid formats appropriately


        if (record == null || record.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid record");
        }

        String[] parts = record.split(",");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid record");
        }

        String name = parts[0].trim();
        String age = parts[1].trim();
        String grade = parts[2].trim();

        if (name.isEmpty() || age.isEmpty() || grade.isEmpty()) {
            throw new IllegalArgumentException("Invalid record");
        }
        return new String[]{name, age, grade};
    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records  array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        // TODO: Implement this method
        // 1. Parse the minimum grade threshold to an integer
        // 2. Count how many records meet the criteria
        // 3. Create a new array of arrays to hold the filtered records
        // 4. Add records with grade >= minGrade to the new array
        // 5. Return the filtered records

        int minGradeValue;
        try {
            minGradeValue = Integer.parseInt(minGrade);
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade input. Please enter a valid integer.");
            return new String[0][0];
        }

        int count = 0;
        for (String[] record : records) {
            if (record.length == 3) {
                try {
                    int grade = Integer.parseInt(record[2]);
                    if (grade >= minGradeValue) {
                        count++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid grade format for record: " + String.join(", ", record));
                }
            }
        }

        String[][] filteredRecords = new String[count][3];

        int index = 0;
        for (String[] record : records) {
            if (record.length == 3) {
                try {
                    int grade = Integer.parseInt(record[2]);
                    if (grade >= minGradeValue) {
                        filteredRecords[index++] = record;
                    }
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        return filteredRecords;
    }

    /**
     * Sorts student records by the given criteria.
     *
     * @param records   array of student records, each record is [name, age, grade]
     * @param sortBy    the sorting criteria ("name", "age", or "grade")
     * @param ascending true for ascending order, false for descending
     * @return a new array with sorted student records
     */
    public static String[][] sortRecords(String[][] records, String sortBy, boolean ascending) {
        // TODO: Implement this method
        // 1. Create a copy of the records array to avoid modifying the original
        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        // 4. If ascending is false, reverse the sorting logic
        // 5. Return the sorted array

        String[][] sortedRecords = new String[records.length][3];
        for (int i = 0; i < records.length; i++) {
            sortedRecords[i] = records[i].clone();
        }

        int sortIndex;
        switch (sortBy.toLowerCase()) {
            case "name":
                sortIndex = 0;
                break;
            case "age":
                sortIndex = 1;
                break;
            case "grade":
                sortIndex = 2;
                break;
            default:
                System.out.println("Invalid sort criteria. Valid options are: name, age, grade.");
                return sortedRecords;
        }

        for (int i = 0; i < sortedRecords.length - 1; i++) {
            for (int j = 0; j < sortedRecords.length - 1 - i; j++) {
                boolean swap = false;
                try {
                    int comparisonResult = 0;
                    if (sortIndex == 0) {
                        comparisonResult = sortedRecords[j][sortIndex].compareTo(sortedRecords[j + 1][sortIndex]);
                    } else {
                        comparisonResult = Integer.parseInt(sortedRecords[j][sortIndex]) -
                                Integer.parseInt(sortedRecords[j + 1][sortIndex]);
                    }

                    if ((ascending && comparisonResult > 0) || (!ascending && comparisonResult < 0)) {
                        swap = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record: " + String.join(", ", sortedRecords[j]));
                }

                if (swap) {
                    String[] temp = sortedRecords[j];
                    sortedRecords[j] = sortedRecords[j + 1];
                    sortedRecords[j + 1] = temp;
                }
            }
        }

        return sortedRecords;
    }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // TODO: Implement this method
        // 1. Check if there are any records to display
        // 2. Display a header for the output
        // 3. Iterate through each record and format it for display
        // 4. Display each record on a separate line

        if (records == null || records.length == 0) {
            System.out.println("No records found");
            return;
        }
        System.out.println("Displaying Records:");
        System.out.println("--------------------");
        for (String[] record : records) {
            if (record != null) {
                System.out.println(String.join(",", record));
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        // 2. Prompt the user for minimum grade threshold
        // 3. Prompt the user for sorting criteria (name, age, or grade)
        // 4. Prompt the user for sorting order (ascending or descending)
        // 5. Return the options as a string array

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter minimum grade: ");
        String minGrade = scan.next();
        System.out.println("Enter sorting criteria (name, age, or grade): ");
        String sortBy = scan.next();
        System.out.println("Ascending enter or descending order (ascending or descending): ");
        String order = scan.next();
        scan.close();
        if (minGrade != null && sortBy != null && order != null) {
            return new String[]{minGrade, sortBy, order};
        }
        return null;
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        // TODO: Implement this method
        // 1. Try to parse the string as an integer
        // 2. Return true if successful, false if it causes an exception
        try {
            return Integer.parseInt(str) >= -1;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}