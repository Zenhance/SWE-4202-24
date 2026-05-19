package model;

public class Movie {
    private int id,durationMin;
    private String title,rating;
    private double basePrize;


    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrize=basePrice;
    }
    public int getId() {
        return id;
    }
    public int getDurationMin() {
        return durationMin;
    }
    public double getBasePrize() {
        return basePrize;
    }
    public String getRating() {
        return rating;
    }
    public String getTitle() {
        return title;
    }
    public double getBasePrice() {
        return basePrize;
    }
    public int getMinAge()
    {
        return switch (rating) {
            case "G" -> 0;
            case "PG" -> 7;
            case "PG-13" -> 13;
            case "r" -> 18;
            default -> 0;
        };
    }

    public String toString()
    {
    return String.format("%s (%s) %dmin - BDT %.2f",title,rating,durationMin,basePrize);
    }

}
