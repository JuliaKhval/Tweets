import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentimentAnalyzer {


    private HashMap<String, Double> tweetWeight = new HashMap<>();
    private HashMap<String, String> tweets = new HashMap<>();

    public SentimentAnalyzer() {
    }

    public  Map<String, Double> tweetsProcessing(List<String> tweet, HashMap<String, Double> wordsWeight, List<String> cordinat)
    {
        for (int i = 0; i < tweet.size(); i++) {
            tweets.put(cordinat.get(i), tweet.get(i));
        }

        for (Map.Entry<String, String> tweetEntry : tweets.entrySet()) {
            double weight = 0;
            double n = 0;

            for (Map.Entry<String, Double> sentimentEntry : wordsWeight.entrySet()) {
                if (tweetEntry.getValue().contains(sentimentEntry.getKey())) {
                    weight += sentimentEntry.getValue();
                    n++;
                }
            }
            tweetWeight.put(tweetEntry.getKey(), weight / n);
        }

        return tweetWeight;
    }



}

