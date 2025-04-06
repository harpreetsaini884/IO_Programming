import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtractFieldsFromJSON {
    public static void main(String[] args) {
        try (JsonReader reader = new JsonReader(new FileReader("data.json"))) {
            JsonElement rootElement = JsonParser.parseReader(reader);

            if (rootElement.isJsonArray()) {
                JsonArray jsonArray = rootElement.getAsJsonArray();
                for (JsonElement element : jsonArray) {
                    JsonObject obj = element.getAsJsonObject();

                    String name = obj.get("name").getAsString();
                    String email = obj.get("email").getAsString();

                    System.out.println("Name: " + name + ", Email: " + email);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
