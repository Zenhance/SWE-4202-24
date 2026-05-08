public class Location {

    //a human readable name
    private String label;

    //east coordinate in km
    private double x;

    //north coordinates in km
    private double y;

    public Location(String label, double x, double y){

        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){

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
}