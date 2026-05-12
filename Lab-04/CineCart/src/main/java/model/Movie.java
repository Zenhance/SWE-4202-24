package model;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;

    Movie(int id,String title,String rating,int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.basePrice=basePrice;

    }
    public int getMinAge() {
        if (rating == "G") {
            return 0;
        }
        else if (rating == "PG") {
            return 7;
        }
        else if (rating == "PG-13") {
            return 13;
        }
        else if (rating == "R") {
            return 18;
        }
        else{
            return -1;
        }
    }
    public String toString(){
        return String.format("%s (%s) %dmin - BDT %.2f", title, rating ,durationMin,basePrice);
    }
}
