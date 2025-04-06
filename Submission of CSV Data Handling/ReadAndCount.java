import java.io.File;
import java.io.IOException;
import java.util.*;
public class ReadAndCount {
    public static void main(String[] args) {
        String str="C:\\Users\\manpr\\Desktop\\name.csv";
        int rowCount=0;
        int columnCount=0;
        List<List<String>> data=new ArrayList<>();

        try(Scanner scanner=new Scanner(new File("C:\\Users\\manpr\\Desktop\\name.csv"))){
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] values=line.split(",");
                List<String> lineData=Arrays.asList(values);

                data.add(lineData);
                rowCount++;

                if(rowCount==1){
                    columnCount=values.length;
                }
            }
            for(int i=0;i<data.size();i++){
                List<String> row=data.get(i);
                System.out.println("Row: "+i+" "+String.join(",", row));
            }
            System.out.println("Total Rows: "+rowCount);
            System.out.println("Total Columns: "+columnCount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }   
}
