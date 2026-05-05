//Part A
public class Location {
    private final String label;
    private final double x;
    private final double y;
    
    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
    
    public Location(double x, double y) {
        label = "Unknown";
        this.x = x;
        this.y = y;
    }
    
    public String getLabel() {
        return label;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double distanceTo(Location other) {
        double x_d = other.x - this.x;
        double y_d = other.y - this.y;
        
        return Math.sqrt(x_d * x_d + y_d * y_d);
    }
    
    public String toString() {
        return String.format("%s (%.2f, %.2f)", label, x, y);
    }
}