import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class parseJsonFile {
    private static Map<String, List<List<List<Double>>>> states;
    String jsonFilePath = "CoordinatesOfStates.json";

    public parseJsonFile() {
    }

    private static String readJsonFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public Map<String, List<List<List<Double>>>> writeJsonFile()
    {
        String jsonContent = readJsonFile(jsonFilePath);
        Gson gson = new Gson();
        states = gson.fromJson(jsonContent, Map.class);
        return states;
    }
}

