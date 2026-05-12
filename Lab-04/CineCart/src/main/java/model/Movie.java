package model;

public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    // constructor
    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    // Getter methods
    public int getId() {
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
        int res = 0;
        if (rating == "G"){
            res = 0;
        }
        else if (rating == "PG"){
            res = 7;
        }
        else if (rating == "PG-13"){
            res = 13;
        }
        else if (rating == "R"){
            res = 18;
        }
        return res;
    }

    public String toString(){
        return title + " (" + rating + ") " + durationMin + "min - BDT " + String.format("%.2f", basePrice);
    }

}
