public class Location {

    private final String label;
    private final double x;
    private final double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y)
    {
        this("Unknown", x, y);   //this is called constructor delegation
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
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f, %.2f)", label, x, y);

    }
}
