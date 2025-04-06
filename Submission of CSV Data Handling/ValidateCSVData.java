import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\employee.csv";

        
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w+$");


        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (Scanner scanner = new Scanner(new File(filePath))) {
            
            String header = scanner.hasNextLine() ? scanner.nextLine() : "";
            System.out.println("Validating data...\n");

            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;

                String[] values = line.split(",");
                if (values.length < 5) {
                    System.out.println("Line " + lineNumber + ": Missing fields → " + line);
                    continue;
                }

                String name = values[0].trim();
                String email = values[3].trim();
                String phone = values[4].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Line " + lineNumber + " INVALID:");
                    if (!isEmailValid)
                        System.out.println("  Invalid Email: " + email);
                    if (!isPhoneValid)
                        System.out.println("   Invalid Phone Number: " + phone);
                    System.out.println("  Row: " + line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
