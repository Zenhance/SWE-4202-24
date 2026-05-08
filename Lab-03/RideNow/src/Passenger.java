public class Passenger {

    private int id;

    private String name;

    private double rating;


    public Passenger(int id, String name, double rating){

    }

    public Passenger(int id, String name) {

    }

    //getters
    public int getId(int id){

        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void updateRating(double newRating){
        rating = newRating;
    }

}