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
    public void main(String[] args) {
        // TODO: Implement this method
        // 1. Create a scanner to read user input
        // 2. Prompt the user to enter student records (name,age,grade) on separate lines
        // 3. Read and store the records until the user indicates they're done
        // 4. Allow the user to filter records by minimum grade
        // 5. Allow the user to sort the filtered records
        // 6. Display the filtered and sorted records
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter records");
        String [][]records=new String[100][3];//asumming the max number of records
        int index=0;
        while(true){
            String input = sc.nextLine();
            if(input.equals("done")){ break;}
            records[index++]=parseStudentRecord(input);
        }
        String[] filtering=getFilterAndSortOptions();
        boolean ascending;
        if(filtering[2].equals("ascending")){
            ascending=true;
        }
        else ascending=false;
        String [][]filteredArray=filterByGrade(records,filtering[0]);
        filteredArray=sortRecords(filteredArray,filtering[1],ascending);
        displayRecords(filteredArray);
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
        String []records = record.split(",");
        int count = 0;
        for(String s : records){
            count++;
        }
        if(count != 3)
            throw new IllegalArgumentException("invalid record");

        return new String[]{records[0], records[1], records[2]};
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
        // 2. Count how many records meet the criteria
        // 3. Create a new array of arrays to hold the filtered records
        // 4. Add records with grade >= minGrade to the new array
        // 5. Return the filtered records
        int minGradeInt = Integer.parseInt(minGrade);
        int count = 0;
        for(String []str : records){
            if(Integer.parseInt(str[2]) >= minGradeInt) {
                count++;
            }
        }

        String [][] filteredArray=new String[count][3];
        int index=0;
        for(String [] str : records){
            if(Integer.parseInt(str[2]) >= minGradeInt) {
                filteredArray[index++]=str;
            }
        }
        return filteredArray;
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
        // 2. Determine which index to sort by based on sortBy (0 for name, 1 for age, 2 for grade)
        // 3. Implement a sorting algorithm (e.g., bubble sort) to sort the records
        // 4. If ascending is false, reverse the sorting logic
        // 5. Return the sorted array
        String[][] sortedRecords = records;
        int index=0;
        switch (sortBy)
        {
            case "name": index = 0;break;
            case "age": index = 1;break;
            case "grade": index = 2;break;
        }
        for(int i=0;i<sortedRecords.length-1;i++){
            for(int j=0;j<sortedRecords.length-i-1;j++){
                if(ascending) {
                    if(index>0)
                    {
                        if (Integer.parseInt(sortedRecords[j][index])>Integer.parseInt(sortedRecords[j+1][index]))
                        {
                        String []temp=sortedRecords[j] ;
                        sortedRecords[j]=sortedRecords[j+1];
                        sortedRecords[j+1]=temp;
                        }
                    }
                    else if(sortedRecords[j][index].compareTo(sortedRecords[j+1][index])>0)
                    {
                        String []temp=sortedRecords[j] ;
                        sortedRecords[j]=sortedRecords[j+1];
                        sortedRecords[j+1]=temp;
                    }
                }
                else {
                    if(index>0)
                    {
                        if (Integer.parseInt(sortedRecords[j][index])<Integer.parseInt(sortedRecords[j+1][index]))
                        {
                            String []temp=sortedRecords[j] ;
                            sortedRecords[j]=sortedRecords[j+1];
                            sortedRecords[j+1]=temp;
                        }
                    }
                    else if(sortedRecords[j][index].compareTo(sortedRecords[j+1][index])<0)
                    {
                        String []temp=sortedRecords[j] ;
                        sortedRecords[j]=sortedRecords[j+1];
                        sortedRecords[j+1]=temp;
                    }
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
        if(records.length<=0) throw  new IllegalArgumentException("no records");
        System.out.println("Records:");
        for(String [] record : records){
            System.out.println("Name: "+record[0]+" Age: "+record[1]+" Grade: "+record[2]);
        }

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum grade: ");
        String minGrade = scanner.nextLine();
        System.out.print("Enter sorting criteria : ");
        String sortBy = scanner.nextLine();
        System.out.println("Enter the order of the sorting criteria (ascending or descending): ");
        String asc = scanner.nextLine();
        return new String[]{minGrade,sortBy,asc};
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
            Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}