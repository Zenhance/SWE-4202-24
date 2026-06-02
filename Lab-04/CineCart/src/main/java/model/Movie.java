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
    public int getMinage(){

        if (rating.equals("G"))
            return 0;
        if (rating.equals("R"))
            return 18;
        if (rating.equals("PG-13"))
            return 13;
        if (rating.equals("PG"))
            return 7;
        return 0;
    }

    public String toString() {
        String string = String.format("%s (%s) %dmin - BDT %.2f", title, rating, durationMin, besePrice);
        return string;
    }

}


