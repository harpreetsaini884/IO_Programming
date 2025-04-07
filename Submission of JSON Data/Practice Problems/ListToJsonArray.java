public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters (Required for Jackson)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));

        ObjectMapper mapper = new ObjectMapper();

        // Convert to JSON array
        String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        System.out.println(jsonArray);
    }
}
