package model;

public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getRating(){
        return rating;
    }

    public int getDurationMin(){
        return durationMin;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public int getMinAge(){
        if(rating == "G") return 0;
        if(rating == "PG") return 7;
        if(rating == "PG-13")
            return 13;
        if(rating == "R")
            return 18;
    return 0;
    }
    public String toString(){
        String ans2 = String.format("%s (%s) %dmin - BDT %.2lf", title, rating, durationMin, basePrice);
        return ans2;
    }
}
