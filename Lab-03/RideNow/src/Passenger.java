//Part B
public class Passenger {
    
    private final int id;
    private final String name;
    private double rating;
    
    Passenger(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
    
    Passenger(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 5.0;
    }
    
    int getId() {
        return id;
    }
    
    String getName() {
        return name;
    }
    
    double getRating() {
        return rating;
    }
    
    void updateRating(double newRating) {
        this.rating = newRating;
    }
    
    public String toString() {
        return String.format("Passenger[%d] %s (%.2f)", id, name, rating);
    }
}

