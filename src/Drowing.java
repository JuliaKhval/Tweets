import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Drowing {
    private BufferedImage image;
    private Graphics2D g;

    public Drowing() {
    }

    public void MapDrawer() {
        int height = 2000;
        int width = 4000;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
    }
    private Color getStateColor(Double weight, double min, double max)
    {
        double i = 2 * ((weight - min) / (max - min)) - 1;
        if(weight!=0)
        {
            if (i >= -1 && i <= -0.5)
                return Color.BLUE;
            else if (i > -0.5 && i <= -0.2)
                return Color.YELLOW;
            else if (i > -0.2 && i <= -0.1)
                return Color.GREEN;
            else if (i > -0.1 && i <= 0.6)
                return Color.cyan;
            else if (i > 0.6 && i <= 1)
                return Color.red;
        }
        return Color.DARK_GRAY;
    }
    public void drawMap(Map<String, Double> tweetWeight,Map<String, List<List<List<Double>>>> states) {
        Double min = Collections.min(tweetWeight.values());
        Double max = Collections.max(tweetWeight.values());
        for (Map.Entry<String, java.util.List<java.util.List<java.util.List<Double>>>> entry : states.entrySet()) {
            String state = entry.getKey();
            Double weight = tweetWeight.get(state);
            Color stateColor = getStateColor(weight,min,max);
            g.setColor(stateColor);
            for (java.util.List<java.util.List<Double>> polygon : entry.getValue()) {
                drawPolygon(polygon);
            }
        }
        File outputImageFile = new File("USA.png");
        try {
            javax.imageio.ImageIO.write(image, "png", outputImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void drawPolygon(List<List<Double>> polygon) {
        int[] xPoints = new int[polygon.size()];
        int[] yPoints = new int[polygon.size()];
        for (int i = 0; i < polygon.size(); i++) {
            double x = polygon.get(i).get(0);
            double y = polygon.get(i).get(1);
            xPoints[i] = (int) (4000 + x * 20);
            yPoints[i] = (int) (2000 - y * 20);
        }
        Color currentColor = g.getColor();
        g.fillPolygon(xPoints, yPoints, polygon.size());
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, polygon.size());
        g.setColor(currentColor);
    }
}
