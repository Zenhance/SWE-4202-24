public class Passenger {
    private int id;
    private String name;
    double rating;

    Passenger(int id, String name, double rating){
        this.id=id;
        this.name=name;
        this.rating=rating;
    }

    Passenger(int id, String name){
        rating=5.0;
        this.id=id;
        this.name=name;
    }

    public int getId(){

        return id;
    }

    public String getName(){

        return name;
    }

    public double getRating(){

        return rating;
    }

    public void updateRating(double newRating){
        this.rating=newRating;
    }



}
