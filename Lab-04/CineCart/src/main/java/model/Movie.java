package model;

public class Movie {
    private final int id,durationMin;
    private final String title,rating;
    private final double basePrice;


    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice =basePrice;
    }
    public int getId() {
        return id;
    }
    public int getDurationMin() {
        return durationMin;
    }

    public String getRating() {
        return rating;
    }
    public String getTitle() {
        return title;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public int getMinAge()
    {
        return switch (rating) {
            case "G" -> 0;
            case "PG" -> 7;
            case "PG-13" -> 13;
            case "R" -> 18;
            default -> -1;
        };
    }

    public String toString()
    {
    return String.format("%s (%s) %dmin - BDT %.2f",title,rating,durationMin, basePrice);
    }

}
