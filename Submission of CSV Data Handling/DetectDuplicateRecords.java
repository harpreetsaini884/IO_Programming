import java.io.*;
import java.util.*;

public class DetectDuplicateRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\students.csv"; 

        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }

                String[] values = line.split(",");
                if (values.length > 0) {
                    String id = values[0].trim(); 

                    if (!seenIds.add(id)) {
                        duplicates.add(line);
                    }
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
