import java.lang.Math;


public class Location {
    private String Label;
    double x;
    double y;

    public Location(String label, double x, double y){
        this.Label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
        this.Label = "Unknown";
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return Label;
    }

    public double getX() {
        return x;
    }

    public double getY(){
        return y;
    }

    public double distanceTo(Location other){
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double distance;

        distance = Math.sqrt(dx*dx + dy*dy);

        return distance;
    }

    public String toString(){
        return String.format("%s (%.2f, %.2f)", Label, x, y);
    }





}
