package org.example.csvfiles;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SearchCSVFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\employee.csv";

        Scanner input = new Scanner(System.in);

        System.out.print("String to be Searched: ");
        String searchName = input.nextLine().trim();
        boolean found = false;

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            if (fileScanner.hasNextLine()) {
                // Skip the header line
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // Remove double quotes if present and split by comma
                String[] values = line.replaceAll("\"", "").split(",");

                if (values.length >= 4 && values[0].equalsIgnoreCase(searchName)) {
                    String department = values[2];
                    String salary = values[3];

                    System.out.println("Employee Found!");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee " + searchName + " not Found");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
