public class Passenger {

    private int id;
    private String name;
    private double rating;

    // Full constructor
    public Passenger(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    // Default rating constructor
    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 5.0; // default rating
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    // Update rating
    public void updateRating(double newRating) {
        this.rating = newRating;
    }

    // String representation
    public String toString() {
        return "Passenger[" + id + "] " + name + " ("
                + String.format("%.2f", rating) + ")";
    }
}
