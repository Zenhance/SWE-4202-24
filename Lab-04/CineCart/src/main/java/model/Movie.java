package model;

public class Movie{
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
    public int getid(){return id;}
    public String gettitle(){return title;}
    public String getrating(){return rating;}
    public int getdurationMin(){return durationMin}
    public double basePrice(){return basePrice;}

    }
}