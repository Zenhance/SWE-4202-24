package model;

import java.util.Objects;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    // Setting up getters
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
        int age;

        if (Objects.equals(rating, "G")) {
            age = 0;
        } else if (Objects.equals(rating, "PG")) {
            age = 7;
        } else if (Objects.equals(rating, "PG-13")) {
            age = 13;
        } else age = 18;

        return age;
    }

    public String toString() {
        return String.format("%s (%s) %d - BDT %.2f",title , rating, durationMin,basePrice);
    }
}