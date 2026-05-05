import static java.lang.Math.sqrt;

public class Location {

    private String label = "Unknown";
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

    public String getLabel(){
        String label = this.label;
        return label;
    }

    public double getX(){
        double x = this.x;
        return x;
    }
    public double getY(){
        double y = this.y;
        return y;
    }

    public double distanceTo(Location other) {
        double x1 = this.getX();
        double y1 = this.getY();
        double x2 = other.getX();
        double y2 = other.getY();

        double distance = sqrt((x2-x2)*(x2-x1) + (y2-y1)*(y2-y1));
        return distance;
    }

    public String toString(){

        String label = getLabel();
        double x = getX();
        double y = getY();

        String x_str = String.valueOf(x);
        String y_str = String.valueOf(y);

        String output;
        output = label.concat(" (");
        output = output.concat(x_str);
        output = output.concat(", ");
        output = output.concat(y_str);
        output = output.concat(")");

        return output;
    }
}
