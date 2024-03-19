public class Tweet {
    private String latitude;
    private String longitude;
    private String text;

    public double sentiment;

    // Конструктор
    public Tweet() {}

    public Tweet(String latitude, String longitude, String text, double sentiment) {
        this.latitude = latitude;
        this.longitude = longitude;

        this.text = text;
        this.sentiment = sentiment;
    }

    // Геттеры и сеттеры
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
