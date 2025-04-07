import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"email\": \"john@example.com\" }";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(jsonString);
            System.out.println("Valid JSON structure!");
            System.out.println("Parsed JSON: " + node.toPrettyString());
        } catch (JsonProcessingException e) {
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}
