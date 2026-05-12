package model;

public class Movie{
    private int id;
    private String title;
    private int durationMin;
    private double basePrice;
    private String rating;


    public Movie(int id, String title, int durationMin,
                 double basePrice, String Rating){
        this.id = id;
        this.title = title;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
        this.rating = rating;
    }

    public int getId(){
        return id;
    }
    public String getTitle()
    {
        return title;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getRating(){
        return rating;
    }

    public int getMinAge() {
        if (rating == "G") {
            return 0;
        } else if (rating == "PG") {
            return 7;
        } else if (rating == "PG-13") {
            return 13;
        } else if (rating == "R") {
            return 18;
        }
    }

}








