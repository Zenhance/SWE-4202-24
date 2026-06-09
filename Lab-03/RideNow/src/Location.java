public class Location {

    private String label;
    double x;
    double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
        this.label = "Unknown";
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

    double distanceTo(Location other) {
        double x2 = other.x - this.x;
        double y2 = other.y - this.y;
        return Math.sqrt(x2*x2 + y2*y2);
    }

    public String toString() {
        return String.format("%s (%.2f, %.2f)",label,x,y);
    }
}