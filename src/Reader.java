import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reader {


    static List<String> ReadForFile(){
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("texas_tweets2014.txt"))) {
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
   static HashMap<String, Double> ReadCSVFile(){

       HashMap<String, Double> map = new HashMap<>();

       try (BufferedReader br = new BufferedReader(new FileReader("sentiments.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                //records.add(Arrays.asList(values));
                values[1].replace('.',',');
                map.put(values[0],Double.parseDouble(values[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

}
