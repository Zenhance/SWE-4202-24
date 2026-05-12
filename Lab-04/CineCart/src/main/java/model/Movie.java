package model;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;

    public Movie(int id, String title, String rating, int duratuinMin, double basePrice)
    {
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getRating(){
        return this.rating;
    }
    public int getDurationMin(){
        return this.durationMin;
    }
    public double getBasePrice(){
        return this.basePrice;
    }
    public int getMinAge(){

    }
    public String toString(){

    }
}
