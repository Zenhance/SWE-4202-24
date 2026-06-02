package model;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice)
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
        if(getRating()=="G"){
            return 0;
        }
        if(getRating()=="PG"){
            return 7;
        }
        if(getRating()=="PG-13"){
            return 13;
        }
        if(getRating()=="R"){
            return 18;
        }
    }
    public String toString(){

    }
}
