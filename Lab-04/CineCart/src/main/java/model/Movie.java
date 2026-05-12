package model;

public class Movie {
    public int id;
    public String title;
    public String rating;
    public int durationMin;
    public double basePrice;

    //constructor
    public Movie(int id, String title, String rating, int durationMin, double basePrice) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    //getters
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
        switch (rating) {
            case "G":
                return 0;
            case "PG":
                return 7;
            case "PG-13":
                return 13;
            case "R":
                return 18;
            default:
                return 0;
        }
    }

}