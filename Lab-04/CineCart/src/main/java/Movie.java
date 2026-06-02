public class Movie {
    private int id;
    private String title;
    private String rating;
    private int durationmin;
    private double baseprice;


    public Movie(int id, String title, String rating, int durationmin, double baseprice) {

        this.id = id;
        this.title = title;
        this.rating = rating;
        this.durationmin = durationmin;
        this.baseprice = baseprice;
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

    public int getDurationmin(){
        return durationmin;
    }

    public double getBasePrice(){
        return baseprice;
    }

    public int getMinAge(){
        switch(rating){
            case "G": return 0;
            case "PG": return 7;
            case "PG-13": return 13;
            case "R": return 18;
            default: return 0;
        }
    }

    public String toString(){
        return String.format("%s %s %d %.2f",
                title, rating, durationmin, baseprice);
    }


}