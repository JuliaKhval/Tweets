import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatesAnalyzer {
    private final Map<String, Double> stateWeights = new HashMap<>();

    public StatesAnalyzer() {
    }

    public boolean isPointInPolygon(List<List<Double>> polygon, double x, double y) {
        Polygon polygons = new Polygon();
        for (List<Double> point : polygon) {
            int xi = point.get(0).intValue();
            int yi = point.get(1).intValue();
            polygons.addPoint(xi, yi);
        }

        return polygons.contains(x, y);
    }

    public Map<String, Double> getStateForPoint(Map<String, Double> tweetWeight, Map<String, List<List<List<Double>>>> states) {
        int n = 0;
        double value = 0;
        for (String state : states.keySet()) {
            stateWeights.put(state, 0.0);
        }
        for (Map.Entry<String, List<List<List<Double>>>> entry : states.entrySet()) {
            String stateName = entry.getKey();
            List<List<List<Double>>> polygons = entry.getValue();
            for (List<List<Double>> polygon : polygons) {
                for (String key : tweetWeight.keySet()) {
                    String keyForCord = key.replace("[", "").replace("]", "");
                    String[] splitCoordinates = keyForCord.split(",");
                    double x = Double.parseDouble(splitCoordinates[1].trim());
                    double y = Double.parseDouble(splitCoordinates[0].trim());
                    if (isPointInPolygon(polygon, x, y) && !Double.isNaN(tweetWeight.get(key))) {
                        value = value + tweetWeight.get(key);
                        //stateWeights.put(stateName, stateWeights.getOrDefault(stateName, 0.0) + weight);
                        n++;
                    }
                }
            }
            if (n > 0) {
                stateWeights.put(stateName, value / n);
            } else {
                stateWeights.put(stateName, 0.0);
            }
            n=0;
            value=0;
        }
        return stateWeights;

    }
}
