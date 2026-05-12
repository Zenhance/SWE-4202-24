public class Movie {

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
    public int getId(){
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

    //methods
    public getMinAge(String rating){

        if (rating = "G")
            return 0;
        else if (rating = "PG")
            return 7;
        else if (rating = "PG-13")
            return 13;
        else if (rating = "R")
            return 18;
    }

    public String toString(String title, String rating, int durationMin, double basePrice) {

        System.out.println(title + " (" + rating + ") " + durationMin + " - BDT" + basePrice)
        ;

    }
}