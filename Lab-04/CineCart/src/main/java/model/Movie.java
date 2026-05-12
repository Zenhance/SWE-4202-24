package model;

public class Movie{
    private final int id;
    private final String title;
    private final String rating;
    private final int durationMin;
    private final double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getRating(){
        return this.rating;
    }
    public int getDurationMin(){
        return this.durationMin;
    }
    public double getBasePrice(){
        return basePrice;
    }

    public int getMinAge(){
        int minAge;
        String r = getRating();
        switch (r) {
            case "G" -> minAge = 0;
            case "PG" -> minAge = 7;
            case "PG-13" -> minAge = 13;
            case "R" -> minAge = 18;
            default -> minAge = -1;
        }
        return minAge;
    }

    // "Inception (PG-13) 148min - BDT 350.00".
    public String toString(){
        return String.format("%s (%s) %d"+"min - BDT %f",
                getTitle(),
                getRating(),
                getDurationMin(),
                getBasePrice());
    }
}