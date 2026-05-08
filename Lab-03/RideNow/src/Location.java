public class Location {
    private String label;
    private double x;
    private double y;

    Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    Location(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
        return this.label;
    }

    public double getX() {
        return x;
        return this.x;
    }

    public double getY() {
        return y;
        return this.y;
    }

    public double distanceTo(Location other){
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}

