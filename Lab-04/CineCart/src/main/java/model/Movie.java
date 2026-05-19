package model;

public class Movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;
    public Movie(int id,String title,String rating,int durationMin,double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }
    public int getid(){
        return id;
    }
    public String gettitle(){
        return title;
    }
    public String getrating(){
        return rating;
    }
    public int getdurationMin(){
        return durationMin;
    }
    public double getbasePrice(){
        return basePrice;
    }
    public int getMinAge(){
        switch(rating){
            case "G":
                return 0;
            case "PG":
                return 7;
            case "PG-13":
                return 13;
            case "R":
                return 18;
            default:
                return 0;
        }
    }
    public String toString(){
        return title+" ("+getMinAge()+") "+durationMin+
                "min - BDT"+basePrice;
    }
}
