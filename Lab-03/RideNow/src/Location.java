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
        this.x=x;
        this.y=y;
        this.label="unknown";
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
        double x2 = other.x-this.x;
        double y2 = other.y-this.y;
        return Math.sqrt(x2+y2);
    }

    public String toString(){
        return label+" ("+x+", "+y+")";
    }
}
