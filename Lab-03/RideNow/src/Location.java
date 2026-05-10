public class Location {
    private String label;
    private double x;
    private double y;

    Location(String label,double x,double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    Location(double x,double y){
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
    public double getY(){

        return y;
    }
    double distanceToLocation(Location other){
        double d= Math.sqrt((this.x-other.x)*(this.x-other.x)+(this.y-other.y)*(this.y-other.y));
         return d;
    }
    public String toString(){
return String.format("%s (%.2f,%.2f)",label , x, y);
    }
}
