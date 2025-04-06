import java.io.File;
import java.io.IOException;
import java.util.*;

public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\employee.csv";
        List<String[]> records = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            
            String header = "";
            if (scanner.hasNextLine()) {
                header = scanner.nextLine();
            }


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values.length >= 4) {
                    records.add(values);
                }
            }

  
            records.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3]);
                double salaryB = Double.parseDouble(b[3]);
                return Double.compare(salaryB, salaryA); 
            });

            
            System.out.println(header);

            
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] row = records.get(i);
                System.out.println(String.join(",", row));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary format in data.");
        }
    }
}
