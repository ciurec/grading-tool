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
        // 1. Create a scanner to read user input
        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        // 3. Read and store the records until the user indicates they're done
        // 4. Allow the user to filter records by minimum grade
        // 5. Allow the user to sort the filtered records
        // 6. Display the filtered and sorted records
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student records: ");

        String [][] records = new String[100][3];
        int k = 0;
        while(true) {
            String record = scanner.nextLine();
            if(record.equals("done"))
                break;
            String []parsed = parseStudentRecord(record);
            if(parsed != null){
                records[k++] = parsed;
            }
        }

        String [] options = getFilterAndSortOptions();

        records = filterByGrade(records, options[0]);
        records = sortRecords(records, options[1], options[2].equals("ascending"));

        displayRecords(records);

    }

    /**
     * Parses a student record from a string in the format "name,age,grade".
     *
     * @param record the record string to parse
     * @return a string array with [name, age, grade] or null if invalid format
     */
    public static String[] parseStudentRecord(String record) {
        // 1. Split the record by commas
        // 2. Validate that there are exactly 3 parts
        // 3. Return a string array with [name, age, grade]
        // 4. Return null or handle invalid formats appropriately

        String [] parsedRecord = record.split(",");

        if(parsedRecord.length != 3){
            throw new IllegalArgumentException("null");
        }

        return parsedRecord;

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
        // 2. Count how many records meet the criteria
        // 3. Create a new array of arrays to hold the filtered records
        // 4. Add records with grade >= minGrade to the new array
        // 5. Return the filtered records

        int minimumGrade = Integer.parseInt(minGrade);

        int count = 0;
        for(String[] record : records) {
            if(record != null && record[2] != null && Integer.parseInt(record[2]) >= minimumGrade ) {
                count++;
            }
        }

        String [][] array = new String [count][3];
        int index = 0;
        for(String[] record : records){
            if(record != null && record[2] != null && Integer.parseInt(record[2]) >= minimumGrade ) {
                array[index++] = record;
            }
        }

        return array;
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
        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        // 4. If ascending is false, reverse the sorting logic
        // 5. Return the sorted array

        // In clasa de teste pentru sortare se foloseste name/grade in loc de 0/1 pentru variabila
        // sortBy, asa ca nu am putut urma cerinta cum trebuie, adica sa verific daca sortBy este
        // 0, 1 sau 2

        String [][] backupRecords = records;
        String [] temp = new String [3];

        if(ascending == true) {

            if(sortBy.equals("name")){
                for(int i = 0; i < backupRecords.length - 1; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(backupRecords[j][0].compareTo(backupRecords[i][0]) < 0) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }

            if(sortBy.equals("age")){
                for(int i = 0; i < backupRecords.length - 1; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(Integer.parseInt(backupRecords[j][1]) < Integer.parseInt(backupRecords[i][1])) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }

            if(sortBy.equals("grade")){
                for(int i = 0; i < backupRecords.length - 1 ; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(Integer.parseInt(backupRecords[j][2]) < Integer.parseInt(backupRecords[i][2])) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }
        }

        if(ascending == false) {

            if(sortBy.equals("name")){
                for(int i = 0; i < backupRecords.length - 1; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(backupRecords[j][0].compareTo(backupRecords[i][0]) > 0) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }

            if(sortBy.equals("age")){
                for(int i = 0; i < backupRecords.length - 1; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(Integer.parseInt(backupRecords[j][1]) > Integer.parseInt(backupRecords[i][1])) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }

            if(sortBy.equals("grade")){
                for(int i = 0; i < backupRecords.length - 1; i++) {
                    for(int j = i + 1; j < backupRecords.length; j++) {
                        if(Integer.parseInt(backupRecords[j][2]) > Integer.parseInt(backupRecords[i][2])) {

                            temp = backupRecords[i];
                            backupRecords[i] = backupRecords[j];
                            backupRecords[j] = temp;

                        }
                    }
                }
            }
        }


        return backupRecords;
    }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // 1. Check if there are any records to display
        // 2. Display a header for the output
        // 3. Iterate through each record and format it for display
        // 4. Display each record on a separate line

        if(records.length == 0) {
            return;
        }

        System.out.println("Students: ");

        for(String [] record : records) {
            System.out.println("Name: " + record[0] + ", Grade: " + record[1] + ", Age: " + record[2]);
        }
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        // 1. Create a scanner to read user input
        // 2. Prompt the user for minimum grade threshold
        // 3. Prompt the user for sorting criteria (name, age, or grade)
        // 4. Prompt the user for sorting order (ascending or descending)
        // 5. Return the options as a string array

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minimum threshold: ");
        String minThreshold = scanner.next();

        System.out.println("Enter sorting citeria (name, age or grade): ");
        String sortBy = scanner.next();

        System.out.println("Enter sorting order (ascending or descending): ");
        String order = scanner.next();

        return new String [] {minThreshold, sortBy, order};
    }

    /**
     * Checks if a string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */
    public static boolean isInteger(String str) {
        // 1. Try to parse the string as an integer
        // 2. Return true if successful, false if it causes an exception

        try {
            int numb = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}