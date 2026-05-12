package model;

public class Movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;
}
//constructor
public Movie(int id,String title,String rating,int durationMin,double basePrice){
    this.id=id;
    this.title=title;
    this.rating=rating;
    this.duration=durationMin;
    this.basePrice=basePrice;
}
//getters
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