import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    static String jsonFilePath = "C:\\Users\\manpr\\Desktop\\students.json";
    static String csvFilePath = "C:\\Users\\manpr\\Desktop\\students.csv";

    
    public static void jsonToCsv() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Student> students = mapper.readValue(new File(jsonFilePath), new TypeReference<>() {});

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
    
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});

    
                for (Student s : students) {
                    writer.writeNext(new String[]{
                            String.valueOf(s.getId()),
                            s.getName(),
                            String.valueOf(s.getAge()),
                            String.valueOf(s.getMarks())
                    });
                }
                System.out.println("✅ JSON converted to CSV successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void csvToJson() {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    Student s = new Student(
                            Integer.parseInt(values[0]),
                            values[1],
                            Integer.parseInt(values[2]),
                            Double.parseDouble(values[3])
                    );
                    students.add(s);
                }
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\manpr\\Desktop\\converted_students.json"), students);
            System.out.println("✅ CSV converted to JSON successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        jsonToCsv();  
        csvToJson();  
    }
}
