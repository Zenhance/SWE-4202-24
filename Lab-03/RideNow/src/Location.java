public class Location {
    private String label;
    double x;
    double y;
    public Location(String label, double x, double y){
        this.x=x;
        this.y=y;
        this.label=label;
    }
    public Location(double x, double y){
        this.x=x;
        this.y=y;
        this.label="Unknown";
    }
    public String getLabel(){
        return this.label;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double distanceTo(Location other){

    }
}
