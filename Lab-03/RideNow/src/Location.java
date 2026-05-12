public class Location {
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;

    }
    public Location(double x, double y){
        this.label="Unknown";
        this.x=x;
        this.y=y;
    }
    String getLabel(){
        return label;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }

    public double distanceTo(Location other){
        double distance= Math.sqrt((Math.pow(this.x-other.x,2))+(Math.pow(this.y-other.y,2)));
        return distance;
    }
    public String toString(){
        return String.format("%s (%.2f, %.2f)",label,x,y);
    }

}
