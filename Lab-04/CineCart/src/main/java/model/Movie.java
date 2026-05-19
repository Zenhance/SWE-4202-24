package model;

import java.time.Duration;

public class Movie {
    private int id;
    private String title;
    private int durationMin;
    private double besePrice ;
    private String rating;

    public Movie (int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.besePrice = basePrice;

    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public int getDurationMin(){
        return durationMin;
    }

    public double getBesePrice() {
        return besePrice;
    }
}