import java.util.HashMap;
import java.util.List;
import java.util.Map;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        HashMap<String, Double> wordsWeight = Reader.ReadCSVFile();

        TweetAnalyzer tweetAnalyzer = new TweetAnalyzer();
        List<String> tweets = tweetAnalyzer.parseTweets();
        List<String> cordinat = tweetAnalyzer.parseCordinate();
        Map<String, Double> tweetWeight = sentimentAnalyzer.tweetsProcessing(tweets,wordsWeight,cordinat);
        parseJsonFile parseJsonFile = new parseJsonFile();
        StatesAnalyzer statesAnalyzer = new StatesAnalyzer();
        Drowing drowing = new Drowing();
        drowing.MapDrawer();
        drowing.drawMap(statesAnalyzer.getStateForPoint(tweetWeight,parseJsonFile.writeJsonFile()),parseJsonFile.writeJsonFile());





    }
}