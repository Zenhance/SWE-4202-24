package model;

import java.util.Objects;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;
    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public int getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public int getMinAge(){
        if(Objects.equals(rating, "G")) return 0;
        else if(Objects.equals(rating, "PG")) return 7;
        else if(Objects.equals(rating, "PG-13")) return 13;
        else if(Objects.equals(rating, "R")) return 18;
        else return -1;
    }
    public String toString(){
        return String.format("%s (%s) %d - BDT %.2f",title,rating,durationMin,basePrice);
    }
}