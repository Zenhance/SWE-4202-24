package model;

public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
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

    public int getDurationMin() {
        return durationMin;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getMinAge() {
        return switch (rating) {
            case "G" -> 0;
            case "PG" -> 7;
            case "PG-13" -> 13;
            case "R" -> 18;
            default -> 0;
        };
    }

    public String toString() {
        return String.format("%s (%s) %dmin - BDT %.2f", title, rating, durationMin, basePrice);
    }
}
