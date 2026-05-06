public class Location {
    private String label="Unknown";
    private final double x;
    private final double y;

    Location(String label,double x,double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    Location(double x,double y){
        this.x=x;
        this.y=y;
    }

    public String getLabel() {
        return label;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }


    public double distanceTo(Location p){
        double dx=p.x-this.x;
        double dy=p.y-this.y;
        return Math.sqrt((dx*dx)+(dy*dy));
    }

    public String toString(){

      return String.format("%s (%.2f, %.2f)",label,x,y);
    }


}
