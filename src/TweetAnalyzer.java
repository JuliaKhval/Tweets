import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetAnalyzer {
    private String filePath;
     public String allText;
    void readTweetsFromJSONFile(String filePath){// сделать регулярные выражения для чтения из файла
        //считать координаты как строку,
    }

    void TweetParser(String allText) {//должен быть лист
        List<Tweet> tweets = null;
        String tweet = "[33.96750648, -84.04567326] _ 2014-02-16 03:14:33 Fast and furious movie";

        // Регулярное выражение для разделения координат и текста твита
        String regex = "\\[(.*?), (.*?)\\] _ .*? .*? (.*$)";


        // Создаем Pattern и Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(allText);

        if (matcher.find()) {
            String latitude = matcher.group(1);
            String longitude = matcher.group(2);
            String tweetText = matcher.group(3);

            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
            System.out.println("Tweet Text: " + tweetText);
        } else {
            System.out.println("Твит не соответствует формату.");
        }

    }
}
