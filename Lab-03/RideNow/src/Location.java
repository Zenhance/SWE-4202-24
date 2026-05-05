//Part A
public class Location {
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label = label;
        this.x=x;
        this.y =y;
    }

    public Location(double x, double y){
        label="Unknown";
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

    public double distanceTo(Location other){
        double x_d=other.x-this.x;
        double y_d=other.y-this.y;
        double dis = Math.sqrt(x_d*x_d + y_d*y_d);

        return dis;
    }

    public String toString(){

    }
}