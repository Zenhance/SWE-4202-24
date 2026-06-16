package model;

public class Movie {
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
        return this.basePrice;
    }
    public int getMinAge(){
        if(rating.equals("G")){
            return 0;
        }
        if(rating.equals("PG")){
            return 7;
        }
        if(rating.equals("PG-13")){
            return 13;
        }
        if(rating.equals("R")){
            return 18;
        }
        return 0;
    }
    public String toString(){
        return String.format("%s (%s) %dmin - BDT %.2f",
                title,rating,durationMin,basePrice);
    }
}
