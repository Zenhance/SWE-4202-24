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
        this.rating = 5.0;
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

    @Override
    public String toString() {
        return String.format(
                "Passenger[%d] %s (%.2f)",
                id,
                name,
                rating
        );
    }
}