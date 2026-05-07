
import java.lang.classfile.Label;
import java.lang.math;


public class Location {
    private String label;
    double x;
    double y;

    public Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
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





}
