package utcluj.aut.lab2.exercises;

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
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        System.out.println("Enter student records (name, age grade) on separate lines.");
        System.out.println("Leave name blank when you are done.");
        System.out.println();
        String[][] citit = new String[30000][3];
        int i=0;
        // 3. Read and store the records until the user indicates they're done
        while (true){
            if(i>30000) {
                System.out.println("Max number reached.");
                break;
            }
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if(name.equals("")) break;
            System.out.print("Age: ");
            String age = scanner.nextLine();
            while(!isInteger(age)){
                System.out.print("Invalid age, try again: ");
                age = scanner.nextLine();
            }
            System.out.print("Grade: ");
            String grade = scanner.nextLine();
            while(!isInteger(grade)){
                System.out.print("Invalid grade, try again: ");
                grade = scanner.nextLine();
            }
            StringBuilder parse = new StringBuilder();
            parse.append(name).append(",").append(age).append(",").append(grade);
            citit[i]=parseStudentRecord(parse.toString());
            //records[i][0] = name;
            //records[i][1] = age;
            //records[i][2] = grade;

            i++;
        }
        String[][] records = new String[i][3];
        System.arraycopy(citit, 0, records, 0, i);
        System.out.println();
        displayRecords(records);

        // 4. Allow the user to filter records by minimum grade
        String[] options = new String[3];
        options=getFilterAndSortOptions();
        System.out.println("Options: MinGrade: " + options[0] + " ,sortBy: " + options[2] + " ,a/d: " + options[1]);

        System.out.println();
        System.out.println("Do you want to filter by minimum grade? Y/N");
        String check = scanner.nextLine();
        if(check.equals("Y")){
            String[][] filtered = new String[records.length][3];
            filtered=filterByGrade(records,options[0]);
            displayRecords(filtered);
        }
        // 5. Allow the user to sort the filtered records
        System.out.println();

            boolean ascending = false;
            if(options[2].equals("ascending")){
                ascending = true;
            }
            String[][] sorted = new String[records.length][3];
            sorted=sortRecords(records,options[2],ascending);

        // 6. Display the filtered and sorted records
        System.out.println();

        for( String[] record : sorted ){
            System.out.println("Name: " + record[0] + ", Age: " + record[1] + ", Grade: " + record[2]);
        }
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
        String[] student = record.split(",");
        // 2. Validate that there are exactly 3 parts
        if (student.length != 3) {
            throw new IllegalArgumentException("Invalid student record: " + record);
        }
        // 3. Return a string array with [name, age, grade]
        return student;
        // 4. Return null or handle invalid formats appropriately

    }

    /**
     * Filters student records by a minimum grade threshold.
     *
     * @param records array of student records, each record is [name, age, grade]
     * @param minGrade the minimum grade threshold as a string
     * @return array of filtered student records
     */
    public static String[][] filterByGrade(String[][] records, String minGrade) {
        // TODO: Implement this method
        // 1. Parse the minimum grade threshold to an integer
        int nota = Integer.parseInt(minGrade);
        // 2. Count how many records meet the criteria
        int count = 0;
        for (String[] record : records) {
            if (nota <= Integer.parseInt(record[2])) {
                count++;
            }
        }

        // 3. Create a new array of arrays to hold the filtered records
        String[][] valide = new String[count][];
        // 4. Add records with grade >= minGrade to the new array
        count =0;
        for (String[] record : records) {
            if (nota <= Integer.parseInt(record[2])) {
                valide[count] = record;
                count++;
            }
        }
        // 5. Return the filtered records
        return valide;
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
        // TODO: Implement this method
        // 1. Create a copy of the records array to avoid modifying the original
        String[][] copy = new String[records.length][];
        for (int index =0 ; index < records.length ; index++) {
            copy[index] = records[index].clone();
        }
        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        int i = 0;
        if (sortBy.equals("name")) i=0;
        if (sortBy.equals("age")) i=1;
        if (sortBy.equals("grade")) i=2;
        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        int j,k;
        String[] aux = new String[3];
        if (ascending) {
            for (j = 0; j < copy.length-1; j++) {
                for (k = j + 1; k < copy.length; k++) {
                    if( i==1 || i==2) {
                        int v1 = Integer.parseInt(copy[j][i]);
                        int v2 = Integer.parseInt(copy[k][i]);
                        if(v1>v2) {
                            aux = copy[j];
                            copy[j] = copy[k];
                            copy[k] = aux;
                        }
                    }
                    else if (copy[j][i].compareTo(copy[k][i]) > 0) {
                        aux = copy[j];
                        copy[j] = copy[k];
                        copy[k] = aux;
                    }
                }
            }
        }
        else {
            for (j = 0; j < copy.length-1; j++) {
                for (k = j + 1; k < copy.length; k++) {
                    if( i==1 || i==2) {
                        int v1 = Integer.parseInt(copy[j][i]);
                        int v2 = Integer.parseInt(copy[k][i]);
                        if(v1<v2) {
                            aux = copy[j];
                            copy[j] = copy[k];
                            copy[k] = aux;
                        }
                    }
                    else if (copy[j][i].compareTo(copy[k][i]) < 0) {
                        aux = copy[j];
                        copy[j] = copy[k];
                        copy[k] = aux;
                    }
                }
            }
        }
        // 4. If ascending is false, reverse the sorting logic
        // 5. Return the sorted array
        return copy;
    }

    /**
     * Displays student records in a formatted way.
     *
     * @param records array of student records to display
     */
    public static void displayRecords(String[][] records) {
        // TODO: Implement this method
        // 1. Check if there are any records to display
        if (records.length == 0) { throw new IllegalArgumentException("No records found"); }
        // 2. Display a header for the output
        System.out.println("Records:");
        System.out.println();
        // 3. Iterate through each record and format it for display
        for (String[] record : records) {
            System.out.println("Name: " + record[0] + ", Age: " + record[1] + ", Grade: " + record[2]);
        }
        // 4. Display each record on a separate line
    }

    /**
     * Prompts for and reads user input for filtering and sorting options.
     *
     * @return a string array with [minGrade, sortBy, ascending]
     */
    public static String[] getFilterAndSortOptions() {
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // 2. Prompt the user for minimum grade threshold
        System.out.println("Minimum grade: ");
        String minGrade = scanner.nextLine();
        // 3. Prompt the user for sorting criteria (name, age, or grade)
        System.out.println("Sort by name, age or grade? ");
        String sortBy = scanner.nextLine();
        // 4. Prompt the user for sorting order (ascending or descending)
        System.out.println("Ascending or descending? ");
        String ascending = scanner.nextLine();
        // 5. Return the options as a string array
        String[] options = new String[3];
        options[0] = minGrade;
        options[1] = ascending;
        options[2] = sortBy;
        return options;
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
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
        // 2. Return true if successful, false if it causes an exception
    }
}