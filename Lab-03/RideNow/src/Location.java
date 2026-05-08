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

    public double distanceTo(Location other) {
        double p = this.x - other.x;
        double q = this.y - other.y;

        double distance = Math.sqrt(p*p + q*q);

        return distance;
    }

    public String toString() {
        String l1 = String.format("%s (%.2f, %.2f)", label, x, y);
        return l1;
    }
}
