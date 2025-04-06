import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVFromDatabase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String csvFilePath = "C:\\Users\\manpr\\Desktop\\employee_report.csv";

        String sql = "SELECT emp_id, name, department, salary FROM employees";

        try (
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(csvFilePath)
        ) {
            
            writer.append("Employee ID,Name,Department,Salary\n");

            
            while (resultSet.next()) {
                writer.append(resultSet.getString("emp_id")).append(",");
                writer.append(resultSet.getString("name")).append(",");
                writer.append(resultSet.getString("department")).append(",");
                writer.append(resultSet.getString("salary")).append("\n");
            }

            System.out.println("CSV file created successfully at: " + csvFilePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
