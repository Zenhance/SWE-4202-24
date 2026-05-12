public class Passenger {

<<<<<<< HEAD
    private int id;

    private String name;

    private double rating;


    public Passenger(int id, String name, double rating){

        this.id = id;
        this.name = name;
=======
    private final int    id;
    private final String name;
    private double       rating;

    public Passenger(int id, String name, double rating) {
        this.id     = id;
        this.name   = name;
>>>>>>> master
        this.rating = rating;
    }

    public Passenger(int id, String name) {
<<<<<<< HEAD

        this.id = id;
        this.name = name;
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

=======
        this(id, name, 5.0);   // delegate to full constructor
    }

    public int    getId()     { return id; }
    public String getName()   { return name; }
    public double getRating() { return rating; }

    public void updateRating(double newRating) {
        this.rating = newRating;
    }

    @Override
    public String toString() {
        return String.format("Passenger[%d] %s (%.2f)", id, name, rating);
>>>>>>> master
    }
}