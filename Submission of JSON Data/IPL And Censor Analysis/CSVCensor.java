package util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CSVCensor {

    public static void censorCSV(String inputPath, String outputPath) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(inputPath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {

            List<String[]> rows = reader.readAll();
            String[] header = rows.get(0);
            writer.writeNext(header);

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                row[1] = censorTeamName(row[1]);
                row[2] = censorTeamName(row[2]);
                row[5] = censorTeamName(row[5]);
                row[6] = "REDACTED";
                writer.writeNext(row);
            }

            System.out.println("CSV censorship complete. Output written to " + outputPath);
        }
    }

    private static String censorTeamName(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}
