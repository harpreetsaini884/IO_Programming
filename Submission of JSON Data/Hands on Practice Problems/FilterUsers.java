import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;

public class FilterUsers {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON array into a list of User objects
            List<User> users = mapper.readValue(new File("users.json"), new TypeReference<List<User>>() {});

            System.out.println("Users older than 25:");
            for (User user : users) {
                if (user.getAge() > 25) {
                    System.out.println(user.getName() + " - Age: " + user.getAge());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class User {
    private String name;
    private int age;

    public User() {} // default constructor

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
