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

    public double distanceTo(Location other){
        double distance = Math.sqrt( (Math.pow((this.x - other.x), 2) - Math.pow((this.y - other.y), 2) ) );

        return distance;

    }

    public static void toString(String label ){

        System.out.println("label" + ());
    }
}