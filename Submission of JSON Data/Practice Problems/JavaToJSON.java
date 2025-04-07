
import java.util.*;



public class JavaToJSON {
    public static void main(String[] args) {
        Car car=new Car("VWGTLine","GT", 2025, 1500000);

        Gson gson=new Gson();
        String json=gson.toJSON(car);

        System.out.println(json);

    }
}
