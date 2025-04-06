import java.io.File;
import java.io.IOException;
import java.util.*;

public class FilterRecords {
    public static void main(String[] args) {
        String str = "C:\\Users\\manpr\\Desktop\\name.csv";
        List<List<String>> data = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(str))   ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                String[] values = line.replaceAll("\"", "").split(",");
                List<String> lineData = Arrays.asList(values);
                data.add(lineData);
            }

            System.out.println("Students who scored more than 80 marks:\n");

            
            for (int i = 1; i < data.size(); i++) {
                List<String> row = data.get(i);

                if (row.size() >= 2) { 
                    try {
                        int marks = Integer.parseInt(row.get(1).trim());
                        if (marks > 80) {
                            System.out.println(String.join(", ", row));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number in row " + i);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
