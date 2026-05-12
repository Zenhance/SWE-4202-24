package model;

public class Movie{
    private int id;
    private String title;
    private int durationMin;
    private double basePrice;

    public Movie(int id, String title, int durationMin,
                 double basePrice){
        this.id = id;
        this.title = title;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }
}