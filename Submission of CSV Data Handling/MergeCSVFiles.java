import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\manpr\\Desktop\\students1.csv";
        String file2 = "C:\\Users\\manpr\\Desktop\\students2.csv";
        String outputFile = "C:\\Users\\manpr\\Desktop\\merged_students.csv";

        Map<String, String[]> map1 = new HashMap<>();
        Map<String, String[]> map2 = new HashMap<>();

       
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    map1.put(values[0], new String[]{values[1], values[2]}); // ID -> [Name, Age]
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    map2.put(values[0], new String[]{values[1], values[2]}); // ID -> [Marks, Grade]
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
        
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (String id : map1.keySet()) {
                String[] details1 = map1.get(id);
                String[] details2 = map2.get(id);
                if (details2 != null) {
                    String mergedLine = String.join(",", id, details1[0], details1[1], details2[0], details2[1]);
                    bw.write(mergedLine);
                    bw.newLine();
                }
            }

            System.out.println("CSV files merged successfully into: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}
