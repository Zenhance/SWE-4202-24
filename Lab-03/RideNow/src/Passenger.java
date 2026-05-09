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

    public String getName(String name) {
        return name;
    }

    public double getRating(double rating) {
        return rating;
    }

    public static void updateRating(double newRating){
        rating = newRating;
    }

    public static String toString(String name, int id, double rating) {
        System.out.println("Passenger[" + id + "] " + name +" (" + rating + " )");

    }
}