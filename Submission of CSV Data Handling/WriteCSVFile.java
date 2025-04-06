import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class WriteCSVFile {
    public static void main(String[] args) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\manpr\\Desktop\\name.csv"));
            
            String[] header = {"Name", "Age", "Email"};
            writer.writeNext(header);

            String[] student1 = {"Harry", "23", "harry@gmail.com"};
            writer.writeNext(student1);

            String[] student2 = {"Raman", "25", "r@gmail.com"};
            writer.writeNext(student2);

            String[] student3 = {"Dalla", "22", "dalla@gmail.com"};
            writer.writeNext(student3);

            writer.close();

            System.out.println("CSV file created Successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
