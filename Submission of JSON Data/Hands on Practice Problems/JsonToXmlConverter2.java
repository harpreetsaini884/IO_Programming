import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter2 {
    public static void main(String[] args) {
        String jsonString = """
            {
              "student": {
                "name": "Alice",
                "age": 22,
                "email": "alice@example.com"
              }
            }
            """;

        // Convert JSON to XML
        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = XML.toString(jsonObject);

        System.out.println("Converted XML:\n" + xml);
    }
}
