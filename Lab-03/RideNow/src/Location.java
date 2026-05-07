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
        System.out.println(label + " " + "(" + x + "," + " " + y + ")");
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

    public double distanceTo(Location location) {
        return Math.sqrt(Math.pow(this.x - location.x, 2) + Math.pow(this.y - location.y, 2));
    }

    public String toString() {
        return (label + " " + "(" + String.format("%.2f", x) + "," + " " + String.format("%.2f", y) + ")");
    }
}
