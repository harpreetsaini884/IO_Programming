    import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode json1 = mapper.readTree(new File("user1.json"));
            JsonNode json2 = mapper.readTree(new File("user2.json"));

           
            JsonNode merged = json1.deepCopy();
            ((com.fasterxml.jackson.databind.node.ObjectNode) merged).setAll((com.fasterxml.jackson.databind.node.ObjectNode) json2);

           
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
