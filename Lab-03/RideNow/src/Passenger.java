public class Passenger {
    int id;
    String name;
    double rating;
    Passenger(int id,String name, double rating){
        this.id=id;
        this.name=name;
        this.rating=rating;
    }
    Passenger(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(int id){
    return id;
    }
    public String getName(String name){
     return name;
    }
    public double getRating(double rate){
         return rate;
    }
    public void updateRating(double newRating){
        rating= newRating;
    }
    public String toString(String name, int id, double rating){
    return String.format(Passenger[%d] %s (%0.2f), id,name,id,rating);
    }

}
