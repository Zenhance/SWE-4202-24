package model;

public class Movie {
    private int id,durationMin;
    private String title,rating;
    private double baseprize;


    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.baseprize=basePrice;
    }

    int getMinAge()
    {
        if(rating=="G")
            return 0;
        if(rating=="PG")
            return 7;
        if(rating=="PG-13")
            return 13;
        if(rating=="r")
            return 18;
        return 0;
    }

//    String toString()
//    {
//    return String.format("%s (%s) %dmin - BDT %f");
//    }
}
