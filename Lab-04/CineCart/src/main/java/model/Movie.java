package model;

public class Movie {

    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;
    private int minAge;
    private String String;

    public Movie(int id, String title, String rating, int durationMin,
                 double basePrice, int minAge, String String) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
        this.minAge = minAge;
        this.String = String;
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
//    public int getMinAge(){
//        return minAge;
//    }
//    public String String(){
//        return String;
//    }

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
                return -1;

        }
    }
}