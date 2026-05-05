public class Location {
    private String label = "Airport";
    private double x;
    private double y;

    public Location(String label, double x, double y){

    }
    public Location(double x, double y){

    }
    public String getLabel(){
        return label;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distanceTo(Location other){

    }
    public String toString(){
        return label;
    }

}
