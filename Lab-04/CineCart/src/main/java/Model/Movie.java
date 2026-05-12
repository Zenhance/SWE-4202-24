package Model;

public class Movie {
    int id;
    String title;
    String rating;
    int durationMin;
    double basePrice;
    int MinAge;

    public Movie(int id, String title, String rating, int
                 durationMin, double basePrice, int MinAge){
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
        this.MinAge=MinAge;
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

    public int getMinAge() {
         if(rating=="G"){
             return 0;
         }else if(rating=="PG"){
             return 7;
         }else if(rating=="PG-13"){
             return 13;
         }else if(rating=="R"){
             return 18;
         }
         return MinAge;
    }
}
