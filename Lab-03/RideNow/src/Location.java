public class Location {

<<<<<<< HEAD
    //a human readable name
    private String label;

    //east coordinate in km
    private double x;

    //north coordinates in km
    private double y;

    public Location(String label, double x, double y){

=======
    private final String label;
    private final double x;
    private final double y;

    public Location(String label, double x, double y) {
>>>>>>> master
        this.label = label;
        this.x = x;
        this.y = y;
    }

<<<<<<< HEAD
    public Location(double x, double y){

        this.x = x;
        this.y = y;
    }

    public String getLabel(String label) {
        return label;
    }

    public double getX(double x) {
        return x;
    }

    public double getY(double y) {
        return y;
    }

    public double distanceTo(Location other){
        double distance = Math.sqrt( (Math.pow((this.x - other.x), 2) - Math.pow((this.y - other.y), 2) ) );

        return distance;

    }

    public static void toString(String label ){

        System.out.println("label" + ());
    }
}
=======
    public Location(double x, double y)
    {
        this("Unknown", x, y);   //this is called constructor delegation
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
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f, %.2f)", label, x, y);

    }
}
>>>>>>> master
