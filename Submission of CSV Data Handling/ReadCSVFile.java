import java.io.File;
import java.io.IOException;
import java.util.*;
public class ReadCSVFile{
    public static void main(String[] args) {
        String str="C:\\Users\\manpr\\Desktop\\name.csv";

        List<List<String>> data=new ArrayList<>();
        try(Scanner scanner=new Scanner(new File("C:\\Users\\manpr\\Desktop\\name.csv"))){
            while((scanner.hasNextLine())){
                String line=scanner.nextLine();
                String[] values=line.split(",");
                List<String> lineData=Arrays.asList(values);

                data.add(lineData);
            }
            for(int i=0;i<data.size();i++){
                List<String> row=data.get(i);
                System.out.println("Row: "+i+" "+String.join(",", row));
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.*;
// class ReadCSVFile {
//     public static void main(String[] args) {
//         String csvFile = "C:\\Users\\manpr\\Desktop\\name.csv";

//         List<List<String>> data=new ArrayList<>();
//         try(BufferedReader br=new BufferedReader(new FileReader(csvFile))){
//             String line;

//             while((line=br.readLine())!=null){
//                 String[] values=line.split(",");
//                 List<String> lineData=Arrays.asList(values);

//                 data.add(lineData);
//             }
//             System.out.println("Read Data From CSV File");

//             for(int i=0;i<data.size();i++){
//                 List<String> row=data.get(i);
//                 System.out.println("Row "+i+":"+String.join(",", row));
//             }

//         }
//         catch(IOException e){
//             System.out.println(e.getMessage());
//             e.printStackTrace();
//         }

//     }
// }