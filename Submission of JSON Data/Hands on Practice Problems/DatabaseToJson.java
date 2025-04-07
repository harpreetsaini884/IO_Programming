import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.sql.*;
import java.io.File;
import java.util.*;

class Employee {
    public int id;
    public String name;
    public String department;
    public double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class DatabaseToJson {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        try {
            // Replace with your DB connection details
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database", "root", "password");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                employees.add(emp);
            }

            conn.close();

            // Convert to JSON
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File("employee_report.json"), employees);

            System.out.println("JSON report generated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
