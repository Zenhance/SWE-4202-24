public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    public Movie (int id, String title, String rating, int durationMin, double basePrice){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getRating(){
        return rating;
    }

    public int getDurationMin(){
        return durationMin;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public int getMinAge(){
        if (rating.equals("G")) return 0;
        if (rating.equals("PG")) return 7;
        if (rating.equals("PG-13")) return 13;
        if  (rating.equals("R")) return 18;
        return -12;
    }

    public String toString(){
        String phunmara = String.format("%s (%s) %dmin - BDT %f",title,rating,durationMin, basePrice);
        return phunmara;
    }
}
