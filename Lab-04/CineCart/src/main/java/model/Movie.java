package model;

public class Movie {

    private int id;
    private String title;
    private String rating;
    private int duration;
    private double basePrice;

    public Movie(int id, String title, String rating,
                 int duration, double basePrice) {

        this.id = id;
        this.title = title;
        this.rating = rating;
        this.duration = duration;
        this.basePrice = basePrice;
    }

    public String getTitle() {
        return title;
    }

    public double getBasePrice() {
        return basePrice;
    }
}