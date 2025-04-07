package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.IPLMatch;

import java.io.File;
import java.util.List;

public class JSONCensor {

    public static void censorJSON(String inputPath, String outputPath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<IPLMatch> matches = mapper.readValue(new File(inputPath), new TypeReference<List<IPLMatch>>() {});

        for (IPLMatch match : matches) {
            match.team1 = censorTeamName(match.team1);
            match.team2 = censorTeamName(match.team2);
            match.winner = censorTeamName(match.winner);
            match.player_of_match = "REDACTED";
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), matches);
        System.out.println("JSON censorship complete. Output written to " + outputPath);
    }

    private static String censorTeamName(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}
