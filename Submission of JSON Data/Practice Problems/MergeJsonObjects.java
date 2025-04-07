import com.google.gson.JsonObject;

public class MergeJsonObjects {
    public static void main(String[] args) {
        
        JsonObject json1 = new JsonObject();
        json1.addProperty("name", "Alice");
        json1.addProperty("age", 25);

        
        JsonObject json2 = new JsonObject();
        json2.addProperty("email", "alice@example.com");
        json2.addProperty("city", "New York");

        
        for (String key : json2.keySet()) {
            json1.add(key, json2.get(key));
        }

        
        System.out.println("Merged JSON: " + json1.toString());
    }
}
