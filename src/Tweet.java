public class Tweet {
    private double latitude;
    private double longitude;
    private String text;

    private double sentiment;

    // Конструктор
    public Tweet(double latitude, double longitude, String text, double sentiment) {
        this.latitude = latitude;
        this.longitude = longitude;

        this.text = text;
        this.sentiment = sentiment;
    }

    // Геттеры и сеттеры
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
