package model;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;
    public Movie(int id,String title,String rating,int durationMin,double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
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
        if(this.title =="G")return 0;
        else if(this.title =="PG")return 7;
        else if(this.title =="PG-13")return 13;
        else if(this.title=="R")return 18;
    }
    public String toString(){
        return "Inception "+"("+"PG-13"+") "+this.durationMin+" -BDT "+String.format(.02%f,this.basePrice);
    }
}
