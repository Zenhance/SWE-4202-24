package model;
public class Movie {
    private int id;
    private String title;
    private int durationMin;
    private double besePrice ;
    private String rating;

    public Movie (int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.besePrice = basePrice;

    }


    public int getMinAge() {
        return
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }


}