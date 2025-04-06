public class Person {
    private String name;
    private int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;
import java.util.stream.Collectors;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        String json = """
            [
              {"name": "Alice", "age": 22},
              {"name": "Bob", "age": 28},
              {"name": "Charlie", "age": 30},
              {"name": "David", "age": 24}
            ]
        """;

        ObjectMapper mapper = new ObjectMapper();

        
        List<Person> people = mapper.readValue(json, new TypeReference<List<Person>>() {});

        
        List<Person> filtered = people.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());

        
        for (Person p : filtered) {
            System.out.println(p.getName() + " is " + p.getAge());
        }
    }
}
