package model;

public class Movie {
    int id;
    String Title;


    public int getId() {
        return id;
    }

    String rating;
    int durationMin;
    double basePrice;
    public Movie(int id,String title,String rating,int durationMin,double basePrice){
        this.id=id;
        this.Title =title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }
    public String getTitle(){
        return Title;
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
    public int getMinAge() {
        if(rating.equals("G")) {
            return 0;
        } else if (rating.equals("PG")) {
            return 7;
        } else if (rating.equals("PG-13")) {
            return 13;
        } else if (rating.equals("R")) {
            return 18;
        }
        return 0;
    }
    public String toString(){
        return String.format(Title+"("+rating+")"+durationMin+"min"+"- BDT "+basePrice);
    }
}
