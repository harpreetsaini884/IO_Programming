import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String SECRET_KEY = "1234567890123456"; // 16 chars = 128-bit key

    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting: " + e);
        }
    }

    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));

            return new String(decrypted);

        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting: " + e);
        }
    }
}
public class Employee {
    private String name;
    private String department;
    private String salary;
    private String email;

    public Employee(String name, String department, String salary, String email) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getSalary() { return salary; }
    public String getEmail() { return email; }
}
import java.io.*;
import java.util.*;

public class EncryptDecryptCSV {
    static String filePath = "C:\\Users\\manpr\\Desktop\\secure_employees.csv";

    public static void writeEncryptedCSV(List<Employee> employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Name,Department,Salary,Email");

            for (Employee emp : employees) {
                String encryptedSalary = AESUtil.encrypt(emp.getSalary());
                String encryptedEmail = AESUtil.encrypt(emp.getEmail());

                writer.printf("%s,%s,%s,%s%n",
                        emp.getName(),
                        emp.getDepartment(),
                        encryptedSalary,
                        encryptedEmail);
            }

            System.out.println("Encrypted CSV written successfully!");

        } catch (IOException e) {
            System.out.println(" Error writing CSV: " + e.getMessage());
        }
    }

    public static void readAndDecryptCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // skip header

            System.out.println(" Decrypted Records:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String name = parts[0];
                    String department = parts[1];
                    String salary = AESUtil.decrypt(parts[2]);
                    String email = AESUtil.decrypt(parts[3]);

                    System.out.printf("Name: %s, Department: %s, Salary: %s, Email: %s%n",
                            name, department, salary, email);
                }
            }

        } catch (IOException e) {
            System.out.println(" Error reading CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", "70000", "alice@example.com"),
                new Employee("Bob", "HR", "60000", "bob@example.com"),
                new Employee("Charlie", "Finance", "80000", "charlie@example.com")
        );

        writeEncryptedCSV(employees);
        readAndDecryptCSV();
    }
}
