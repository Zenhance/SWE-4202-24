public class Movie {

    //fields
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    //constructors
    public Movie(int id, String title, String rating, int durationMin, double basePrice) {

        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    //getters
    public int getId(int id){
        return id;
    }

    public String getTitle(String title) {
        return title;
    }

    public String getRating(int durationMin) {
        return rating;
    }

    public int getDurationMin(int durationMin) {
        return durationMin;
    }

    public double getBasePrice(double basePrice) {
        return basePrice;
    }

    //methods
    public int getMinAge(String rating){

        if (rating == "G")
            return 0;
        else if (rating == "PG")
            return 7;
        else if (rating == "PG-13")
            return 13;
        else if (rating == "R")
            return 18;
    }

    public String toString(String title, String rating, int durationMin, double basePrice) {

        String s = title + "(" + rating + getMinAge() + ")" + durationMin + "min BDT " + basePrice;

        return s;

    }
}