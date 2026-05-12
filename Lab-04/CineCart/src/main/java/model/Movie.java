package model;

public class Movie {
    private int  id;
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

    public double getBasePrice() {
        return basePrice;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public int getMinAge() {
        if (rating.compareTo("G") == 0) {
            return 0;
        } else if (rating.compareTo("PG") == 0) {
            return 7;
        } else if (rating.compareTo("PG-13") == 0) {
            return 13;
        } else if (rating.compareTo("R") == 0) {
            return 18;
        }
       return 0;
    }

    public String toString() {
        return title + " (" + rating + ") " + durationMin + " min - BDT " + String.format("%.2f", basePrice);
    }


}
