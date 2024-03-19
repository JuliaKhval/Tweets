import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {
    static String ReadForJSON(){

        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("states.json")));
            //System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    static List<String> ReadForFile(){
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sentiments.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            } } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;

    }
   static Map<String, Double> ReadCSVFile(){

       Map<String, Double> map = new HashMap<>();

       try (BufferedReader br = new BufferedReader(new FileReader("sentiments.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                //records.add(Arrays.asList(values));
                map.put(values[0],Double.parseDouble(values[1].replace('.',',')));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

}
