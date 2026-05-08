public class Passenger {
    private int id;
    private String name;
    private double rating;

    public Passenger(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 5.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

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