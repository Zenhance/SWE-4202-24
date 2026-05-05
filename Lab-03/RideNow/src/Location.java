public class Location {
    private String label;
    private double x;
    private double y;
    Location(String label, double x, double y)
    {
        this.label=label;
        this.x=this.x;
        this.y=y;
    }
    Location(double x, double y)
    {
        label="Unknown";
        this.x=x;
        this.y=y;
    }
    getLabel()
    {
        return label;
    }
    getX()
    {
        return x;

    }
    getY(){ return y;
    }
    double distanceTo(Location other){

    }
}
