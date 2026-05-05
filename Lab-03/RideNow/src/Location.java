public class Location {
    private String label;
    private double x;
    private double y;
    Location(String label,double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    Location(double x, double y){
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
    double getY(){
        return y;
    }
    double distanceTo(Location Other){
        double distance=Math.sqrt(Math.pow((Location.x-Other.x))+Math.pow((Location.y-Other.y)));
    }
    String toString(){
        String output=label+"("+x+","+y+")";
        return output;
    }
}
