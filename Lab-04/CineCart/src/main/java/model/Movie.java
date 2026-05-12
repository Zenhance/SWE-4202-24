package model;

public class Movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }




}
