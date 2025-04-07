import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class EmailValidator {
    public static void main(String[] args) {
        String schemaStr = """
        {
          "$schema": "http://json-schema.org/draft-07/schema#",
          "type": "object",
          "properties": {
            "name": { "type": "string" },
            "email": { "type": "string", "format": "email" }
          },
          "required": ["name", "email"]
        }
        """;

        String jsonData = """
        {
          "name": "Charlie",
          "email": "charlie-at-example.com"
        }
        """;

        try {
            JSONObject rawSchema = new JSONObject(schemaStr);
            Schema schema = SchemaLoader.load(rawSchema);

            JSONObject jsonObject = new JSONObject(jsonData);
            schema.validate(jsonObject);  // Throws ValidationException if invalid

            System.out.println("JSON is valid!");

        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
