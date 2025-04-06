import java.io.*;

public class ReadLargeCSVFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\large_file.csv";

        int chunkSize = 100;
        int totalCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;

            
            String header = reader.readLine();
            if (header != null) {
                System.out.println("Header: " + header);
            }

            
            while ((line = reader.readLine()) != null) {
                lineCount++;
                totalCount++;

                
                if (lineCount == chunkSize) {
                    System.out.println("Processed " + totalCount + " records...");
                    lineCount = 0; 
                }
            }

            
            System.out.println("Total records processed: " + totalCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
