import java.io.File;
import java.io.IOException;
import java.util.*;

public class Student {
    private String name;
    private int age;
    private String email;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\manpr\\Desktop\\student.csv";
        List<Student> students = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                if (values.length >= 3) {
                    String name = values[0].trim();
                    int age = Integer.parseInt(values[1].trim());
                    String email = values[2].trim();

                    Student student = new Student(name, age, email);
                    students.add(student);
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV.");
        }

        
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
