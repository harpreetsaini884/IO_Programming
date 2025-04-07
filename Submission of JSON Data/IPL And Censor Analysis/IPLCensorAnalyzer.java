package main;

import util.JSONCensor;
import util.CSVCensor;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInput = "data/input.json";
        String jsonOutput = "output/censored.json";

        String csvInput = "data/input.csv";
        String csvOutput = "output/censored.csv";

        try {
            JSONCensor.censorJSON(jsonInput, jsonOutput);
            CSVCensor.censorCSV(csvInput, csvOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
