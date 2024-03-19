import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetAnalyzer {
    private String filePath;
    public String allText;


    List<Tweet> TweetParser() {//должен быть лист
        List<Tweet> tweets = null;
        List<String> lines = Reader.ReadForFile();
        //String tweet = "[33.96750648, -84.04567326] _ 2014-02-16 03:14:33 Fast and furious movie";

        // Регулярное выражение для разделения координат и текста твита
        String regex = "\\[(.*?), (.*?)\\] _ .*? .*? (.*$)";

        for (String item : lines) {
            // Создаем Pattern и Matcher
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(item);
            Tweet newTweet = new Tweet();

            if (matcher.find()) {
                newTweet.setLatitude(matcher.group(1));
                newTweet.setLongitude(matcher.group(2));
                newTweet.setText(matcher.group(3));
                tweets.add(newTweet);

            /*System.out.println("Latitude: " + newTweet.getLatitude());
            System.out.println("Longitude: " + newTweet.getLongitude());
            System.out.println("Tweet Text: " + newTweet.getText());
        } else {
            System.out.println("Твит не соответствует формату.");
        }*/

            }

        }
        return tweets;
    }
}
