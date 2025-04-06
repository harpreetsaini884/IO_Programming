package org.example.csvfiles;

import java.io.*;
import java.util.*;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\manpr\\Desktop\\employee.csv";
        String outputFile = "C:\\Users\\manpr\\Desktop\\updated_employee.csv";

        List<String[]> updatedData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            // Read header
            if (scanner.hasNextLine()) {
                String headerLine = scanner.nextLine();
                updatedData.add(headerLine.split(","));
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.replaceAll("\"", "").split(",");

                if (values.length >= 4) {
                    String department = values[2];
                    double salary = Double.parseDouble(values[3]);

                   
                    if (department.equalsIgnoreCase("IT")) {
                        salary = salary * 1.10;
                        values[3] = String.format("%.2f", salary);
                    }
                    updatedData.add(values);
                }
            }

            
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                for (String[] row : updatedData) {
                    writer.println(String.join(",", row));
                }
            }

            System.out.println("CSV file updated successfully. Saved to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary format: " + e.getMessage());
        }
    }
}
