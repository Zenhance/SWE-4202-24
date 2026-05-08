public class Location {
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y) {
        this.label = "Unknown";
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
        double dx = other.x - this.x; // difference of x1, x2, (x1 - x2)
        double dy = other.y - this.y; // difference of y1, y2, (y1 - y2)
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance;
    }

    public String toString() {
        String lokeshon = String.format("%s (%.2f, %.2f)", label, x, y);

        return lokeshon;
    }
}
