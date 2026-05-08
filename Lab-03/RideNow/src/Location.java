public class Location {
    private String label="Seoul";
    private double x;
    private double y;

    //Create Constructor
    Location(String label, double x, double y) {
        this.label=label;
        this.x=x;
        this.y=y;
    }

    Location(double x, double y) {
        this.x=x;
        this.y=y;
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
        double newX=other.x;
        double newY=other.y;

        double xDiff=newX-this.x;
        double yDiff=newY-this.y;

        double distance= Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        return distance;
    }

}