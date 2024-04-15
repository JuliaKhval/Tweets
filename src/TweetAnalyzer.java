import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetAnalyzer {
    private List<String> list;

    private List<String> coordinates = new ArrayList<>();
    private List<String> tweets = new ArrayList<>();

    public List<String> parseCordinate() {
        list = Reader.ReadForFile();

        String regex = "(.+)\\t_\\t(.+)\\t(.+)";

        Pattern pattern = Pattern.compile(regex);

        for (String input : list) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String cordinate = matcher.group(1);
                coordinates.add(cordinate);
            }
        }
        return coordinates;
    }

    public List<String> parseTweets() {
       list = Reader.ReadForFile();

        String regex = "(.+)\\t_\\t(.+)\\t(.+)";

        Pattern pattern = Pattern.compile(regex);

        for (String input : list) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String tweet = matcher.group(3);
                tweets.add(tweet);
            }
        }
        return tweets;
    }

        // Регулярное выражение для разделения координат и текста твита
        String regex = "\\[(.*?), (.*?)\\] _ .*? .*? (.*$)";


}
