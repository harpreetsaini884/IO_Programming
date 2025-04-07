import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 25));
        students.add(new Student("Charlie", 24));

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            System.out.println("JSON Array:\n" + jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Student {
    private String name;
    private int age;

    // Constructors
    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
